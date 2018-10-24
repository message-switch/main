/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.service.data.parsing;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XmlParsingTest {
	@Before
    public void runBeforeTestMethod() {
    }
	@Test
	public void testGetXPathVal() throws Exception {
		String fileName = "C://Users/jchalamala/Desktop/projects/OSMS/Message Log XML/IQ.xml";
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
		String msgCode = XmlParsing.getXPathVal(content, "NLETS/NLETSMessageHeader/MessageKeyCodeText/text()");
		Assert.assertNotNull(msgCode);
	}
}
