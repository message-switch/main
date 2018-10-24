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
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.gcom.osms.messagelog.ds.constants.OSMSMessageLogDBConstants;

/**
 * The persistent class for the MESSAGE_LOG database table.
 * 
 */
@Entity
@Table(name = "MESSAGE_LOG")
@NamedQueries({

		@NamedQuery(name = OSMSMessageLogDBConstants.QRY_BY_MESSAGE_ID_MESSAGE_LOG_TYPE_MESSAGE_KEY, query = "SELECT n from MessageLogEntity n "
				+ "where n.messageLogType = :"
				+ OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE
				+ " and n.messageId=:messageId and n.messageKey = :"
				+ OSMSMessageLogDBConstants.PARAM_MESSAGE_KEY),

		@NamedQuery(name = OSMSMessageLogDBConstants.QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE, query = "SELECT n from MessageLogEntity n where n.messageLogType = :"
				+ OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE
				+ " and n.correlationId=:"
				+ OSMSMessageLogDBConstants.PARAM_CORRELATIONID),

		@NamedQuery(name = OSMSMessageLogDBConstants.QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE_SYSTEM_NAME, query = "SELECT n from MessageLogEntity n "
				+ "where n.messageLogType = :"
				+ OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE
				+ " and n.correlationId=:"
				+ OSMSMessageLogDBConstants.PARAM_CORRELATIONID
				+ " and n.systemName = :"
				+ OSMSMessageLogDBConstants.PARAM_SYSTEM_NAME),

		@NamedQuery(name = OSMSMessageLogDBConstants.QRY_FIND_BY_PERIOD, query = "SELECT n FROM MessageLogEntity n WHERE n.insertDate > :"
				+ OSMSMessageLogDBConstants.PARAM_TIME),

		@NamedQuery(name = OSMSMessageLogDBConstants.QRY_FIND_BY_PERIOD_RANGE, query = "SELECT n FROM MessageLogEntity n "
				+ "WHERE n.insertDate >= :"
				+ OSMSMessageLogDBConstants.PARAM_START_DATE_TIME
				+ " and n.insertDate <= :"
				+ OSMSMessageLogDBConstants.PARAM_END_DATE_TIME) }

)
public class MessageLogEntity extends LogEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The correlation id. */
	@Column(name = "CORRELATION_ID")
	private String correlationId;

	/** The fbi number. */
	@Column(name = "FBI_NUMBER")
	private String fbiNumber;

	/** The insert by. */
	@Column(name = "INSERT_BY")
	private String insertBy;

	/** The insert date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERT_DATE")
	private Date insertDate;

	/** The message id. */
	@Column(name = "MESSAGE_ID")
	private String messageId;

	/** The message key. */
	@Column(name = "MESSAGE_KEY")
	private String messageKey;

	// bi-directional many-to-one association to MessageLogHeaderEntity
	/** The message log headers. */
	@OneToMany(mappedBy = "messageLog", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private Set<MessageLogHeaderEntity> messageLogHeaders = new HashSet<MessageLogHeaderEntity>();

	/** The messagelog id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "MESSAGE_LOG_ID")
	private long messagelogId;

	// bi-directional many-to-one association to MessageLogPayloadEntity
	/** The message log payloads. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "messageLog", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	private List<MessageLogPayloadEntity> messageLogPayloads;

	// bi-directional many-to-one association to MessageLogStatusEntity
	/** The message log statuses. */
	@OneToMany(mappedBy = "messageLog", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<MessageLogStatusEntity> messageLogStatuses;

	/** The message log type. */
	@Column(name = "MSG_LOG_TYPE")
	private String messageLogType;

	/** The mnemonic. */
	private String mnemonic;

	/** The ori. */
	private String ori;

	/** The request date. */
	@Column(name = "MSG_DATE")
	private String requestDate;

	/** The request time. */
	@Column(name = "MSG_TIME")
	private String requestTime;

	/** The response time. */
	@Column(name = "RESPONSE_TIME")
	private Long responseTime;

	/** The sequence number. */
	@Column(name = "SEQUENCE_NUMBER")
	private BigDecimal sequenceNumber;

	/** The sid. */
	@Column(name = "SID")
	private Long sid;

	// bi-directional many-to-one association to StatusLogEntity
	/** The status logs. */
	@OneToMany(mappedBy = "messageLog")
	private List<StatusLogEntity> statusLogs;

	/** The system name. */
	@Column(name = "SYSTEM_NAME")
	private String systemName;

	/** The update by. */
	@Column(name = "UPDATE_BY")
	private String updateBy;

	/** The update date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	/**
	 * Instantiates a new message log entity.
	 */
	public MessageLogEntity() {
		// avoid sonar
	}

	/**
	 * Add message log header.
	 *
	 * @param messageLogHeader
	 *            the message log header
	 * @return the message log header entity
	 */
	public MessageLogHeaderEntity addMessageLogHeader(
			final MessageLogHeaderEntity messageLogHeader) {
		this.getMessageLogHeaders().add(messageLogHeader);
		messageLogHeader.setMessageLog(this);

		return messageLogHeader;
	}

	/**
	 * Add message log payload.
	 *
	 * @param messageLogPayload
	 *            the message log payload
	 * @return the message log payload entity
	 */
	public MessageLogPayloadEntity addMessageLogPayload(
			final MessageLogPayloadEntity messageLogPayload) {
		this.getMessageLogPayloads().add(messageLogPayload);
		messageLogPayload.setMessageLog(this);

		return messageLogPayload;
	}

	/**
	 * Add message log status.
	 *
	 * @param messageLogStatus
	 *            the message log status
	 * @return the message log status entity
	 */
	public MessageLogStatusEntity addMessageLogStatus(
			final MessageLogStatusEntity messageLogStatus) {
		this.getMessageLogStatuses().add(messageLogStatus);
		messageLogStatus.setMessageLog(this);

		return messageLogStatus;
	}

	/**
	 * Add status log.
	 *
	 * @param statusLog
	 *            the status log
	 * @return the status log entity
	 */
	public StatusLogEntity addStatusLog(final StatusLogEntity statusLog) {
		this.getStatusLogs().add(statusLog);
		statusLog.setMessageLog(this);

		return statusLog;
	}

	/**
	 * Gets the correlation id.
	 *
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return this.correlationId;
	}

	/**
	 * Gets the fbi number.
	 *
	 * @return the fbiNumber
	 */
	public String getFbiNumber() {
		return this.fbiNumber;
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
	 * Gets the message id.
	 *
	 * @return the message id
	 */
	public String getMessageId() {
		return this.messageId;
	}

	/**
	 * Gets the message key.
	 *
	 * @return the message key
	 */
	public String getMessageKey() {
		return this.messageKey;
	}

	/**
	 * Gets the message log headers.
	 *
	 * @return the message log headers
	 */
	public Set<MessageLogHeaderEntity> getMessageLogHeaders() {
		return this.messageLogHeaders;
	}

	/**
	 * Gets the messagelog id.
	 *
	 * @return the messagelog id
	 */
	public long getMessagelogId() {
		return this.messagelogId;
	}

	/**
	 * Gets the message log payloads.
	 *
	 * @return the message log payloads
	 */
	public List<MessageLogPayloadEntity> getMessageLogPayloads() {
		return this.messageLogPayloads;
	}

	/**
	 * Gets the message log statuses.
	 *
	 * @return the message log statuses
	 */
	public List<MessageLogStatusEntity> getMessageLogStatuses() {
		return this.messageLogStatuses;
	}

	/**
	 * Gets the message log type.
	 *
	 * @return the messageLogType
	 */
	public String getMessageLogType() {
		return this.messageLogType;
	}

	/**
	 * Gets the mnemonic.
	 *
	 * @return the mnemonic
	 */
	public String getMnemonic() {
		return this.mnemonic;
	}

	/**
	 * Gets the ori.
	 *
	 * @return the ori
	 */
	public String getOri() {
		return this.ori;
	}

	/**
	 * Gets the request date.
	 *
	 * @return the requestDate
	 */
	public String getRequestDate() {
		return this.requestDate;
	}

	/**
	 * Gets the request time.
	 *
	 * @return the requestTime
	 */
	public String getRequestTime() {
		return this.requestTime;
	}

	/**
	 * Gets the response time.
	 *
	 * @return the responseTime
	 */
	public Long getResponseTime() {
		return this.responseTime;
	}

	/**
	 * Gets the sequence number.
	 *
	 * @return the sequence number
	 */
	public BigDecimal getSequenceNumber() {
		return this.sequenceNumber;
	}

	/**
	 * Gets the sid.
	 *
	 * @return the sid
	 */
	public Long getSid() {
		return this.sid;
	}

	/**
	 * Gets the status logs.
	 *
	 * @return the status logs
	 */
	public List<StatusLogEntity> getStatusLogs() {
		return this.statusLogs;
	}

	/**
	 * Gets the system name.
	 *
	 * @return the systemName
	 */
	public String getSystemName() {
		return this.systemName;
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
	 * Remove message log header.
	 *
	 * @param messageLogHeader
	 *            the message log header
	 * @return the message log header entity
	 */
	public MessageLogHeaderEntity removeMessageLogHeader(
			final MessageLogHeaderEntity messageLogHeader) {
		this.getMessageLogHeaders().remove(messageLogHeader);
		messageLogHeader.setMessageLog(null);

		return messageLogHeader;
	}

	/**
	 * Remove message log payload.
	 *
	 * @param messageLogPayload
	 *            the message log payload
	 * @return the message log payload entity
	 */
	public MessageLogPayloadEntity removeMessageLogPayload(
			final MessageLogPayloadEntity messageLogPayload) {
		this.getMessageLogPayloads().remove(messageLogPayload);
		messageLogPayload.setMessageLog(null);

		return messageLogPayload;
	}

	/**
	 * Remove message log status.
	 *
	 * @param messageLogStatus
	 *            the message log status
	 * @return the message log status entity
	 */
	public MessageLogStatusEntity removeMessageLogStatus(
			final MessageLogStatusEntity messageLogStatus) {
		this.getMessageLogStatuses().remove(messageLogStatus);
		messageLogStatus.setMessageLog(null);

		return messageLogStatus;
	}

	/**
	 * Remove status log.
	 *
	 * @param statusLog
	 *            the status log
	 * @return the status log entity
	 */
	public StatusLogEntity removeStatusLog(final StatusLogEntity statusLog) {
		this.getStatusLogs().remove(statusLog);
		statusLog.setMessageLog(null);

		return statusLog;
	}

	/**
	 * Sets the correlation id.
	 *
	 * @param correlationId
	 *            the correlationId to set
	 */
	public void setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * Sets the fbi number.
	 *
	 * @param fbiNumber
	 *            the fbiNumber to set
	 */
	public void setFbiNumber(final String fbiNumber) {
		this.fbiNumber = fbiNumber;
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
	 * Sets the message id.
	 *
	 * @param messageId
	 *            the new message id
	 */
	public void setMessageId(final String messageId) {
		this.messageId = messageId;
	}

	/**
	 * Sets the message key.
	 *
	 * @param messageKey
	 *            the new message key
	 */
	public void setMessageKey(final String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * Sets the message log headers.
	 *
	 * @param messageLogHeaders
	 *            the new message log headers
	 */
	public void setMessageLogHeaders(
			final Set<MessageLogHeaderEntity> messageLogHeaders) {
		this.messageLogHeaders = messageLogHeaders;
	}

	/**
	 * Sets the messagelog id.
	 *
	 * @param messagelogId
	 *            the new messagelog id
	 */
	public void setMessagelogId(final long messagelogId) {
		this.messagelogId = messagelogId;
	}

	/**
	 * Sets the message log payloads.
	 *
	 * @param messageLogPayloads
	 *            the new message log payloads
	 */
	public void setMessageLogPayloads(
			final List<MessageLogPayloadEntity> messageLogPayloads) {
		this.messageLogPayloads = messageLogPayloads;
	}

	/**
	 * Sets the message log statuses.
	 *
	 * @param messageLogStatuses
	 *            the new message log statuses
	 */
	public void setMessageLogStatuses(
			final List<MessageLogStatusEntity> messageLogStatuses) {
		this.messageLogStatuses = messageLogStatuses;
	}

	/**
	 * Sets the message log type.
	 *
	 * @param messageLogType
	 *            the messageLogType to set
	 */
	public void setMessageLogType(final String messageLogType) {
		this.messageLogType = messageLogType;
	}

	/**
	 * Sets the mnemonic.
	 *
	 * @param mnemonic
	 *            the new mnemonic
	 */
	public void setMnemonic(final String mnemonic) {
		this.mnemonic = mnemonic;
	}

	/**
	 * Sets the ori.
	 *
	 * @param ori
	 *            the new ori
	 */
	public void setOri(final String ori) {
		this.ori = ori;
	}

	/**
	 * Sets the request date.
	 *
	 * @param requestDate
	 *            the requestDate to set
	 */
	public void setRequestDate(final String requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * Sets the request time.
	 *
	 * @param requestTime
	 *            the requestTime to set
	 */
	public void setRequestTime(final String requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * Sets the response time.
	 *
	 * @param responseTime
	 *            the responseTime to set
	 */
	public void setResponseTime(final Long responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * Sets the sequence number.
	 *
	 * @param sequenceNumber
	 *            the new sequence number
	 */
	public void setSequenceNumber(final BigDecimal sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * Sets the sid.
	 *
	 * @param sid
	 *            the sid to set
	 */
	public void setSid(final Long sid) {
		this.sid = sid;
	}

	/**
	 * Sets the status logs.
	 *
	 * @param statusLogs
	 *            the new status logs
	 */
	public void setStatusLogs(final List<StatusLogEntity> statusLogs) {
		this.statusLogs = statusLogs;
	}

	/**
	 * Sets the system name.
	 *
	 * @param systemName
	 *            the systemName to set
	 */
	public void setSystemName(final String systemName) {
		this.systemName = systemName;
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