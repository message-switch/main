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

import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.gcom.osms.validator.common.ValidatorRequest;
import com.gcom.osms.validator.common.ValidatorResponse;
import com.gcom.osms.validator.service.RuleValidatorService;


public class RuleValidatorServiceImplTest {
	private RuleValidatorService ruleValidatorService; 
	@Before
    public void runBeforeTestMethod() {
		ruleValidatorService = new RuleValidatorServiceImpl();
    }
	@Test
	public void testExecuteValidations() throws Exception {
		String fileName = "C://Users/jchalamala/Desktop/projects/OSMS/Message Log XML/IQ.xml";
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
		ValidatorRequest request = new ValidatorRequest();
		request.setMessage(content);
		request.setContentType("XML");
		request.setMke("IQ");
		request.setInputSource("NLETS");
		ValidatorResponse response = ruleValidatorService.executeValidations(request);
		Assert.assertNotNull(response);
	}
}
