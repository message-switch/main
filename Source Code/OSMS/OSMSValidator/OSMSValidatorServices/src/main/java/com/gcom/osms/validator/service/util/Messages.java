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

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.validator.service.data.parsing.XmlParsing;

/**
 * 
 * The class Messages reads the errorMessages properties and provide the error messages for given error codes
 *
 */
public class Messages {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(XmlParsing.class);
	
	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "errorMessages";
	
	/** The Constant RESOURCE_BUNDLE. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * Instantiate messages
	 */
	private Messages() {
	}

	/**
	 * Get error message for given error code
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Get error message for given error codes and params
	 * @param key
	 * @param params
	 * @return
	 */
	public static String getString(String key, Object... params) {
		try {
			return MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Get error messages map for for given error code map
	 * @param map
	 * @return
	 */
	public static Map<String,String> getStrings(Map<String, Object[]> map) {
		Map<String,String> errorMsgs = new HashMap<>();
		if(map!=null && map.size()>0){
		for (Map.Entry<String, Object[]> entry : map.entrySet()) {
			String key = entry.getKey();
			Object[] params = entry.getValue();
			try {
				errorMsgs.put(key, MessageFormat.format(RESOURCE_BUNDLE.getString(key), params));
			} catch (MissingResourceException e) {
				errorMsgs.put(key, '!' + key + '!');
			}
		}
		}
		return errorMsgs;
	}

	/*public static void main(String[] args) {
		String str = Messages.getString("ERROR_CODE_001", new Object[] { "AAA", "BBB" });
		System.out.println(str);
	}*/
}
