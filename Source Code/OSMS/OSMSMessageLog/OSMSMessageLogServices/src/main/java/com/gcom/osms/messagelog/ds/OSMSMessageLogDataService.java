/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.ds;

import java.util.Date;
import java.util.List;

import com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest;
import com.gcom.osms.messagelog.exception.OSMSMessageLogServiceException;
import com.gcom.osms.messagelog.po.model.MessageLogEntity;
import com.gcom.osms.messagelog.po.model.MessageLogStatusEntity;

/**
 * Defines all the Data Service operations. 
 *
 */
public interface OSMSMessageLogDataService {

	
	/**
	 * Generate next cch message id.
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	//long generateNextCCHMessageId() throws OSMSMessageLogServiceException;

	
	/**
	 * Gets the all MessageLogStatusEntity by log id.
	 * @param log
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	List<MessageLogStatusEntity> getAllStatusByLogId(MessageLogStatusEntity log)
			throws OSMSMessageLogServiceException;

	/**
	 * Gets the all status by log id sorted by insert date.
	 * @param messageLog
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	List<MessageLogStatusEntity> getAllStatusByLogIdSortedByInsertDate(
			MessageLogEntity messageLog) throws OSMSMessageLogServiceException;

	
	/**
	 * Gets the MessageLogEntity by correlation id and message log type.
	 * @param log
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	MessageLogEntity getByCorrelationIdAndMessageLogType(MessageLogEntity log)
			throws OSMSMessageLogServiceException;

	/**
	 * Gets the MessageLogEntity by correlation id and message log type and system name.
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	MessageLogEntity getByCorrelationIdMessageLogTypeAndSystemName(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Gets the list of MessageLogEntity for given criteria
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	List<MessageLogEntity> getByCriteria(final SearchMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	
	/**
	 * Gets the MessageLogEntity by log id.
	 * @param log
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	MessageLogEntity getByLogId(MessageLogEntity log)
			throws OSMSMessageLogServiceException;

	
	/**
	 * Gets the MessageLogEntity by messageId and messageLogType And messageKey.
	 * @param log
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	MessageLogEntity getByMessageIdAndMessageLogTypeAndMessageKey(
			MessageLogEntity log) throws OSMSMessageLogServiceException;

	
	/**
	 * Gets the list of MessageLogEntity by date time range
	 * @param startDateTime
	 * @param endDateTime
	 * @param log
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	List<MessageLogEntity> getByPeriod(Date startDateTime, Date endDateTime,
			MessageLogEntity log) throws OSMSMessageLogServiceException;

	
	/**
	 * Gets the list of MessageLogEntity by period(interval)
	 * @param interval
	 * @param log
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	List<MessageLogEntity> getByPeriod(Integer interval, MessageLogEntity log)
			throws OSMSMessageLogServiceException;

	/**
	 * Gets the MessageLogCount by criteria
	 * @param request
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	Long getMessageLogCountByCriteria(final SearchMessageLogRequest request)
			throws OSMSMessageLogServiceException;

	/**
	 * Gets the next correlation id.
	 *
	 * @return the next correlation id
	 * @throws OSMSMessageLogServiceException
	 *             the OSMS message log service exception
	 */
	//long getNextCorrelationId() throws OSMSMessageLogServiceException;

	
	/**
	 * insert MessageLogEntity
	 * @param log
	 * @return
	 * @throws OSMSMessageLogServiceException
	 */
	Long insert(MessageLogEntity log) throws OSMSMessageLogServiceException;

	/**
	 * insert MessageLogStatusEntity
	 *
	 * @param log
	 *            the log
	 * @return the long
	 * @throws OSMSMessageLogServiceException
	 *             the OSMS message log service exception
	 */
	Long insert(MessageLogStatusEntity log)
			throws OSMSMessageLogServiceException;

}
