/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.rest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl;
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
import com.gcom.osms.messagelog.service.OSMSMessageLogService;



@Path("/OSMSMessageLog")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
@Transactional
/**
 *  Rest Service for  OSMSMessageLog.
 *
 */
public class OSMSMessageLog {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OSMSMessageLog.class);
	
	/** The em. */
	@PersistenceContext(unitName = "OSMSMessageLog_PU", type = PersistenceContextType.TRANSACTION) // default type is
	private EntityManager em;
	
	/**
	 * Instantiate a constructor
	 */
	public OSMSMessageLog() {
	}
	
	
	@POST
	@Path("createMessageLog")
	/**
	 * Create message log
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#createMessageLog(com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest)
	 * 
	 */
	public CreateMessageLogResponse createMessageLog(
			final CreateMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.createMessageLog(request);
	}

	/**
	 * Create message log in new transaction
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#createMessageLogInNewTransaction(com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest)
	 * 
	 */
	@POST
	@Path("createMessageLogInNewTransaction")
	public CreateMessageLogResponse createMessageLogInNewTransaction(
			final CreateMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.createMessageLogInNewTransaction(request);
	}

	/**
	 *  Generate next cch message id.
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#generateNextCCHMessageId()
	 *
	 */
	/*@GET
	@Path("generateNextCCHMessageId")
	public GenerateNextMessageIdResponse generateNextCCHMessageId()
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.generateNextCCHMessageId();
	}*/
	
	/**
	 * Get the message log statuses for given message log id
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getAllStatusByLogId(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)
	 */
	
	@POST
	@Path("getAllStatusByLogId")
	public RetrieveStatusLogsResponse getAllStatusByLogId(
			final RetrieveStatusLogsRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.getAllStatusByLogId(request);
	}

	/**
	 * Get the Message log details by CorrelationId, MessageLogType And SystemName
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByCorrelationIdMessageLogTypeAndSystemName(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)
	 * 
	 */
	@POST
	@Path("getByCorrelationIdMessageLogTypeAndSystemName")
	public RetrieveMessageLogResponse getByCorrelationIdMessageLogTypeAndSystemName(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.getByCorrelationIdMessageLogTypeAndSystemName(
				request);
	}

	/**
	 * Get message log details by messagelogId  
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByLogId(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)
	 */
	@POST
	@Path("getByLogId")
	public RetrieveMessageLogResponse getByLogId(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.getByLogId(request);
	}

	/**
	 * Get message log details by messageId, messageLogType and messageKey
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByMessageIdAndMessageLogTypeAndMessageKey(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)
	 */
	@POST
	@Path("getByMessageIdAndMessageLogTypeAndMessageKey")
	public RetrieveMessageLogResponse getByMessageIdAndMessageLogTypeAndMessageKey(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.getByMessageIdAndMessageLogTypeAndMessageKey(
				request);
	}

	/**
	 * Get message log details by period(date range)
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByPeriod(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)
	 */
	@POST
	@Path("getByPeriod")
	public OSMSMessageLogResponse getByPeriod(
			final OSMSMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		if(request.getInterval()!=null && request.getInterval()!=-1){
			Date startDateTime = new Date(System.currentTimeMillis()
					- request.getInterval() * 60000);
			Date endDateTime = new Date(System.currentTimeMillis());
			request.setStartDateTime(startDateTime);
			request.setEndDateTime(endDateTime);
		}
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.getByPeriod(request);
	}
	

	/**
	 * Insert status for MessageLog
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#logStatus(com.gcom.osms.messagelog.dto.request.LogStatusRequest)
	 */
	@POST
	@Path("logStatus")
	public LogStatusResponse logStatus(final LogStatusRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.logStatus(request);
	}

	/**
	 * Insert status for MessageLog in new transaction
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#logStatusInNewTransaction(com.gcom.osms.messagelog.dto.request.LogStatusRequest)
	 */
	@POST
	@Path("logStatusInNewTransaction")
	public LogStatusResponse logStatusInNewTransaction(
			final LogStatusRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.logStatusInNewTransaction(request);
	}

	/**
	 * Search message logs for given parameters
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#searchMessageLog(com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest)
	 */
	@POST
	@Path("searchMessageLog")
	public SearchMessageLogResponse searchMessageLog(
			final SearchMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.searchMessageLog(request);
	}

	/**
	 * Update message log.
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#updateMessageLog(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)
	 */
	@POST
	@Path("updateMessageLog")
	public UpdateMessageLogResponse updateMessageLog(
			final UpdateMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.updateMessageLog(request);

	}

	/**
	 * Update message log header.
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#updateMessageLogHeader(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)
	 */
	@POST
	@Path("updateMessageLogHeader")
	public UpdateMessageLogResponse updateMessageLogHeader(
			final UpdateMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		return osmMessageLogService.updateMessageLogHeader(request);
	}
	
	/**
	 * Get all CodedMessageLogIntervals 
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getMesssageLogIntervals()
	 */
	@POST
	@Path("getCodedMsgLogIntevals")
	public List<Map<String, String>> getMesssageLogIntervals()
			throws OSMSMessageLogServiceException {
		OSMSMessageLogService osmMessageLogService = new OSMSMessageLogServiceImpl(this.em);
		List<Map<String, String>> map = osmMessageLogService.getCodedMessageLogIntervals();
		return map;
	}

	
}
