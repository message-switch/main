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

import com.gcomsoft.fwk.exception.AppRuntimeException;

/**
 * 
 * The class OSMSValidationsServiceRuntimeException used to create custom exceptions for runtime exceptions
 *
 */
public class OSMSValidatorServiceRuntimeException extends AppRuntimeException {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = -3175786809805863966L;

	/**
	 * Instantiate OSMSValidationsServiceRuntimeException with errorCode
	 * @param errorCode
	 */
	public OSMSValidatorServiceRuntimeException(String errorCode) {
		super(errorCode);
	}

	/**
	 * Instantiate OSMSValidationsServiceRuntimeException with errorCode and parameters
	 * @param errorCode
	 */
	public OSMSValidatorServiceRuntimeException(String errorCode,
			Object[] parameters) {
		super(errorCode, parameters);
	}

	/**
	 * Instantiate OSMSValidationsServiceRuntimeException with errorCode and Throwable
	 * @param errorCode
	 */
	public OSMSValidatorServiceRuntimeException(String errorCode,
			Throwable cause) {
		super(errorCode, cause);
	}

	/**
	 * Instantiate OSMSValidationsServiceRuntimeException with errorCode and parameters and Throwable
	 * @param errorCode
	 */
	public OSMSValidatorServiceRuntimeException(String errorCode,
			Object[] parameters, Throwable cause) {
		super(errorCode, parameters, cause);
	}

	/**
	 * Get Bundle Name
	 */
	@Override
	public String getBundleName() {
		return OSMSValidatorServiceExceptionCodes.CATALOG;
	}

	/**
	 * Get Category
	 */
	@Override
	public String getCategory() {
		return OSMSValidatorServiceExceptionCodes.CATEGORY;
	}

}
