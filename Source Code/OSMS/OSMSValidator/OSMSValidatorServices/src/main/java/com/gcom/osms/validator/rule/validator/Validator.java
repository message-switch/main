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

import java.io.Serializable;
import java.util.Map;

import com.gcom.osms.validator.common.ValidatorRequest;

/**
 * 
 * Abstarct class for all validations
 *
 */
public abstract class Validator implements Serializable{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 9131620399663250951L;

	/**
	 * Execute validations
	 * @param request
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public abstract Map<String, Object[]> validate(ValidatorRequest request, String fileName) throws Exception;
}
