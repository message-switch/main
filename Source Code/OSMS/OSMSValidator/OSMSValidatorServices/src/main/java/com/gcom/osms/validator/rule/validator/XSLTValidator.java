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

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.validator.common.ValidatorRequest;
import com.gcom.osms.validator.common.ValidatorResponse;

/**
 * 
 * The XSLTValidator class for executing XSLT validations
 *
 */
public class XSLTValidator extends Validator{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -6337568507306921230L;
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorFactory.class);

	/**
	 * Execute XSLT validations
	 */
	@Override
	public Map<String, Object[]> validate(ValidatorRequest request, String fileName) throws Exception{
		LOGGER.debug("XSLT Validator is not implemented yet");
		return null;
	}

}
