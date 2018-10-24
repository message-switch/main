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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageMetadata", propOrder = { "correlationId", "messageId",
		"id", "mke", "ori", "mnemonic", "msgdate", "msgtime", "msglength",
		"afis", "msgtype", "reserved", "ssnsupress", "cchMessageId" })
@XmlRootElement(name = "messageMetadata")
public class MessageMetadata implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The afis. */
	@XmlElement
	private String afis;

	/** The cch message id. */
	@XmlElement
	private String cchMessageId;

	/** Coreelation Id. */
	@XmlElement
	private String correlationId;

	/** MessageLog Id. */
	@XmlElement
	private long id;

	/** The message id. */
	@XmlElement
	private String messageId;

	/** Message Key. */
	@XmlElement
	private String mke;

	/** The mnemonic. */
	@XmlElement
	private String mnemonic;

	/** The msgdate. */
	@XmlElement
	private String msgdate;

	/** The msglength. */
	@XmlElement
	private String msglength;

	/** The msgtime. */
	@XmlElement
	private String msgtime;

	/** The msgtype. */
	@XmlElement
	private String msgtype;

	/** ORI. */
	@XmlElement
	private String ori;

	/** The reserved. */
	@XmlElement
	private String reserved;

	/** The ssnsupress. */
	@XmlElement
	private String ssnsupress;

	
	/**
	 * Equals.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		MessageMetadata other = (MessageMetadata) obj;
		if (this.correlationId == null) {
			if (other.correlationId != null) {
				return false;
			}
		} else if (!this.correlationId.equals(other.correlationId)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.mke == null) {
			if (other.mke != null) {
				return false;
			}
		} else if (!this.mke.equals(other.mke)) {
			return false;
		}

		if (this.ori == null) {
			if (other.ori != null) {
				return false;
			}

		} else if (!this.ori.equals(other.ori)) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the afis.
	 *
	 * @return the afis
	 */
	public String getAfis() {
		return this.afis;
	}

	/**
	 * Gets the cch message id.
	 *
	 * @return the cchMessageId
	 */
	public String getCchMessageId() {
		return this.cchMessageId;
	}

	/**
	 * Gets the correlationId.
	 *
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return this.correlationId;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
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
	 * Gets the mke.
	 *
	 * @return the mke
	 */
	public String getMke() {
		return this.mke;
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
	 * Gets the msgdate.
	 *
	 * @return the msgdate
	 */
	public String getMsgdate() {
		return this.msgdate;
	}

	/**
	 * Gets the msglength.
	 *
	 * @return the msglength
	 */
	public String getMsglength() {
		return this.msglength;
	}

	/**
	 * Gets the msgtime.
	 *
	 * @return the msgtime
	 */
	public String getMsgtime() {
		return this.msgtime;
	}

	/**
	 * Gets the msgtype.
	 *
	 * @return the msgtype
	 */
	public String getMsgtype() {
		return this.msgtype;
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
	 * Gets the reserved.
	 *
	 * @return the reserved
	 */
	public String getReserved() {
		return this.reserved;
	}

	/**
	 * Gets the ssnsupress.
	 *
	 * @return the ssnsupress
	 */
	public String getSsnsupress() {
		return this.ssnsupress;
	}

	
	/**
	 * Hash code.
	 *
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.correlationId == null) ? 0 : this.correlationId
						.hashCode());
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result
				+ ((this.mke == null) ? 0 : this.mke.hashCode());
		result = prime * result
				+ ((this.ori == null) ? 0 : this.ori.hashCode());
		return result;
	}

	/**
	 * Sets the afis.
	 *
	 * @param afis
	 *            the afis to set
	 */
	public void setAfis(final String afis) {
		this.afis = afis;
	}

	/**
	 * Sets the cch message id.
	 *
	 * @param cchMessageId
	 *            the cchMessageId to set
	 */
	public void setCchMessageId(final String cchMessageId) {
		this.cchMessageId = cchMessageId;
	}

	/**
	 * Sets the correlationId.
	 *
	 * @param correlationId
	 *            the correlationId to set
	 */
	public void setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id) {
		this.id = id;
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
	 * Sets the mke.
	 *
	 * @param mke
	 *            the mke to set
	 */
	public void setMke(final String mke) {
		this.mke = mke;
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
	 * Sets the msgdate.
	 *
	 * @param msgdate
	 *            the msgdate to set
	 */
	public void setMsgdate(final String msgdate) {
		this.msgdate = msgdate;
	}

	/**
	 * Sets the msglength.
	 *
	 * @param msglength
	 *            the msglength to set
	 */
	public void setMsglength(final String msglength) {
		this.msglength = msglength;
	}

	/**
	 * Sets the msgtime.
	 *
	 * @param msgtime
	 *            the msgtime to set
	 */
	public void setMsgtime(final String msgtime) {
		this.msgtime = msgtime;
	}

	/**
	 * Sets the msgtype.
	 *
	 * @param msgtype
	 *            the msgtype to set
	 */
	public void setMsgtype(final String msgtype) {
		this.msgtype = msgtype;
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
	 * Sets the reserved.
	 *
	 * @param reserved
	 *            the reserved to set
	 */
	public void setReserved(final String reserved) {
		this.reserved = reserved;
	}

	/**
	 * Sets the ssnsupress.
	 *
	 * @param ssnsupress
	 *            the ssnsupress to set
	 */
	public void setSsnsupress(final String ssnsupress) {
		this.ssnsupress = ssnsupress;
	}

	
	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageMetadata [correlationId=" + this.correlationId + ", id="
				+ this.id + ", mke=" + this.mke + ", ori=" + this.ori + "]";
	}
}