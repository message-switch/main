/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.exception;

import com.gcomsoft.fwk.exception.AppException;

/**
 * 
 * The class OSMSValidationsServiceException used to create custom exceptions
 *
 */
public class OSMSValidatorServiceException extends AppException {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 632314511238248136L;

	/**
	 * Instantiate OSMSValidationsServiceException with errorCode
	 * @param errorCode
	 */
	public OSMSValidatorServiceException(String errorCode) {
		super(errorCode);
	}
	
	/**
	 * Instantiate OSMSValidationsServiceException with errorCode and parameters
	 * @param errorCode
	 * @param parameters
	 */
	public OSMSValidatorServiceException(final String errorCode, final Object[] parameters) {
		super(errorCode, parameters);
	}
	
	/**
	 * Instantiate OSMSValidationsServiceException with errorCode and parameters and Throwable
	 * @param errorCode
	 * @param parameters
	 * @param cause
	 */
	public OSMSValidatorServiceException(final String errorCode,
			final Object[] parameters, final Throwable cause) {
		super(errorCode, parameters, cause);
	}

	/**
	 * Instantiate OSMSValidationsServiceException with errorCode and Throwable
	 * @param errorCode
	 * @param cause
	 */
	public OSMSValidatorServiceException(final String errorCode, final Throwable cause) {
		super(errorCode, cause);
	}
	
	/**
	 * Get bundle name
	 */
	@Override
	public String getBundleName() {
		return OSMSValidatorServiceExceptionCodes.CATALOG;
	}

	/**
	 * Get category
	 */
	@Override
	public String getCategory() {
		return OSMSValidatorServiceExceptionCodes.CATEGORY;
	}
 
}
