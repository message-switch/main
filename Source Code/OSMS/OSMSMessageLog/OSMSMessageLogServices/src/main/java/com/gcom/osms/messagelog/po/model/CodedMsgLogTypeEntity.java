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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CODED_MSG_LOG_TYPE database table.
 * 
 */
@Entity
@Table(name = "CODED_MSG_LOG_TYPE")
@NamedQuery(name = "CodedMsgLogTypeEntity.findAll", query = "SELECT c FROM CodedMsgLogTypeEntity c")
public class CodedMsgLogTypeEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message type code. */
	@Id
	@Column(name = "MESSAGE_TYPE_CODE")
	private String messageTypeCode;

	/** The message type desc. */
	@Column(name = "MESSAGE_TYPE_DESC")
	private String messageTypeDesc;

	/**
	 * Instantiates a new coded msg log type entity.
	 */
	public CodedMsgLogTypeEntity() {
		// avoid sonar
	}

	/**
	 * Gets the message type code.
	 *
	 * @return the message type code
	 */
	public String getMessageTypeCode() {
		return this.messageTypeCode;
	}

	/**
	 * Gets the message type desc.
	 *
	 * @return the message type desc
	 */
	public String getMessageTypeDesc() {
		return this.messageTypeDesc;
	}

	/**
	 * Sets the message type code.
	 *
	 * @param messageTypeCode
	 *            the new message type code
	 */
	public void setMessageTypeCode(final String messageTypeCode) {
		this.messageTypeCode = messageTypeCode;
	}

	/**
	 * Sets the message type desc.
	 *
	 * @param messageTypeDesc
	 *            the new message type desc
	 */
	public void setMessageTypeDesc(final String messageTypeDesc) {
		this.messageTypeDesc = messageTypeDesc;
	}

}