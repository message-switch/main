/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.po.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.gcom.osms.messagelog.ds.constants.OSMSMessageLogDBConstants;

/**
 * The persistent class for the MESSAGE_LOG_STATUS database table.
 * 
 */
@Entity
@Table(name = "MESSAGE_LOG_STATUS")
@NamedQueries({
		@NamedQuery(name = "MessageLogStatusEntity.findAll", query = "SELECT m FROM MessageLogStatusEntity m"),

		@NamedQuery(name = OSMSMessageLogDBConstants.QRY_FIND_ALL_STATUS_BY_LOG_ID, query = "SELECT n FROM MessageLogStatusEntity n WHERE n.messageLog = :"
				+ OSMSMessageLogDBConstants.PARAM_LOG_ID),

		@NamedQuery(name = OSMSMessageLogDBConstants.QRY_FIND_ALL_STATUS_BY_LOG_ID_SORTED_BY_INSERT_DATE, query = "SELECT n FROM MessageLogStatusEntity n WHERE n.messageLog = :"
				+ OSMSMessageLogDBConstants.PARAM_LOG_ID
				+ " ORDER BY n.messageLogStatusId DESC") })
public class MessageLogStatusEntity extends LogEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The insert by. */
	@Column(name = "INSERT_BY")
	private String insertBy;

	/** The insert date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERT_DATE")
	private Date insertDate;

	// bi-directional many-to-one association to MessageLogEntity
	/** The message log. */
	@ManyToOne
	@JoinColumn(name = "MESSAGE_LOG_ID")
	private MessageLogEntity messageLog;

	/** The message log status id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "MESSAGE_LOG_STATUS_ID")
	private long messageLogStatusId;

	/** The status. */
	private String status;

	/** The update by. */
	@Column(name = "UPDATE_BY")
	private String updateBy;

	/** The update date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	/**
	 * Instantiates a new message log status entity.
	 */
	public MessageLogStatusEntity() {
		// avoid sonar
	}

	/**
	 * Gets the insert by.
	 *
	 * @return the insert by
	 */
	public String getInsertBy() {
		return this.insertBy;
	}

	/**
	 * Gets the insert date.
	 *
	 * @return the insert date
	 */
	public Date getInsertDate() {
		return this.insertDate;
	}

	/**
	 * Gets the message log.
	 *
	 * @return the message log
	 */
	public MessageLogEntity getMessageLog() {
		return this.messageLog;
	}

	/**
	 * Gets the message log status id.
	 *
	 * @return the message log status id
	 */
	public long getMessageLogStatusId() {
		return this.messageLogStatusId;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Gets the update by.
	 *
	 * @return the update by
	 */
	public String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * Gets the update date.
	 *
	 * @return the update date
	 */
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * Sets the insert by.
	 *
	 * @param insertBy
	 *            the new insert by
	 */
	public void setInsertBy(final String insertBy) {
		this.insertBy = insertBy;
	}

	/**
	 * Sets the insert date.
	 *
	 * @param insertDate
	 *            the new insert date
	 */
	public void setInsertDate(final Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * Sets the message log.
	 *
	 * @param messageLog
	 *            the new message log
	 */
	public void setMessageLog(final MessageLogEntity messageLog) {
		this.messageLog = messageLog;
	}

	/**
	 * Sets the message log status id.
	 *
	 * @param messageLogStatusId
	 *            the new message log status id
	 */
	public void setMessageLogStatusId(final long messageLogStatusId) {
		this.messageLogStatusId = messageLogStatusId;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * Sets the update by.
	 *
	 * @param updateBy
	 *            the new update by
	 */
	public void setUpdateBy(final String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * Sets the update date.
	 *
	 * @param updateDate
	 *            the new update date
	 */
	public void setUpdateDate(final Date updateDate) {
		this.updateDate = updateDate;
	}

}