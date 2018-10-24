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

import com.gcomsoft.fwk.referencetables.ReferenceTableManager;

/**
 * 
 * ReferenceTableUtil class contains methods to load coded table data
 *
 */
public class ReferenceTableUtil {
	public static boolean isSuffixPresent(String suffix) throws Exception {
		boolean isPresent = ReferenceTableManager.getManager().isCodePresent("ReferenceTable",
				"CODED_NAME_SUFFIX",suffix);
		return isPresent;
	}
	
	
}
