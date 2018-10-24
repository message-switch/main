/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.service;

import com.gcom.osms.validator.common.ValidatorRequest;
import com.gcom.osms.validator.common.ValidatorResponse;
import com.gcom.osms.validator.exception.OSMSValidatorServiceException;

/**
 * The Interface RuleValidatorService contains the methods for rule validations.
 */
public interface RuleValidatorService {
	/**
	 * Method to execute rule validations
	 * @param request
	 * @return
	 * @throws OSMSValidatorServiceException
	 */
	ValidatorResponse executeValidations(ValidatorRequest request) throws OSMSValidatorServiceException;
}