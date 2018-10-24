/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.bo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The class MessageLog
 *
 */
public class MessageLog extends Log implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 714812026827675625L;

	/** The correlation id. */
	private String correlationId;

	/** The fbi number. */
	private String fbiNumber;

	/** Member variable for header. */
	private String header;

	/** Member variable for insertBy. */
	private String insertBy;

	/** Member variable for insertDate. */
	private Date insertDate;

	/** Member variable for logId. */
	private long logId;

	/** Member variable for message. */
	private String message;

	/** Member variable for messageId. */
	private String messageId;

	/** Member variable for messageKey. */
	private String messageKey;

	/** Member variable for messagelogId. */
	private long messagelogId;

	/** The message log type. */
	private String messageLogType;

	/** Member variable for mnemonic. */
	private String mnemonic;

	/** Member variable for msgType. */
	private String msgType;

	/** Member variable for ori. */
	private String ori;

	/** The reply to. */
	private String replyTo;

	/** The request date. */
	private String requestDate;

	/** The request time. */
	private String requestTime;

	/** The response time. */
	private Long responseTime;

	/** The state id. */
	private Long stateId;

	/** Member variable for status. */
	private String status;

	/** The system. */
	private String system;

	/** Member variable for updateby. */
	private String updateby;

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
	 * Gets the header.
	 *
	 * @return the header
	 */
	public String getHeader() {
		return this.header;
	}

	/**
	 * Gets the insert by.
	 *
	 * @return the insertBy
	 */
	public String getInsertBy() {
		return this.insertBy;
	}

	/**
	 * Gets the insert date.
	 *
	 * @return the insertDate
	 */
	public Date getInsertDate() {
		return this.insertDate;
	}

	/**
	 * Gets the log id.
	 *
	 * @return the logId
	 */
	public long getLogId() {
		return this.logId;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Gets the message id.
	 *
	 * @return the messageId
	 */
	public String getMessageId() {
		return this.messageId;
	}

	/**
	 * Gets the message key.
	 *
	 * @return the messageKey
	 */
	public String getMessageKey() {
		return this.messageKey;
	}

	/**
	 * Gets the messagelog id.
	 *
	 * @return the messagelogId
	 */
	public long getMessagelogId() {
		return this.messagelogId;
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
	 * Gets the msg type.
	 *
	 * @return the msgType
	 */
	public String getMsgType() {
		return this.msgType;
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
	 * Gets the reply to.
	 *
	 * @return the replyTo
	 */
	public String getReplyTo() {
		return this.replyTo;
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
	 * Gets the state id.
	 *
	 * @return the stateId
	 */
	public Long getStateId() {
		return this.stateId;
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
	 * Gets the system.
	 *
	 * @return the system
	 */
	public String getSystem() {
		return this.system;
	}

	/**
	 * Gets the updateby.
	 *
	 * @return the updateby
	 */
	public String getUpdateby() {
		return this.updateby;
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
	 * Sets the header.
	 *
	 * @param header
	 *            the header to set
	 */
	public void setHeader(final String header) {
		this.header = header;
	}

	/**
	 * Sets the insert by.
	 *
	 * @param insertBy
	 *            the insertBy to set
	 */
	public void setInsertBy(final String insertBy) {
		this.insertBy = insertBy;
	}

	/**
	 * Sets the insert date.
	 *
	 * @param insertDate
	 *            the insertDate to set
	 */
	public void setInsertDate(final Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * Sets the log id.
	 *
	 * @param logId
	 *            the logId to set
	 */
	public void setLogId(final long logId) {
		this.logId = logId;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * Sets the message id.
	 *
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(final String messageId) {
		this.messageId = messageId;
	}

	/**
	 * Sets the message key.
	 *
	 * @param messageKey
	 *            the messageKey to set
	 */
	public void setMessageKey(final String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * Sets the messagelog id.
	 *
	 * @param messagelogId
	 *            the messagelogId to set
	 */
	public void setMessagelogId(final long messagelogId) {
		this.messagelogId = messagelogId;
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
	 *            the mnemonic to set
	 */
	public void setMnemonic(final String mnemonic) {
		this.mnemonic = mnemonic;
	}

	/**
	 * Sets the msg type.
	 *
	 * @param msgType
	 *            the msgType to set
	 */
	public void setMsgType(final String msgType) {
		this.msgType = msgType;
	}

	/**
	 * Sets the ori.
	 *
	 * @param ori
	 *            the ori to set
	 */
	public void setOri(final String ori) {
		this.ori = ori;
	}

	/**
	 * Sets the reply to.
	 *
	 * @param replyTo
	 *            the replyTo to set
	 */
	public void setReplyTo(final String replyTo) {
		this.replyTo = replyTo;
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
	 * Sets the state id.
	 *
	 * @param stateId
	 *            the stateId to set
	 */
	public void setStateId(final Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * Sets the system.
	 *
	 * @param system
	 *            the system to set
	 */
	public void setSystem(final String system) {
		this.system = system;
	}

	/**
	 * Sets the updateby.
	 *
	 * @param updateby
	 *            the updateby to set
	 */
	public void setUpdateby(final String updateby) {
		this.updateby = updateby;
	}

}
