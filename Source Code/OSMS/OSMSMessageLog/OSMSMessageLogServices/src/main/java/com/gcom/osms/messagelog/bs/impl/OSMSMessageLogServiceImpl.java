/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.bs.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.messagelog.bo.model.Log;
import com.gcom.osms.messagelog.bo.model.MessageLog;
import com.gcom.osms.messagelog.bo.model.StatusLog;
import com.gcom.osms.messagelog.ds.OSMSMessageLogDataService;
import com.gcom.osms.messagelog.ds.impl.OSMSMessageLogDataServiceImpl;
import com.gcom.osms.messagelog.ds.mapper.DozerMapperWrapper;
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
import com.gcom.osms.messagelog.po.model.LogEntity;
import com.gcom.osms.messagelog.po.model.MessageLogEntity;
import com.gcom.osms.messagelog.po.model.MessageLogHeaderEntity;
import com.gcom.osms.messagelog.po.model.MessageLogPayloadEntity;
import com.gcom.osms.messagelog.po.model.MessageLogStatusEntity;
import com.gcom.osms.messagelog.service.OSMSMessageLogService;
import com.gcomsoft.fwk.referencetables.ReferenceTableManager;
import com.gcomsoft.fwk.referencetables.exceptions.GcomReferenceTableException;

/**
 * The Class OSMSMessageLogServiceImpl.
 */

