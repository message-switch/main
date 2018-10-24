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
 * The class StatusLog
 *
 */
public class StatusLog extends Log implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 71481202682767034L;
	
	/**
	 * Member variable for insertBy
	 */
	private String insertBy;
	/**
	 * Member variable for insertDate
	 */
	private Date insertDate;
	/**
	 * Member variable for messageId
	 */
	private String messageId;
	/**
	 * Member variable for messageKey
	 */
	private String messageKey;
	/**
	 * Member variable for messagelogId
	 */
	private long messagelogId;
	/**
	 * Member variable for mnemonic
	 */
	private String mnemonic;
	/**
	 * Member variable for ori
	 */
	private String ori;
	
	/**
	 * Member variable for status
	 */
	private String status;
	/**
	 * Member variable for statusId
	 */
	private long statusId;
	/**
	 * Member variable for statusMessage
	 */
	private String statusMessage;
	/**
	 * Member variable for updateBy
	 */
	private String updateBy;
	/**
	 * @return the insertBy
	 */
	public String getInsertBy() {
		return this.insertBy;
	}
	
	/**
	 * @return the insertDate
	 */
	public Date getInsertDate() {
		return this.insertDate;
	}
	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return this.messageId;
	}
	/**
	 * @return the messageKey
	 */
	public String getMessageKey() {
		return this.messageKey;
	}
	/**
	 * @return the messagelogId
	 */
	public long getMessagelogId() {
		return this.messagelogId;
	}
	/**
	 * @return the mnemonic
	 */
	public String getMnemonic() {
		return this.mnemonic;
	}
	/**
	 * @return the ori
	 */
	public String getOri() {
		return this.ori;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}
	public long getStatusId() {
		return this.statusId;
	}
	public String getStatusMessage() {
		return this.statusMessage;
	}
	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return this.updateBy;
	}
	/**
	 * @param insertBy the insertBy to set
	 */
	public void setInsertBy(final String insertBy) {
		this.insertBy = insertBy;
	}
	/**
	 * @param insertDate the insertDate to set
	 */
	public void setInsertDate(final Date insertDate) {
		this.insertDate = insertDate;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(final String messageId) {
		this.messageId = messageId;
	}
	/**
	 * @param messageKey the messageKey to set
	 */
	public void setMessageKey(final String messageKey) {
		this.messageKey = messageKey;
	}
	/**
	 * @param messagelogId the messagelogId to set
	 */
	public void setMessagelogId(final long messagelogId) {
		this.messagelogId = messagelogId;
	}
	/**
	 * @param mnemonic the mnemonic to set
	 */
	public void setMnemonic(final String mnemonic) {
		this.mnemonic = mnemonic;
	}
	/**
	 * @param ori the ori to set
	 */
	public void setOri(final String ori) {
		this.ori = ori;
	}
	
	/**
	 * Sets the status
	 * @param status the status to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}
	
	/**
	 * Sets the statusId
	 * @param statusId
	 */
	public void setStatusId(final long statusId) {
		this.statusId = statusId;
	}
	
	/**
	 * sets the status message
	 * @param statusMessage
	 */
	public void setStatusMessage(final String statusMessage) {
		this.statusMessage = statusMessage;
	}
	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(final String updateBy) {
		this.updateBy = updateBy;
	}
	
}
