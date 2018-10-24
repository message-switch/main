/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.validator.common.ValidatorRequest;
import com.gcom.osms.validator.common.ValidatorResponse;
import com.gcom.osms.validator.exception.OSMSValidatorServiceException;
import com.gcom.osms.validator.rule.validator.Validator;
import com.gcom.osms.validator.rule.validator.ValidatorFactory;
import com.gcom.osms.validator.service.RuleValidatorService;
import com.gcom.osms.validator.service.util.Messages;
import com.gcomsoft.fwk.referencetables.ReferenceTableManager;

/**
 * 
 * Implementation class for RuleValidatorService
 *
 */
public class RuleValidatorServiceImpl implements RuleValidatorService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RuleValidatorServiceImpl.class);

	/**
	 * @see com.gcom.osms.messagelog.service.RuleValidatorService#executeValidations(com.gcom.osms.validator.common.ValidatorRequest)
	 *
	 * This method is used to execute the rule validations
	 */
	@Override
	public ValidatorResponse executeValidations(ValidatorRequest request) throws OSMSValidatorServiceException {
		LOGGER.debug("inside executeValidations params {} " + request);
		ValidatorResponse response = new ValidatorResponse();
		try {
			List<Map<String, String>> list = getCodedValidatorConfig();
			System.out.println(list);
			String validationType = null;
			String validatorFileName = null;
			for (Map<String, String> map : list) {
				if (map.get("INPUT_SOURCE_CODE") != null
						&& map.get("INPUT_SOURCE_CODE").equals(request.getInputSource()) && map.get("MKE") != null
						&& map.get("MKE").equals(request.getMke())) {
					validationType = map.get("VALIDATOR_TYPE_CODE");
					validatorFileName = map.get("VALIDATOR_FILE_NAME");
				}
			}

			if (validationType != null && validatorFileName != null) {
				Validator validator = ValidatorFactory.getValidator(validationType);
				Map<String, Object[]> results = validator.validate(request, validatorFileName);
				Map<String, String> errorMessages = Messages.getStrings(results);
				response.setErrorMessages(errorMessages);
			} else {
				LOGGER.debug("Validation Type is not found for given input source: " + request.getInputSource()
						+ " and MKE: " + request.getMke());
			}
		} catch (Exception e) {
			String stacktrace = ExceptionUtils.getStackTrace(e);
			LOGGER.debug("Exception in executeValidations " + stacktrace);
			throw new OSMSValidatorServiceException(stacktrace);
		}
		return response;
	}

	/**
	 * Method to retrieve values from CODED_VALIDATOR_CONFIG
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, String>> getCodedValidatorConfig() throws Exception {
		List<Map<String, String>> validatorConfig = null;

		/*validatorConfig = ReferenceTableManager.getManager().getColumnValues("ReferenceTable",
				"CODED_VALIDATOR_CONFIG");*/

		validatorConfig = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("MKE", "IQ");
		map.put("INPUT_SOURCE_CODE", "NLETS");
		map.put("VALIDATOR_TYPE_CODE", "DRL");
		map.put("VALIDATOR_FILE_NAME", "NLETS_IQ.drl");
		validatorConfig.add(map);
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("MKE", "FQ");
		map2.put("INPUT_SOURCE_CODE", "NLETS");
		map2.put("VALIDATOR_TYPE_CODE", "DRL");
		map2.put("VALIDATOR_FILE_NAME", "NLETS_FQ.drl");
		validatorConfig.add(map2);

		return validatorConfig;
	}

	public static void main(String[] args) throws Exception {
		RuleValidatorServiceImpl r = new RuleValidatorServiceImpl();
		r.getCodedValidatorConfig();
	}

}
