/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.exception;

import com.gcomsoft.fwk.exception.AppException;
/**
 * The class OSMSMessageLogServiceException
 *
 */
public class OSMSMessageLogServiceException extends AppException {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 632314511238248136L;

	/**
	 * Instantiate OSMSMessageLogServiceException with errorCode
	 * @param errorCode
	 */
	public OSMSMessageLogServiceException(String errorCode) {
		super(errorCode);
	}
	
	/**
	 * Instantiate OSMSMessageLogServiceException with errorCode and parameters
	 * @param errorCode
	 * @param parameters
	 */
	public OSMSMessageLogServiceException(final String errorCode, final Object[] parameters) {
		super(errorCode, parameters);
	}
	
	/**
	 * Instantiate OSMSMessageLogServiceException with errorCode and parameters and Throwable
	 * @param errorCode
	 * @param parameters
	 * @param cause
	 */
	public OSMSMessageLogServiceException(final String errorCode,
			final Object[] parameters, final Throwable cause) {
		super(errorCode, parameters, cause);
	}

	/**
	 * Instantiate OSMSMessageLogServiceException with errorCode and Throwable
	 * @param errorCode
	 * @param cause
	 */
	public OSMSMessageLogServiceException(final String errorCode, final Throwable cause) {
		super(errorCode, cause);
	}
	
	/**
	 * Get bundle name
	 */
	@Override
	public String getBundleName() {
		return OSMSMessageLogServiceExceptionCodes.CATALOG;
	}

	/**
	 * Get category
	 */
	@Override
	public String getCategory() {
		return OSMSMessageLogServiceExceptionCodes.CATEGORY;
	}
 
}
