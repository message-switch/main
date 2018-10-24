/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.dto.response;

import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;

/**
 * The class GenerateNextMessageIdResponse
 *
 */
public class GenerateNextMessageIdResponse extends OSMSMessageLogBaseObject {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**The message id.*/
	private String messageId;

	/**
	 * Gets the messageId
	 * @return the messageId
	 */
	public String getMessageId() {
		return this.messageId;
	}

	/**
	 * Sets the messageId
	 * @param messageId
	 * the messageId to set
	 */
	public void setMessageId(final String messageId) {
		this.messageId = messageId;
	}
}
