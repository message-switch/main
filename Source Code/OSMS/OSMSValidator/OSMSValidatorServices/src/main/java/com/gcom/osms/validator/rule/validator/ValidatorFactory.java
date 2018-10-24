/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.rule.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * The ValidatorFactory class is used to get appropriate validator for given validation type
 *
 */
public class ValidatorFactory {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorFactory.class);

	/**
	 * Factory method to retrieve DRL and XSLT validators based on validatorType
	 * @param validatorType
	 * @return
	 */
	public static Validator getValidator(String validatorType) {
		Validator validator = null;
		if (validatorType != null) {
			if (validatorType.equalsIgnoreCase("DRL")) {
				validator = new DRLValidator();
			} else if (validatorType.equalsIgnoreCase("XSLT")) {
				validator = new XSLTValidator();
			}
		}
		return validator;

	}
}
