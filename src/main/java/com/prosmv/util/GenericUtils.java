package com.prosmv.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.prosmv.domain.User;

/**
 * This class is utility class used for serveral purpose.
 * @author piyush
 *
 */
public class GenericUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericUtils.class);
	
	/**
	 *	This method is used to get logged in user.
	 */
	public static User getLoggedInUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public static Timestamp getDateFormat(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = simpleDateFormat.format(date);
		Timestamp timeStamp = null;
	    try {
			Date parsedDate = simpleDateFormat.parse(dateString);
			 timeStamp = new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeStamp;
	}
	
}
