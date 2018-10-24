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

import java.util.Date;
import java.util.Map;

import com.gcom.osms.messagelog.bo.model.MessageLog;
import com.gcom.osms.messagelog.bo.model.StatusLog;
import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;
/**
 * The class OSMSMessageLogRequest
 *
 */
public class OSMSMessageLogRequest extends OSMSMessageLogBaseObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3577817535410729486L;

	/** The end date time. */
	private Date endDateTime;

	/** Member variable for interval. */
	private Integer interval;

	/** Member variable for messagelog. */
	private MessageLog messagelog;

	/** The offset. */
	private int offset;

	/** The params. */
	private Map<String, Object> params;

	/** The sort field. */
	private String sortField;

	/** The sort order. */
	private String sortOrder;

	/** The start. */
	private int start;

	/** The start date time. */
	private Date startDateTime;

	/** Member variable for statusLog. */
	private StatusLog statusLog;

	/**
	 * Gets the end date time.
	 *
	 * @return the endDateTime
	 */
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	/**
	 * Gets the interval.
	 *
	 * @return the interval
	 */
	public Integer getInterval() {
		return this.interval;
	}

	/**
	 * Gets the messagelog.
	 *
	 * @return the messagelog
	 */
	public MessageLog getMessagelog() {
		return this.messagelog;
	}

	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public int getOffset() {
		return this.offset;
	}

	/**
	 * Gets the params.
	 *
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		return this.params;
	}

	/**
	 * Gets the sort field.
	 *
	 * @return the sortField
	 */
	public String getSortField() {
		return this.sortField;
	}

	/**
	 * Gets the sort order.
	 *
	 * @return the sortOrder
	 */
	public String getSortOrder() {
		return this.sortOrder;
	}

	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public int getStart() {
		return this.start;
	}

	/**
	 * Gets the start date time.
	 *
	 * @return the startDateTime
	 */
	public Date getStartDateTime() {
		return this.startDateTime;
	}

	/**
	 * Gets the status log.
	 *
	 * @return the statusLog
	 */
	public StatusLog getStatusLog() {
		return this.statusLog;
	}

	/**
	 * Sets the end date time.
	 *
	 * @param endDateTime
	 * the endDateTime to set
	 */
	public void setEndDateTime(final Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * Sets the interval.
	 *
	 * @param interval
	 * the interval to set
	 */
	public void setInterval(final Integer interval) {
		this.interval = interval;
	}

	/**
	 * Sets the messagelog.
	 *
	 * @param messagelog
	 * the messagelog to set
	 */
	public void setMessagelog(final MessageLog messagelog) {
		this.messagelog = messagelog;
	}

	/**
	 * Sets the offset.
	 *
	 * @param offset
	 * the offset to set
	 */
	public void setOffset(final int offset) {
		this.offset = offset;
	}

	/**
	 * Set params.
	 *
	 * @param params
	 * the params to set
	 */
	public void setParams(final Map<String, Object> params) {
		this.params = params;
	}

	/**
	 * Sets the sort field.
	 *
	 * @param sortField
	 * the sortField to set
	 */
	public void setSortField(final String sortField) {
		this.sortField = sortField;
	}

	/**
	 * Sets the sort order.
	 *
	 * @param sortOrder
	 * the sortOrder to set
	 */
	public void setSortOrder(final String sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * Sets the start.
	 *
	 * @param start
	 * the start to set
	 */
	public void setStart(final int start) {
		this.start = start;
	}

	/**
	 * Sets the start date time.
	 *
	 * @param startDateTime
	 * the startDateTime to set
	 */
	public void setStartDateTime(final Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * Sets the status log.
	 *
	 * @param statusLog
	 * the statusLog to set
	 */
	public void setStatusLog(final StatusLog statusLog) {
		this.statusLog = statusLog;
	}

}
