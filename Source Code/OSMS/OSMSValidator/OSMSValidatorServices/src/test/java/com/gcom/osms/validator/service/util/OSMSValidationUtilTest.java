/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.service.util;

import org.junit.Before;
import org.junit.Test;

public class OSMSValidationUtilTest {
	@Before
    public void runBeforeTestMethod() {
    }
	@Test
	public void testIsValidDate() throws Exception {
		OSMSValidationUtil.isValidDate("2014-03-19", "YYYY-MM-DD");
	}
}
