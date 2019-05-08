package com.prosmv.service.aws;

import java.io.File;
import java.util.List;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.ObjectListing;

/**
 * This is an interface containing all the methods declaration of AWS Bucket
 * related service.
 * 
 * @author piyush
 *
 */
public interface BucketService {

	/**
	 * This method will be used to upload the image to the aws image bucket.
	 * 
	 * @param file {@link File}
	 */
	public void uploadImageToBucket(File file);

	/**
	 * This method will be used to delete the image from aws image bucket.
	 * 
	 * @param fileName name of file you want to delete
	 */
	public void deleteImageFromBucket(String fileName);

	/**
	 * This method will be used to get image from aws image bucket.
	 * 
	 * @param fileName name of the file you want to get
	 */
	public void getImageFromBucket(String fileName);

	/**
	 * This method will get all the images from aws image path.
	 * 
	 * @return {@link ObjectListing}
	 */
	public ObjectListing getAllImagesFromBucket();

	/**
	 * This method will be used to upload video to aws video bucket.
	 * 
	 * @param file {@link File}
	 */
	public void uploadVideoToBucket(File file);

	/**
	 * This method will be used to delete video from aws video bucket.
	 * 
	 * @param fileName name of file you want to delete
	 */
	public void deleteVideoFromBucket(String fileName);

	/**
	 * This method will be used to get video from aws video bucket.
	 * 
	 * @param fileName name of file you want to get
	 */
	public void getVideoFromBucket(String fileName);

	/**
	 * This method will be used to get all videos from aws video bucket.
	 * 
	 * @return {@link ObjectListing}
	 */
	public ObjectListing getAllVideoFromBucket();

	/**
	 * This method will get all the buckets in aws.
	 * 
	 * @return {@link List} of {@link Bucket}
	 */
	public List<Bucket> getAllBuckets();

	/**
	 * This method will get all the permissions allowed to the image bucket in aws.
	 * 
	 * @return {@link List} of {@link Grant}
	 */
	public List<Grant> getAllTheAccessControlListForImageBucket();

	/**
	 * This method will get all the permissions allowed to the video bucket in aws.
	 * 
	 * @return {@link List} of {@link Grant}
	 */
	public List<Grant> getAllTheAccessControlListForVideoBucket();

}
