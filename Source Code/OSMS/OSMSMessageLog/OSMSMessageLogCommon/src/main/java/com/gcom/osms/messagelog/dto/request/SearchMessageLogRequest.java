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

import com.gcom.osms.messagelog.dto.OSMSMessageLogBaseObject;


/**
 * The class SearchMessageLogRequest
 *
 */
public class SearchMessageLogRequest extends OSMSMessageLogBaseObject {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The end date time. */
	private Date endDateTime;

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

	/**
	 * Sets the endDateTime
	 * @return the endDateTime
	 */
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	/**
	 * Gets the offSet
	 * @return the offset
	 */
	public int getOffset() {
		return this.offset;
	}

	/**
	 * Gets the params
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		return this.params;
	}

	/**
	 * Gets the sortField
	 * @return the sortField
	 */
	public String getSortField() {
		return this.sortField;
	}

	/**
	 * Gets the sortOrder
	 * @return the sortOrder
	 */
	public String getSortOrder() {
		return this.sortOrder;
	}

	/**
	 * Gets the start
	 * @return the start
	 */
	public int getStart() {
		return this.start;
	}

	/**
	 * Gets the startDateTime
	 * @return the startDateTime
	 */
	public Date getStartDateTime() {
		return this.startDateTime;
	}

	/**
	 * Sets the endDateTime
	 * @param endDateTime
	 * the endDateTime to set
	 */
	public void setEndDateTime(final Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * Sets the offset
	 * @param offset
	 * the offset to set
	 */
	public void setOffset(final int offset) {
		this.offset = offset;
	}

	/**
	 * Sets the params
	 * @param params
	 * the params to set
	 */
	public void setParams(final Map<String, Object> params) {
		this.params = params;
	}

	/**
	 * Sets the sortField
	 * @param sortField
	 * the sortField to set
	 */
	public void setSortField(final String sortField) {
		this.sortField = sortField;
	}

	/**
	 * Sets the sortOrder
	 * @param sortOrder
	 * the sortOrder to set
	 */
	public void setSortOrder(final String sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * Sets the start
	 * @param start
	 * the start to set
	 */
	public void setStart(final int start) {
		this.start = start;
	}

	/**
	 * Sets the startDateTime
	 * @param startDateTime
	 * the startDateTime to set
	 */
	public void setStartDateTime(final Date startDateTime) {
		this.startDateTime = startDateTime;
	}

}
