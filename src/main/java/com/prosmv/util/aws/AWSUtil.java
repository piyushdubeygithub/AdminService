package com.prosmv.util.aws;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.prosmv.service.aws.BucketService;

/**
 * This class is a utility class for aws configuration.
 * 
 * @author piyush
 *
 */
@Service
public class AWSUtil implements BucketService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSUtil.class);

	private static final String SUFFIX = "/";

	private static final String DEV = "dev";

	@Value("${aws.access.key}")
	private String awsAccessKey;

	@Value("${aws.secret.key}")
	private String awsSecretKey;

	@Value("${aws.image.bucket.name}")
	private String awsImageBucketName;

	@Value("${aws.video.bucket.name}")
	private String awsVideoBucketName;

	@Value("${aws.image.folder.path}")
	private String awsImageBucketFolderName;

	@Value("${aws.video.folder.path}")
	private String awsVideoBucketFolderName;

	@Value("${aws.download.local.path}")
	private String awsFileDownloadLocalPath;

	/**
	 * This method will used to get {@link AmazonS3}.
	 * 
	 * @return {@link AmazonS3}
	 */
	private AmazonS3 getAmazonS3Client() {
		LOGGER.info("creating aws client object");
		AWSCredentials credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_SOUTH_1).build();
	}

	/**
	 * This method is used to create image bucket where all the images will be
	 * stored.
	 */
	private void createAWSImageBucket() {
		LOGGER.info("creating aws image bucket");
		AmazonS3 amazonS3 = getAmazonS3Client();
		if (!amazonS3.doesBucketExist(awsImageBucketName)) {
			try {
				amazonS3.createBucket(awsImageBucketName);
			} catch (AmazonServiceException amazonServiceException) {
				LOGGER.error("An exception has been occured while creating bucket {} with exception message {} ",
						awsImageBucketName, amazonServiceException.getErrorMessage());
			}
		}
	}

	/**
	 * This method is used to create video bucket where all the videos will be
	 * stored.
	 */
	private void createAWSVideoBucket() {
		LOGGER.info("creating aws video bucket");
		AmazonS3 amazonS3 = getAmazonS3Client();
		if (!amazonS3.doesBucketExist(awsVideoBucketName)) {
			amazonS3.createBucket(awsVideoBucketName);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void uploadImageToBucket(File file) {
		createAWSImageBucket();
		getAmazonS3Client().putObject(awsImageBucketName,
				DEV + SUFFIX + awsImageBucketFolderName + SUFFIX + file.getName(), file);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteImageFromBucket(String fileName) {
		getAmazonS3Client().deleteObject(awsImageBucketName,
				DEV + SUFFIX + awsImageBucketFolderName + SUFFIX + fileName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getImageFromBucket(String fileName) {
		S3Object s3object = getAmazonS3Client().getObject(awsImageBucketName,
				DEV + SUFFIX + awsImageBucketFolderName + SUFFIX + fileName);
		LOGGER.info("S3 Object key {} ", s3object.getKey());
		LOGGER.info("S3 Object redirect location {} ", s3object.getRedirectLocation());
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		try {
			FileUtils.copyInputStreamToFile(inputStream, new File(awsFileDownloadLocalPath + fileName));
		} catch (IOException e) {
			LOGGER.error("unable to copy file {} from {} bucket to {} ", fileName, awsImageBucketName,
					awsFileDownloadLocalPath);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ObjectListing getAllImagesFromBucket() {
		return getAmazonS3Client().listObjects(awsImageBucketName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void uploadVideoToBucket(File file) {
		createAWSVideoBucket();
		createAWSImageBucket();
		getAmazonS3Client().putObject(awsVideoBucketName,
				DEV + SUFFIX + awsVideoBucketFolderName + SUFFIX + file.getName(), file);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteVideoFromBucket(String fileName) {
		getAmazonS3Client().deleteObject(awsImageBucketName,
				DEV + SUFFIX + awsVideoBucketFolderName + SUFFIX + fileName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getVideoFromBucket(String fileName) {
		S3Object s3object = getAmazonS3Client().getObject(awsVideoBucketName,
				DEV + SUFFIX + awsImageBucketFolderName + SUFFIX + fileName);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		try {
			FileUtils.copyInputStreamToFile(inputStream, new File(awsFileDownloadLocalPath + fileName));
		} catch (IOException e) {
			LOGGER.error("unable to copy file {} from {} bucket to {} ", fileName, awsImageBucketName,
					awsFileDownloadLocalPath);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ObjectListing getAllVideoFromBucket() {
		return getAmazonS3Client().listObjects(awsVideoBucketName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Bucket> getAllBuckets() {
		return getAmazonS3Client().listBuckets();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Grant> getAllTheAccessControlListForImageBucket() {
		AccessControlList accessControlList = getAmazonS3Client().getBucketAcl(awsImageBucketName);
		return accessControlList.getGrantsAsList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Grant> getAllTheAccessControlListForVideoBucket() {
		AccessControlList accessControlList = getAmazonS3Client().getBucketAcl(awsVideoBucketName);
		return accessControlList.getGrantsAsList();
	}

}
