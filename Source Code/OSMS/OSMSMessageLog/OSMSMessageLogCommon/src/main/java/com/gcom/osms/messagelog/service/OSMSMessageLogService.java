/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.service;

import java.util.List;
import java.util.Map;

import com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.LogStatusRequest;
import com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.RetrieveStatusLogsRequest;
import com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest;
import com.gcom.osms.messagelog.dto.response.CreateMessageLogResponse;
import com.gcom.osms.messagelog.dto.response.GenerateNextMessageIdResponse;
import com.gcom.osms.messagelog.dto.response.LogStatusResponse;
import com.gcom.osms.messagelog.dto.response.OSMSMessageLogResponse;
import com.gcom.osms.messagelog.dto.response.RetrieveMessageLogResponse;
import com.gcom.osms.messagelog.dto.response.RetrieveStatusLogsResponse;
import com.gcom.osms.messagelog.dto.response.SearchMessageLogResponse;
import com.gcom.osms.messagelog.dto.response.UpdateMessageLogResponse;
import com.gcom.osms.messagelog.exception.OSMSMessageLogServiceException;

/**
 * The Interface OSMSMessageLogService.
 */
public interface OSMSMessageLogService {

	/**
	 * Create message log
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	CreateMessageLogResponse createMessageLog(CreateMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Create message log in new transaction
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	CreateMessageLogResponse createMessageLogInNewTransaction(
			CreateMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	
	/**
	 * Generate next cch message id.
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	/*GenerateNextMessageIdResponse generateNextCCHMessageId()
			throws OSMSMessageLogServiceException;*/

	/**
	 * Get the message log statuses for given message log id
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	RetrieveStatusLogsResponse getAllStatusByLogId(
			RetrieveStatusLogsRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Get the Message log details by CorrelationId, MessageLogType And SystemName
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	RetrieveMessageLogResponse getByCorrelationIdMessageLogTypeAndSystemName(
			RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Get message log details by messagelogId 
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	RetrieveMessageLogResponse getByLogId(RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Get message log details by messageId, messageLogType and messageKey
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	RetrieveMessageLogResponse getByMessageIdAndMessageLogTypeAndMessageKey(
			RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	
	/**
	 * Get list of message log details by period(date range)
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	OSMSMessageLogResponse getByPeriod(OSMSMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	
	/**
	 * Insert status for MessageLog
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	LogStatusResponse logStatus(LogStatusRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Insert status for MessageLog in new transaction
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	LogStatusResponse logStatusInNewTransaction(LogStatusRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Search message logs for given parameters
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	SearchMessageLogResponse searchMessageLog(SearchMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Update message log
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	UpdateMessageLogResponse updateMessageLog(UpdateMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Update message log header
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	UpdateMessageLogResponse updateMessageLogHeader(
			UpdateMessageLogRequest request)
			throws OSMSMessageLogServiceException;
	
	/**
	 * Get all CodedMessageLogIntervals 
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	List<Map<String, String>> getCodedMessageLogIntervals() throws OSMSMessageLogServiceException;
}
