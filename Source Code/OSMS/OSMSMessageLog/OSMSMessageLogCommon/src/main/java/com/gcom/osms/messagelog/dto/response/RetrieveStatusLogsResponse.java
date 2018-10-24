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

import java.util.List;

import com.gcom.osms.messagelog.bo.model.StatusLog;
import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;

/**
 * The class RetrieveStatusLogsResponse
 *
 */
public class RetrieveStatusLogsResponse extends OSMSMessageLogBaseObject {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The statusLogs. */
	private List<StatusLog> statusLogs;

	/**
	 * Gets the statusLogs
	 * @return the statusLogs
	 */
	public List<StatusLog> getStatusLogs() {
		return this.statusLogs;
	}

	/**
	 * Sets the statusLogs
	 * @param statusLogs
	 * the statusLogs to set
	 */
	public void setStatusLogs(final List<StatusLog> statusLogs) {
		this.statusLogs = statusLogs;
	}

}
