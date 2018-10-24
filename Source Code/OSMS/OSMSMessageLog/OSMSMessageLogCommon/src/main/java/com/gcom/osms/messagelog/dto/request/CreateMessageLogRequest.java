/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.dto.request;

import com.gcom.osms.messagelog.bo.model.MessageLog;
import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;

/**
 * The class CreateMessageLogRequest
 *
 */
public class CreateMessageLogRequest extends OSMSMessageLogBaseObject {

	/** Attribute for serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message log. */
	private MessageLog messageLog;

	/**
	 * Gets the message log.
	 *
	 * @return the messageLog
	 */
	public MessageLog getMessageLog() {
		return this.messageLog;
	}

	/**
	 * Sets the message log.
	 *
	 * @param messageLog
	 *            the messageLog to set
	 */
	public void setMessageLog(final MessageLog messageLog) {
		this.messageLog = messageLog;
	}

}
