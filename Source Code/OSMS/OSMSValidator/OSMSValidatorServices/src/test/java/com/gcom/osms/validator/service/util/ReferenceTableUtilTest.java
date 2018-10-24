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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ReferenceTableUtilTest {
	@Before
    public void runBeforeTestMethod() {
    }
	@Test
	public void testIsSuffixPresent() throws Exception {
		boolean isPresent = ReferenceTableUtil.isSuffixPresent("Jr.");
		Assert.assertTrue(isPresent);
	}
}
