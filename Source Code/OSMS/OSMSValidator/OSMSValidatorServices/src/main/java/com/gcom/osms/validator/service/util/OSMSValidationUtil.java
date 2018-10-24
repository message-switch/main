/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 
 * The class OSMSValidationUtil contains utility methods
 *
 */
public class OSMSValidationUtil {

	/**
	 * Check date is valid date for given format
	 * @param inDate
	 * @param format
	 * @return
	 */
	public static boolean isValidDate(String inDate, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
}
