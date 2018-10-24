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
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the MESSAGE_LOG_PAYLOAD database table.
 * 
 */
@Entity
@Table(name = "MESSAGE_LOG_PAYLOAD")
@NamedQuery(name = "MessageLogPayloadEntity.findAll", query = "SELECT m FROM MessageLogPayloadEntity m")
public class MessageLogPayloadEntity implements Serializable {

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

	/** The message log payload id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "MESSAGE_LOG_PAYLOAD_ID")
	private long messageLogPayloadId;

	/** The payload. */
	private byte[] payload;

	/** The update by. */
	@Column(name = "UPDATE_BY")
	private String updateBy;

	/** The update date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	/**
	 * Instantiates a new message log payload entity.
	 */
	public MessageLogPayloadEntity() {
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
	 * Gets the message log payload id.
	 *
	 * @return the message log payload id
	 */
	public long getMessageLogPayloadId() {
		return this.messageLogPayloadId;
	}

	/**
	 * Gets the payload.
	 *
	 * @return the payload
	 */
	public byte[] getPayload() {
		return this.payload;
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
	 * Sets the message log payload id.
	 *
	 * @param messageLogPayloadId
	 *            the new message log payload id
	 */
	public void setMessageLogPayloadId(final long messageLogPayloadId) {
		this.messageLogPayloadId = messageLogPayloadId;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload
	 *            the new payload
	 */
	public void setPayload(final byte[] payload) {
		this.payload = payload;
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