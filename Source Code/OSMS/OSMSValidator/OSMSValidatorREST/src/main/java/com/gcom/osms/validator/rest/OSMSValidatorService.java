/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.rest;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.validator.common.ValidatorRequest;
import com.gcom.osms.validator.common.ValidatorResponse;
import com.gcom.osms.validator.exception.OSMSValidatorServiceException;
import com.gcom.osms.validator.service.RuleValidatorService;
import com.gcom.osms.validator.services.impl.RuleValidatorServiceImpl;

@Path("/OSMSValidator")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
/**
 * 
 * Rest service for OSMSValidations
 *
 */
public class OSMSValidatorService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OSMSValidatorService.class);

	/**
	 * Instantiate Constructor
	 */
	public OSMSValidatorService() {
	}

	/**
	 * Execute validations
	 * @param request
	 * @return
	 * @throws OSMSValidatorServiceException
	 */
	@POST
	@Path("validate")
	public ValidatorResponse validate(final ValidatorRequest request)
			throws OSMSValidatorServiceException {
		LOGGER.debug("inside validate params{request: {}}"+request);
		RuleValidatorService ruleValidatorService = new RuleValidatorServiceImpl();
		ValidatorResponse response = ruleValidatorService.executeValidations(request);
		LOGGER.debug("end validate "+response);
		return response;
	}
	
	public static void main(String[] args) throws Exception {
		String fileName = "C://Users/jchalamala/Desktop/projects/OSMS/Message Log XML/FQ.xml";
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
		ValidatorRequest request = new ValidatorRequest();
		request.setMessage(content);
		request.setContentType("XML");
		request.setMke("FQ");
		request.setInputSource("NLETS");
		OSMSValidatorService m = new OSMSValidatorService();
		m.validate(request);
	}

	

}
