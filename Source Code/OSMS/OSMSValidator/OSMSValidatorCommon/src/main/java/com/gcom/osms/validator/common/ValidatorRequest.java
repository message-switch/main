/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.common;

import java.io.Serializable;

/**
 * Request object for OSMSValidations service
 *
 */
public class ValidatorRequest implements Serializable{
	
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -3160756735782489679L;
	
	/** The message. */
	private String message;
	
	/** The message key. */
	private String mke;
	
	/** The contentType. */
	private String contentType;
	
	/** The inputSource. */
	private String inputSource;
	
	/**
	 * Get message
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Set message
	 * @return
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Get Content Type
	 * @return
	 */
	public String getContentType() {
		return contentType;
	}
	
	/**
	 * Set Content Type
	 * @return
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	/**
	 * Get Input Source
	 * @return
	 */
	public String getInputSource() {
		return inputSource;
	}
	
	/**
	 * Set Input Source
	 * @return
	 */
	public void setInputSource(String inputSource) {
		this.inputSource = inputSource;
	}
	
	/**
	 * Set Mke
	 * @return
	 */
	public String getMke() {
		return mke;
	}
	
	/**
	 * Get Mke
	 * @return
	 */
	public void setMke(String mke) {
		this.mke = mke;
	}
	
	/**
	 * convert object to string
	 */
	@Override
	public String toString() {
		String str = "MKE: "+mke+"\n"+" Input Source : "+inputSource+"\n"+" Message : "+message+"\n";
		return str;
	}
	
}
