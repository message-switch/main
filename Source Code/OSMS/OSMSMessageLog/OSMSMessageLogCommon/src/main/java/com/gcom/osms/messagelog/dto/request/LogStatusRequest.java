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

import com.gcom.osms.messagelog.bo.model.StatusLog;
import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;

/**
 * The class LogStatusRequest
 *
 */
public class LogStatusRequest extends OSMSMessageLogBaseObject {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The status log. */
	private StatusLog statusLog;

	/**
	 * Gets the status log
	 * @return the statusLog
	 */
	public StatusLog getStatusLog() {
		return this.statusLog;
	}

	/**
	 * Sets the status logs
	 * @param statusLog
	 *            the statusLog to set
	 */
	public void setStatusLog(final StatusLog statusLog) {
		this.statusLog = statusLog;
	}

}
