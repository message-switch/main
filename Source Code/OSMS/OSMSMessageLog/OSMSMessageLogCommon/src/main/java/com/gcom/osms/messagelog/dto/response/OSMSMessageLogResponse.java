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
import com.gcom.osms.messagelog.bo.model.StatusLog;
import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;

/**
 * The class OSMSMessageLogResponse
 *
 */
public class OSMSMessageLogResponse extends OSMSMessageLogBaseObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3274070832197225576L;

	/** The message log. */
	private MessageLog messageLog;

	/** The message logs. */
	private List<MessageLog> messageLogs;

	/** The paginated message logs. */
	private List<MessageLog> paginatedMessageLogs;

	/** The status log. */
	private StatusLog statusLog;

	/** The status logs. */
	private List<StatusLog> statusLogs;

	/** The total count. */
	private int totalCount;

	/**
	 * Gets the message log.
	 *
	 * @return the message log
	 */
	public MessageLog getMessageLog() {
		return this.messageLog;
	}

	/**
	 * Gets the message logs.
	 *
	 * @return the message logs
	 */
	public List<MessageLog> getMessageLogs() {
		return this.messageLogs;
	}

	/**
	 * Gets the paginated message logs.
	 *
	 * @return the paginatedMessageLogs
	 */
	public List<MessageLog> getPaginatedMessageLogs() {
		return this.paginatedMessageLogs;
	}

	/**
	 * Gets the status log.
	 *
	 * @return the status log
	 */
	public StatusLog getStatusLog() {
		return this.statusLog;
	}

	/**
	 * Gets the status logs.
	 *
	 * @return the status logs
	 */
	public List<StatusLog> getStatusLogs() {
		return this.statusLogs;
	}

	/**
	 * Gets the total count.
	 *
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * Sets the message log.
	 *
	 * @param messageLog
	 * the new message log
	 */
	public void setMessageLog(final MessageLog messageLog) {
		this.messageLog = messageLog;
	}

	/**
	 * Sets the message logs.
	 *
	 * @param messageLogs
	 * the new message logs
	 */
	public void setMessageLogs(final List<MessageLog> messageLogs) {
		this.messageLogs = messageLogs;
	}

	/**
	 * Sets the paginated message logs.
	 *
	 * @param paginatedMessageLogs
	 * the paginatedMessageLogs to set
	 */
	public void setPaginatedMessageLogs(
			final List<MessageLog> paginatedMessageLogs) {
		this.paginatedMessageLogs = paginatedMessageLogs;
	}

	/**
	 * Sets the status log.
	 *
	 * @param statusLog
	 * the new status log
	 */
	public void setStatusLog(final StatusLog statusLog) {
		this.statusLog = statusLog;
	}

	/**
	 * Sets the status logs.
	 *
	 * @param statusLogs
	 * the new status logs
	 */
	public void setStatusLogs(final List<StatusLog> statusLogs) {
		this.statusLogs = statusLogs;
	}

	/**
	 * Sets the total count.
	 *
	 * @param totalCount
	 * the totalCount to set
	 */
	public void setTotalCount(final int totalCount) {
		this.totalCount = totalCount;
	}

}
