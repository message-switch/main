/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.common;

import java.util.Map;
/**
 * Response object for OSMSValidations service
 *
 */
public class ValidatorResponse {
	/** The errorMessages. */
	Map<String, String> errorMessages;

	/**
	 * Get errorMessages
	 * @return
	 */
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * Set errorMessages
	 * @param errorMessages
	 */
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	/**
	 * Convert object to string
	 */
	@Override
	public String toString() {
		return errorMessages!=null?errorMessages.toString():null;
	}
}
