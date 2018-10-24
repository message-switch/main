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

import com.gcom.osms.messagelog.bo.model.MessageLog;
import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;

/**
 * The class SearchMessageLogResponse
 *
 */
public class SearchMessageLogResponse extends OSMSMessageLogBaseObject {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** The paginated MessageLogs. */
	private List<MessageLog> paginatedMessageLogs;
	
	/** The totalCount. */
	private int totalCount;

	/**
	 * Gets the paginatedMessageLogs
	 * @return the paginatedMessageLogs
	 */
	public List<MessageLog> getPaginatedMessageLogs() {
		return this.paginatedMessageLogs;
	}

	/**
	 *  Gets the totalCount
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * Sets the paginatedMessageLogs
	 * @param paginatedMessageLogs
	 * the paginatedMessageLogs to set
	 */
	public void setPaginatedMessageLogs(
			final List<MessageLog> paginatedMessageLogs) {
		this.paginatedMessageLogs = paginatedMessageLogs;
	}

	/**
	 * Sets the totalCount
	 * @param totalCount
	 * the totalCount to set
	 */
	public void setTotalCount(final int totalCount) {
		this.totalCount = totalCount;
	}

}
