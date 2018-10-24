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
 * The class UpdateMessageLogRequest
 *
 */
public class UpdateMessageLogRequest extends OSMSMessageLogBaseObject {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** The message log. */
	private MessageLog messagelog;

	/**
	 * Gets the messagelog
	 * @return the messagelog
	 */
	public MessageLog getMessagelog() {
		return this.messagelog;
	}

	/**
	 * Sets the messagelog
	 * @param messagelog
	 * the messagelog to set
	 */
	public void setMessagelog(final MessageLog messagelog) {
		this.messagelog = messagelog;
	}

}
