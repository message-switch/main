/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.ds.constants;

/**
 * Defines all the basic constants for the Data Service.
 * 
 *
 */
public abstract class OSMSMessageLogDBConstants {

	// Sequences
	/** The Constant MESSAGE_LOG_SEQ. */
	public static final String MESSAGE_LOG_SEQ = "M_LOG_SEQ";

	/** The Constant PARAM_CORRELATIONID. */
	public static final String PARAM_CORRELATIONID = "correlationId";

	/** The Constant PARAM_END_DATE_TIME. */
	public static final String PARAM_END_DATE_TIME = "endDateTime";

	/** The Constant PARAM_FBI_NUMBER. */
	public static final String PARAM_FBI_NUMBER = "fbiNumber";

	// Query parameters
	/** The Constant PARAM_LOG_ID. */
	public static final String PARAM_LOG_ID = "logId";

	/** The Constant PARAM_MESSAGE_ID. */
	public static final String PARAM_MESSAGE_ID = "messageId";

	/** The Constant PARAM_MESSAGE_KEY. */
	public static final String PARAM_MESSAGE_KEY = "messagekey";

	/** The Constant PARAM_MESSAGE_LOG_TYPE. */
	public static final String PARAM_MESSAGE_LOG_TYPE = "messageLogType";

	/** The Constant PARAM_MNEMONIC. */
	public static final String PARAM_MNEMONIC = "mnemonic";

	/** The Constant PARAM_ORI. */
	public static final String PARAM_ORI = "ori";

	/** The Constant PARAM_SID. */
	public static final String PARAM_SID = "sid";

	/** The Constant PARAM_START_DATE_TIME. */
	public static final String PARAM_START_DATE_TIME = "startDateTime";

	/** The Constant PARAM_STATUS. */
	public static final String PARAM_STATUS = "status";

	/** The Constant PARAM_STATUS_ID. */
	public static final String PARAM_STATUS_ID = "statusId";

	/** The Constant PARAM_SYSTEM_NAME. */
	public static final String PARAM_SYSTEM_NAME = "systemName";

	/** The Constant PARAM_TIME. */
	public static final String PARAM_TIME = "time";

	/** The Constant QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE. */
	public static final String QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE = "MessageLogEntity.findByCorrelationIdAndMsgLogType";

	/** The Constant QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE_SYSTEM_NAME. */
	public static final String QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE_SYSTEM_NAME = "MessageLogEntity.findByCorrelationIdMsgLogTypeAndSystemName";

	/** The Constant QRY_BY_MESSAGE_ID_MESSAGE_LOG_TYPE_MESSAGE_KEY. */
	public static final String QRY_BY_MESSAGE_ID_MESSAGE_LOG_TYPE_MESSAGE_KEY = "MessageLogEntity.findByMessageIdAndMsgLogTypeAndMessageKey";

	/** The Constant QRY_FIND_ALL_STATUS_BY_LOG_ID. */
	public static final String QRY_FIND_ALL_STATUS_BY_LOG_ID = "StatusLogEntity.findAllStatusByLogId";

	/** The Constant QRY_FIND_ALL_STATUS_BY_LOG_ID_SORTED_BY_INSERT_DATE. */
	public static final String QRY_FIND_ALL_STATUS_BY_LOG_ID_SORTED_BY_INSERT_DATE = "StatusLogEntity.findAllStatusByLogIdSortedByInsertDate";

	/** The Constant QRY_FIND_ALL_STATUS_BY_PERIOD. */
	public static final String QRY_FIND_ALL_STATUS_BY_PERIOD = "StatusLogEntity.findAllStatusByPeriod";

	/** The Constant QRY_FIND_BY_MESSAGE_ID. */
	public static final String QRY_FIND_BY_MESSAGE_ID = "MessageLogEntity.findByMessageId";

	// Queries
	/** The Constant QRY_FIND_BY_PERIOD. */
	public static final String QRY_FIND_BY_PERIOD = "MessageLogEntity.findByPeriod";

	/** The Constant QRY_FIND_BY_PERIOD_RANGE. */
	public static final String QRY_FIND_BY_PERIOD_RANGE = "MessageLogEntity.findByPeriodRange";

	/** The Constant QRY_FIND_BY_STATUS. */
	public static final String QRY_FIND_BY_STATUS = "StatusLogEntity.findByStatus";

	/** The Constant QRY_FIND_BY_STATUS_ID. */
	public static final String QRY_FIND_BY_STATUS_ID = "StatusLogEntity.findByStatusId";

	/** The Constant STATUS_LOG_SEQ. */
	public static final String STATUS_LOG_SEQ = "S_LOG_SEQ";
	
	/** The Constant QRY_FIND_ALL_CODED_MSG_INTERVALS. */
	public static final String QRY_FIND_ALL_CODED_MSG_INTERVALS = "CodedMsgLogIntervalEntity.findAll"; 
}