public class OSMSMessageLogServiceImpl implements OSMSMessageLogService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OSMSMessageLogServiceImpl.class);
	/** The Constant MESSAGE_ID_LENGTH. */
	private static final int MESSAGE_ID_LENGTH = 10;

	/** The entity manager. */
	private final EntityManager eManager;

	
	/**
	 * Instantiates a new OSMS message log service impl.
	 * @param eManager
	 */
	public OSMSMessageLogServiceImpl(final EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	/**
	 * Create message log
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#createMessageLog(com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest)
	 */
	@Override
	public CreateMessageLogResponse createMessageLog(
			final CreateMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		MessageLogEntity logEntity = this.logToEntity(request.getMessageLog(),
				new MessageLogEntity());

		OSMSMessageLogDataService dataService = new OSMSMessageLogDataServiceImpl(
				this.eManager);

		if (StringUtils.isBlank(logEntity.getCorrelationId())) {
			//long nextCorrelationId = dataService.getNextCorrelationId();
			//logEntity.setCorrelationId(Long.toString(nextCorrelationId));
			logEntity.setCorrelationId(UUID.randomUUID().toString());
		}

		logEntity.setInsertDate(new Date());
		logEntity.setUpdateDate(new Date());
		this.setMessageHeaderAndPayLoads(logEntity, request.getMessageLog());
		long databaseId = dataService.insert(logEntity);

		CreateMessageLogResponse response = new CreateMessageLogResponse();
		MessageLog retLog = new MessageLog();
		retLog.setLogId(databaseId);
		retLog.setMessagelogId(databaseId);

		response.setMessageLog(retLog);

		return response;
	}

	/**
	 * Create message log in new transaction
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#createMessageLogInNewTransaction(com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest)
	 */
	@Override
	public CreateMessageLogResponse createMessageLogInNewTransaction(
			final CreateMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		return this.createMessageLog(request);
	}

	/**
	 * Generate next cch message id.
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#generateNextCCHMessageId()
	 */
	/*@Override
	public GenerateNextMessageIdResponse generateNextCCHMessageId()
			throws OSMSMessageLogServiceException {
		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);

		long messageId = service.generateNextCCHMessageId();

		GenerateNextMessageIdResponse response = new GenerateNextMessageIdResponse();

		String messageIdStr = StringUtils.leftPad(Long.toString(messageId),
				MESSAGE_ID_LENGTH, '0');
		response.setMessageId(messageIdStr);

		return response;
	}*/

	/**
	 * Get the message log statuses for given message log id
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getAllStatusByLogId(com.gcom.osms.messagelog.dto.request.RetrieveStatusLogsRequest)
	 */
	@Override
	public RetrieveStatusLogsResponse getAllStatusByLogId(
			final RetrieveStatusLogsRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);
		StatusLog findLog = request.getStatusLog();
		MessageLogStatusEntity sLogEntity = new MessageLogStatusEntity();
		this.logToEntity(findLog, sLogEntity);
		MessageLogEntity messageLog = new MessageLogEntity();
		messageLog.setMessagelogId(findLog.getMessagelogId());
		sLogEntity.setMessageLog(messageLog);
		List<MessageLogStatusEntity> returnedEntity = service
				.getAllStatusByLogId(sLogEntity);
		List<StatusLog> retLog = new ArrayList<StatusLog>();
		List<StatusLog> stats = this.entitiesToStatusLogs(retLog,
				returnedEntity);
		RetrieveStatusLogsResponse response = new RetrieveStatusLogsResponse();
		response.setStatusLogs(stats);
		return response;
	}

	/**
	 * Get the Message log details by CorrelationId, MessageLogType And SystemName
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByCorrelationIdMessageLogTypeAndSystemName(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)
	 */
	@Override
	public RetrieveMessageLogResponse getByCorrelationIdMessageLogTypeAndSystemName(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);

		MessageLogEntity headerEntity = service
				.getByCorrelationIdMessageLogTypeAndSystemName(request);

		MessageLog retLog = null;

		if (headerEntity != null) {
			retLog = new MessageLog();

			this.entityToLog(retLog, headerEntity);

			Set<MessageLogHeaderEntity> messageLogHeaders = headerEntity
					.getMessageLogHeaders();

			if (CollectionUtils.isNotEmpty(messageLogHeaders)) {

				MessageLogHeaderEntity messageLogHeaderEntity = headerEntity
						.getMessageLogHeaders().iterator().next();

				String header = new String(messageLogHeaderEntity.getHeader());
				retLog.setHeader(header);
				retLog.setReplyTo(messageLogHeaderEntity.getReplyTo());
			}
		}

		RetrieveMessageLogResponse response = new RetrieveMessageLogResponse();
		response.setMessageLog(retLog);
		return response;
	}

	/**
	 * Get message log details by messagelogId 
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByLogId(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)
	 */
	@Override
	public RetrieveMessageLogResponse getByLogId(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);
		MessageLog findLog = request.getMessageLog();
		MessageLogEntity mLogEntity = new MessageLogEntity();
		this.logToEntity(findLog, mLogEntity);
		MessageLogEntity returnedEntity = service.getByLogId(mLogEntity);
		MessageLog retLog = new MessageLog();
		this.entityToLog(retLog, returnedEntity);
		if (returnedEntity != null
				&& returnedEntity.getMessageLogPayloads() != null
				&& !returnedEntity.getMessageLogPayloads().isEmpty()) {

			String payload = new String(returnedEntity.getMessageLogPayloads()
					.get(0).getPayload());

			retLog.setMessage(payload);
		}

		if (returnedEntity != null
				&& CollectionUtils.isNotEmpty(returnedEntity
						.getMessageLogHeaders())) {

			MessageLogHeaderEntity messageLogHeaderEntity = returnedEntity
					.getMessageLogHeaders().iterator().next();
			String header = new String(messageLogHeaderEntity.getHeader());
			retLog.setHeader(header);

			retLog.setReplyTo(messageLogHeaderEntity.getReplyTo());
		}

		RetrieveMessageLogResponse response = new RetrieveMessageLogResponse();
		response.setMessageLog(retLog);
		return response;
	}

	/**
	 * Get message log details by messageId, messageLogType and messageKey
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByMessageIdAndMessageLogTypeAndMessageKey(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)
	 */
	@Override
	public RetrieveMessageLogResponse getByMessageIdAndMessageLogTypeAndMessageKey(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);
		MessageLog findLog = request.getMessageLog();
		MessageLogEntity mLogEntity = new MessageLogEntity();
		this.logToEntity(findLog, mLogEntity);
		MessageLogEntity returnedEntity = service
				.getByMessageIdAndMessageLogTypeAndMessageKey(mLogEntity);

		RetrieveMessageLogResponse response = new RetrieveMessageLogResponse();

		if (returnedEntity != null) {
			MessageLog retLog = new MessageLog();
			this.entityToLog(retLog, returnedEntity);
			response.setMessageLog(retLog);
		}

		return response;
	}

	/**
	 * Get message log details by period(date range)
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getByPeriod(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)
	 */
	@Override
	public OSMSMessageLogResponse getByPeriod(
			final OSMSMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);
		MessageLog findLog = request.getMessagelog();
		MessageLogEntity mLogEntity = new MessageLogEntity();
		if (findLog != null) {
			this.logToEntity(findLog, mLogEntity);
		}
		List<MessageLogEntity> returnedEntity = service.getByPeriod(
				request.getStartDateTime(), request.getEndDateTime(),
				mLogEntity);
		List<MessageLog> retLog = new ArrayList<MessageLog>();

		for (MessageLogEntity entity : returnedEntity) {
			MessageLog messageLog = this.entityToMessageLog(entity);

			List<MessageLogStatusEntity> statuesEntitiesSorted = service
					.getAllStatusByLogIdSortedByInsertDate(entity);

			if (CollectionUtils.isNotEmpty(statuesEntitiesSorted)) {
				MessageLogStatusEntity statuesEntitySorted = statuesEntitiesSorted
						.get(0);
				messageLog.setStatus(statuesEntitySorted.getStatus());
			}

			retLog.add(messageLog);
		}

		OSMSMessageLogResponse response = new OSMSMessageLogResponse();
		response.setMessageLogs(retLog);
		return response;
	}

	/**
	 * Insert status for MessageLog
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#logStatus(com.gcom.osms.messagelog.dto.request.LogStatusRequest)
	 */
	@Override
	public LogStatusResponse logStatus(final LogStatusRequest request)
			throws OSMSMessageLogServiceException {

		LogStatusResponse response = new LogStatusResponse();

		if (request != null && request.getStatusLog() != null) {
			MessageLogStatusEntity logEntity = this.logToEntity(
					request.getStatusLog(), new MessageLogStatusEntity());
			MessageLogEntity messageLog = new MessageLogEntity();
			messageLog
					.setMessagelogId(request.getStatusLog().getMessagelogId());
			logEntity.setMessageLog(messageLog);
			logEntity.setInsertDate(new Date());
			logEntity.setUpdateDate(new Date());
			new OSMSMessageLogDataServiceImpl(this.eManager).insert(logEntity);

			if (this.checkValueInCodedTable(request.getStatusLog().getStatus(),
					"CODED_MESSAGE_LAST_LOG_STATUS")) {
				this.updateResponseTime(request.getStatusLog());
			}

		} else {
			throw new OSMSMessageLogServiceException(
					"Invalid request to update status");
		}

		return response;
	}

	/**
	 * Insert status for MessageLog in new transaction
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#logStatusInNewTransaction(com.gcom.osms.messagelog.dto.request.LogStatusRequest)
	 */
	@Override
	public LogStatusResponse logStatusInNewTransaction(
			final LogStatusRequest request)
			throws OSMSMessageLogServiceException {

		return this.logStatus(request);
	}

	/**
	 * Search message logs for given parameters
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#searchMessageLog(com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest)
	 */
	@Override
	public SearchMessageLogResponse searchMessageLog(
			final SearchMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);

		List<MessageLogEntity> returnedEntity = service.getByCriteria(request);

		Long count = service.getMessageLogCountByCriteria(request);

		List<MessageLog> retLog = new ArrayList<MessageLog>();

		for (MessageLogEntity entity : returnedEntity) {
			MessageLog messageLog = this.entityToMessageLog(entity);

			List<MessageLogStatusEntity> statuesEntitiesSorted = service
					.getAllStatusByLogIdSortedByInsertDate(entity);

			if (CollectionUtils.isNotEmpty(statuesEntitiesSorted)) {
				MessageLogStatusEntity statuesEntitySorted = statuesEntitiesSorted
						.get(0);
				messageLog.setStatus(statuesEntitySorted.getStatus());
			}

			retLog.add(messageLog);
		}

		SearchMessageLogResponse response = new SearchMessageLogResponse();
		response.setPaginatedMessageLogs(retLog);

		if (count != null) {
			response.setTotalCount(count.intValue());
		}

		return response;
	}

	/**
	 * Update message log
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#updateMessageLog(com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest)
	 */
	@Override
	public UpdateMessageLogResponse updateMessageLog(
			final UpdateMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		UpdateMessageLogResponse response = new UpdateMessageLogResponse();

		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);

		if (request.getMessagelog() == null) {
			throw new OSMSMessageLogServiceException(
					"Message Log cannot be null.");
		}

		MessageLogEntity mLogEntity = new MessageLogEntity();
		this.logToEntity(request.getMessagelog(), mLogEntity);

		MessageLogEntity returnedEntity = service.getByLogId(mLogEntity);
		this.logToEntity(request.getMessagelog(), returnedEntity);
		returnedEntity.setUpdateDate(new Date());

		return response;
	}

	/**
	 * Update message log header
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#updateMessageLogHeader(com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest)
	 */
	@Override
	public UpdateMessageLogResponse updateMessageLogHeader(
			final UpdateMessageLogRequest request)
			throws OSMSMessageLogServiceException {

		UpdateMessageLogResponse response = new UpdateMessageLogResponse();

		OSMSMessageLogDataService service = new OSMSMessageLogDataServiceImpl(
				this.eManager);

		if (request.getMessagelog() != null) {
			MessageLog findLog = request.getMessagelog();
			MessageLogEntity mLogEntity = new MessageLogEntity();
			this.logToEntity(findLog, mLogEntity);
			MessageLogEntity returnedEntity = service.getByLogId(mLogEntity);

			returnedEntity.getMessageLogHeaders().clear();

			MessageLogHeaderEntity responseHeaderEntity = new MessageLogHeaderEntity();
			responseHeaderEntity.setHeader(request.getMessagelog().getHeader()
					.getBytes());

			returnedEntity.addMessageLogHeader(responseHeaderEntity);

		}

		return response;
	}

	
	/**
	 * Check value in coded table.
	 * @param messageTypeCode
	 * @param codedTableName
	 * @return
	 */
	private boolean checkValueInCodedTable(final String messageTypeCode,
			final String codedTableName) {
		boolean codePresent = false;
		ReferenceTableManager manager = ReferenceTableManager.getManager();
		try {
			codePresent = manager.isCodePresent("ReferenceTable",
					codedTableName, messageTypeCode);
		} catch (GcomReferenceTableException e) {
			LOGGER.error("Error checking code" + messageTypeCode
					+ " in coded table " + codedTableName, e);
		}

		return codePresent;
	}

		
	/**
	 * Entities to status logs.
	 * @param retLog
	 * @param returnedEntity
	 * @return
	 */
	private List<StatusLog> entitiesToStatusLogs(final List<StatusLog> retLog,
			final List<MessageLogStatusEntity> returnedEntity) {
		for (int i = 0; i < returnedEntity.size(); i++) {
			Mapper mapper = DozerMapperWrapper.instance().getMapper();
			StatusLog log = new StatusLog();
			mapper.map(returnedEntity.get(i), log);
			retLog.add(log);
		}
		return retLog;
	}

	
	/**
	 * Entity to log.
	 * @param log
	 * @param logEntity
	 * @return
	 */
	private <L extends Log> L entityToLog(final L log, final LogEntity logEntity) {
		Mapper mapper = DozerMapperWrapper.instance().getMapper();
		mapper.map(logEntity, log);
		return log;
	}

	
	/**
	 * Entity to message log.
	 * @param returnedEntity
	 * @return
	 */
	private MessageLog entityToMessageLog(final MessageLogEntity returnedEntity) {
		Mapper mapper = DozerMapperWrapper.instance().getMapper();
		MessageLog log = new MessageLog();
		mapper.map(returnedEntity, log);
		return log;
	}

	
	/**
	 * Log to entity.
	 * @param log
	 * @param logEntity
	 * @return
	 */
	private <L extends LogEntity> L logToEntity(final Log log, final L logEntity) {
		Mapper mapper = DozerMapperWrapper.instance().getMapper();
		mapper.map(log, logEntity);
		return logEntity;
	}

	
	/**
	 * To set the Message header and Message pay loads.
	 * @param logEntity
	 * @param messageLog
	 */
	private void setMessageHeaderAndPayLoads(final MessageLogEntity logEntity,
			final MessageLog messageLog) {
		// If Header is not NULL in the request will create Message Header entry
		// Message header Log table
		if (messageLog.getHeader() != null) {
			MessageLogHeaderEntity messageLogHeaderEntity = new MessageLogHeaderEntity();
			messageLogHeaderEntity.setHeader(messageLog.getHeader().getBytes());
			messageLogHeaderEntity.setInsertBy(messageLog.getInsertBy());
			messageLogHeaderEntity.setInsertDate(Calendar.getInstance()
					.getTime());
			messageLogHeaderEntity.setUpdateBy(messageLog.getUpdateby());
			messageLogHeaderEntity.setUpdateDate(Calendar.getInstance()
					.getTime());

			messageLogHeaderEntity.setReplyTo(messageLog.getReplyTo());

			messageLogHeaderEntity.setMessageLog(logEntity);
			logEntity.getMessageLogHeaders().add(messageLogHeaderEntity);
		}
		// If Message is not NULL in the request will create Pay load entry
		// Message Pay load Log table
		if (messageLog.getMessage() != null) {
			MessageLogPayloadEntity messageLogPayloadEntity = new MessageLogPayloadEntity();
			messageLogPayloadEntity.setPayload(messageLog.getMessage()
					.getBytes());
			messageLogPayloadEntity.setInsertBy(messageLog.getInsertBy());
			messageLogPayloadEntity.setInsertDate(Calendar.getInstance()
					.getTime());
			messageLogPayloadEntity.setUpdateBy(messageLog.getUpdateby());
			messageLogPayloadEntity.setUpdateDate(Calendar.getInstance()
					.getTime());
			List<MessageLogPayloadEntity> messageLogPayloads = new ArrayList<MessageLogPayloadEntity>();
			messageLogPayloadEntity.setMessageLog(logEntity);
			messageLogPayloads.add(messageLogPayloadEntity);
			logEntity.setMessageLogPayloads(messageLogPayloads);
		}

		if (messageLog.getStatus() != null) {
			MessageLogStatusEntity messageLogStatusEntity = new MessageLogStatusEntity();
			messageLogStatusEntity.setStatus(messageLog.getStatus());
			messageLogStatusEntity.setInsertBy(messageLog.getInsertBy());
			messageLogStatusEntity.setInsertDate(Calendar.getInstance()
					.getTime());
			messageLogStatusEntity.setUpdateBy(messageLog.getUpdateby());
			messageLogStatusEntity.setUpdateDate(Calendar.getInstance()
					.getTime());
			List<MessageLogStatusEntity> messageLogStatuses = new ArrayList<MessageLogStatusEntity>();
			messageLogStatusEntity.setMessageLog(logEntity);
			messageLogStatuses.add(messageLogStatusEntity);
			logEntity.setMessageLogStatuses(messageLogStatuses);

		}

	}

	/**
	 * Update response time.
	 * @param statusLog
	 * @throws OSMSMessageLogServiceException
	 */
	private void updateResponseTime(final StatusLog statusLog)
			throws OSMSMessageLogServiceException {
		long messagelogId = statusLog.getMessagelogId();
		Date outMessageTimestamp = new Date();

		OSMSMessageLogDataService dataService = new OSMSMessageLogDataServiceImpl(
				this.eManager);

		MessageLogEntity mLogEntity = new MessageLogEntity();
		mLogEntity.setMessagelogId(messagelogId);

		MessageLogEntity returnedEntity = dataService.getByLogId(mLogEntity);

		if ("OUT".equals(returnedEntity.getMessageLogType())) {
			// now find by correlation id and in message log type
			returnedEntity.setUpdateDate(outMessageTimestamp);

			MessageLogEntity inMessageFindLog = new MessageLogEntity();
			inMessageFindLog
					.setCorrelationId(returnedEntity.getCorrelationId());
			inMessageFindLog.setMessageLogType("IN");

			MessageLogEntity inMessageEntity = dataService
					.getByCorrelationIdAndMessageLogType(inMessageFindLog);

			if (inMessageEntity != null) {
				Date inMessageInsertDate = inMessageEntity.getInsertDate();

				// now calculate response time

				long responseTime = outMessageTimestamp.getTime()
						- inMessageInsertDate.getTime();
				returnedEntity.setUpdateDate(outMessageTimestamp);
				returnedEntity.setResponseTime(responseTime);

			}

		}

	}
	
	/**
	 * Get all CodedMessageLogIntervals 
	 * @see com.gcom.osms.messagelog.service.OSMSMessageLogService#getCodedMessageLogIntervals()
	 */
	@Override
	public List<Map<String, String>> getCodedMessageLogIntervals() throws OSMSMessageLogServiceException {
		List<Map<String, String>> msgLogIntervals = null;
		try {
			msgLogIntervals = ReferenceTableManager.getManager().getColumnValues("ReferenceTable","CODED_MSG_LOG_INTERVAL");
			System.out.println("msgLogIntervals"+msgLogIntervals);
		} catch (GcomReferenceTableException e) {
			throw new OSMSMessageLogServiceException("Unable to load CODED_MSG_LOG_INTERVAL.");
		}
		return msgLogIntervals;
	}
	

}
