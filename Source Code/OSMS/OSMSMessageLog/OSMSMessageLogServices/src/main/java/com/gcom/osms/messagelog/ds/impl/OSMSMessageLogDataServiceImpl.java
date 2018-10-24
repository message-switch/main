/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.ds.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;

import com.gcom.osms.messagelog.bo.model.MessageLog;
import com.gcom.osms.messagelog.constants.OSMSMessageLogCommonConstants;
import com.gcom.osms.messagelog.ds.OSMSMessageLogDataService;
import com.gcom.osms.messagelog.ds.constants.OSMSMessageLogDBConstants;
import com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest;
import com.gcom.osms.messagelog.exception.OSMSMessageLogServiceException;
import com.gcom.osms.messagelog.po.model.LogEntity;
import com.gcom.osms.messagelog.po.model.MessageLogEntity;
import com.gcom.osms.messagelog.po.model.MessageLogStatusEntity;

/**
 * Implements the Data Service functionality.
 *
 */
public class OSMSMessageLogDataServiceImpl implements
		OSMSMessageLogDataService {

	/** Member variable for value. */
	private static final Integer SECONDS = 60000;

	/** Member variable for eManager. */
	private EntityManager eManager;

	
	/**
	 * Instantiates a new OSMS message log data service impl.
	 * @param eManager
	 */
	public OSMSMessageLogDataServiceImpl(final EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	/**
	 * Generate next cch message id.
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#generateNextCCHMessageId()
	 */
	/*@Override
	public long generateNextCCHMessageId()
			throws OSMSMessageLogServiceException {
		List<?> nextAssignableValue = this.eManager.createNamedQuery(
				"NEXT_CCH_MESSAGE_ID_SEQUENCE").getResultList();

		return ((Number) nextAssignableValue.get(0)).longValue();
	}*/

	
	/**
	 * Gets the all MessageLogStatusEntity by log id.
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getAllStatusByLogId(com.gcom.osms.messagelog.po.model.MessageLogStatusEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLogStatusEntity> getAllStatusByLogId(
			final MessageLogStatusEntity log)
			throws OSMSMessageLogServiceException {
		return this.eManager
				.createNamedQuery(
						OSMSMessageLogDBConstants.QRY_FIND_ALL_STATUS_BY_LOG_ID)
				.setParameter(OSMSMessageLogDBConstants.PARAM_LOG_ID,
						log.getMessageLog()).getResultList();
	}

	/**
	 * Gets the all MessageLogStatusEntities by log id sorted by insert date.
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getAllStatusByLogIdSortedByInsertDate(com.gcom.osms.messagelog.po.model.MessageLogStatusEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLogStatusEntity> getAllStatusByLogIdSortedByInsertDate(
			final MessageLogEntity log) throws OSMSMessageLogServiceException {
		return this.eManager
				.createNamedQuery(
						OSMSMessageLogDBConstants.QRY_FIND_ALL_STATUS_BY_LOG_ID_SORTED_BY_INSERT_DATE)
				.setParameter(OSMSMessageLogDBConstants.PARAM_LOG_ID, log)
				.getResultList();
	}

	/**
	 * Gets the MessageLogEntity by correlation id and message log type.
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getByCorrelationIdAndMessageLogType(com.gcom.osms.messagelog.po.model.MessageLogEntity)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public MessageLogEntity getByCorrelationIdAndMessageLogType(
			final MessageLogEntity log) throws OSMSMessageLogServiceException {
		MessageLogEntity retval = null;
		Query namedQuery = this.eManager
				.createNamedQuery(OSMSMessageLogDBConstants.QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE);

		namedQuery.setParameter(
				OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE,
				log.getMessageLogType());
		namedQuery.setParameter(OSMSMessageLogDBConstants.PARAM_CORRELATIONID,
				log.getCorrelationId());

		List resultList = namedQuery.getResultList();

		if (CollectionUtils.isNotEmpty(resultList)) {
			retval = (MessageLogEntity) resultList.get(0);
		}

		return retval;
	}

	/**
	 * Gets the MessageLogEntity by correlation id and message log type and system name.
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getByCorrelationIdMessageLogTypeAndSystemName(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public MessageLogEntity getByCorrelationIdMessageLogTypeAndSystemName(
			final RetrieveMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		MessageLogEntity retval = null;

		MessageLog messagelog = request.getMessageLog();

		Query namedQuery = this.eManager
				.createNamedQuery(OSMSMessageLogDBConstants.QRY_BY_CORRELATION_ID_MESSAGE_LOG_TYPE_SYSTEM_NAME);

		namedQuery.setParameter(
				OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE,
				messagelog.getMessageLogType());
		namedQuery.setParameter(OSMSMessageLogDBConstants.PARAM_CORRELATIONID,
				messagelog.getCorrelationId());
		namedQuery.setParameter(OSMSMessageLogDBConstants.PARAM_SYSTEM_NAME,
				messagelog.getSystem());

		List resultList = namedQuery.getResultList();

		if (CollectionUtils.isNotEmpty(resultList)) {
			retval = (MessageLogEntity) resultList.get(0);
		}

		return retval;
	}

	/**
	 * Gets the list of MessageLogEntity for given criteria
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getByCriteria(com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLogEntity> getByCriteria(
			final SearchMessageLogRequest request)
			throws OSMSMessageLogServiceException {

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT n FROM MessageLogEntity n");

		// {messageLogType=OUT, correlationId=3, status=r, messageKey=p, ori=4}

		sqlQuery.append(" WHERE n.insertDate >= :"
				+ OSMSMessageLogDBConstants.PARAM_START_DATE_TIME
				+ " and n.insertDate <= :"
				+ OSMSMessageLogDBConstants.PARAM_END_DATE_TIME);

		Map<String, Object> params = request.getParams();

		Set<String> paramKeys = params.keySet();

		if (CollectionUtils.isNotEmpty(paramKeys)) {
			for (String paramKey : paramKeys) {

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_KEY
						.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.messageKey) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_MESSAGE_KEY);
				}

				if (OSMSMessageLogCommonConstants.FILTER_ORI.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.ori) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_ORI);
				}

				if (OSMSMessageLogCommonConstants.FILTER_CORRELATION_ID
						.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.correlationId) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_CORRELATIONID);
				}

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_LOG_TYPE
						.equals(paramKey)) {
					sqlQuery.append(" and n.messageLogType = :"
							+ OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE);
				}

				if (OSMSMessageLogCommonConstants.FILTER_FBI_NUMBER
						.equals(paramKey)) {
					sqlQuery.append(" and  UPPER(n.fbiNumber) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_FBI_NUMBER);
				}

				if (OSMSMessageLogCommonConstants.FILTER_STATE_ID
						.equals(paramKey)) {
					sqlQuery.append(" and n.sid = :"
							+ OSMSMessageLogDBConstants.PARAM_SID);
				}

				if (OSMSMessageLogCommonConstants.FILTER_SYSTEM
						.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.systemName) LIKE  :"
							+ OSMSMessageLogDBConstants.PARAM_SYSTEM_NAME);
				}
			}
		}

		String sortOrder = request.getSortOrder();
		String sortField = request.getSortField();

		if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_KEY.equals(sortField)) {
			sqlQuery.append(" ORDER BY n.messageKey " + " " + sortOrder);
		} else if (OSMSMessageLogCommonConstants.FILTER_ORI.equals(sortField)) {
			sqlQuery.append(" ORDER BY n.ori " + " " + sortOrder);
		} else if (OSMSMessageLogCommonConstants.FILTER_CORRELATION_ID
				.equals(sortField)) {
			sqlQuery.append(" ORDER BY n.correlationId " + " " + sortOrder);
		} else if ("insertDate".equals(sortField)) {
			sqlQuery.append(" ORDER BY n.insertDate " + " " + sortOrder);
		} else if (OSMSMessageLogCommonConstants.FILTER_FBI_NUMBER
				.equals(sortField)) {
			sqlQuery.append(" ORDER BY n.fbiNumber " + " " + sortOrder);
		} else if (OSMSMessageLogCommonConstants.FILTER_STATE_ID
				.equals(sortField)) {
			sqlQuery.append(" ORDER BY n.sid " + " " + sortOrder);
		} else if (OSMSMessageLogCommonConstants.FILTER_SYSTEM
				.equals(sortField)) {
			sqlQuery.append(" ORDER BY n.systemName " + " " + sortOrder);
		}

		Query jpaQuery = this.eManager.createQuery(sqlQuery.toString());

		Date startDateTime = request.getStartDateTime();
		Date endDateTime = request.getEndDateTime();

		jpaQuery.setParameter(OSMSMessageLogDBConstants.PARAM_START_DATE_TIME,
				startDateTime).setParameter(
				OSMSMessageLogDBConstants.PARAM_END_DATE_TIME, endDateTime);

		if (CollectionUtils.isNotEmpty(paramKeys)) {
			for (String paramKey : paramKeys) {
				Object value = params.get(paramKey);

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_KEY
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_MESSAGE_KEY, "%"
									+ value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_ORI.equals(paramKey)) {
					jpaQuery.setParameter(OSMSMessageLogDBConstants.PARAM_ORI,
							"%" + value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_CORRELATION_ID
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_CORRELATIONID, "%"
									+ value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_LOG_TYPE
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE,
							value.toString());
				}

				if (OSMSMessageLogCommonConstants.FILTER_FBI_NUMBER
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_FBI_NUMBER, "%"
									+ value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_STATE_ID
						.equals(paramKey)) {
					jpaQuery.setParameter(OSMSMessageLogDBConstants.PARAM_SID,
							Long.valueOf(value.toString()));
				}

				if (OSMSMessageLogCommonConstants.FILTER_SYSTEM
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_SYSTEM_NAME, "%"
									+ value.toString().toUpperCase() + "%");
				}

			}
		}

		jpaQuery.setFirstResult(request.getStart());
		jpaQuery.setMaxResults(request.getOffset());

		return jpaQuery.getResultList();
	}

	/**
	 * Gets the MessageLogEntity by log id.
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getByLogId(com.gcom.osms.messagelog.po.model.MessageLogEntity)
	 */
	@Override
	public MessageLogEntity getByLogId(final MessageLogEntity log)
			throws OSMSMessageLogServiceException {
		return this.eManager
				.find(MessageLogEntity.class, log.getMessagelogId());
	}

	/**
	 * Gets the MessageLogEntity by messageId and messageLogType And messageKey.
	 * 
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getByMessageIdAndMessageLogTypeAndMessageKey(com.gcom.osms.messagelog.po.model.MessageLogEntity)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public MessageLogEntity getByMessageIdAndMessageLogTypeAndMessageKey(
			final MessageLogEntity log) throws OSMSMessageLogServiceException {
		MessageLogEntity retval = null;
		Query namedQuery = this.eManager
				.createNamedQuery(OSMSMessageLogDBConstants.QRY_BY_MESSAGE_ID_MESSAGE_LOG_TYPE_MESSAGE_KEY);

		namedQuery.setParameter(
				OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE,
				log.getMessageLogType());
		namedQuery.setParameter(OSMSMessageLogDBConstants.PARAM_MESSAGE_ID,
				log.getMessageId());
		namedQuery.setParameter(OSMSMessageLogDBConstants.PARAM_MESSAGE_KEY,
				log.getMessageKey());

		List resultList = namedQuery.getResultList();

		if (CollectionUtils.isNotEmpty(resultList)) {
			retval = (MessageLogEntity) resultList.get(0);
		}

		return retval;
	}

	/**
	 * Gets the list of MessageLogEntity by date time range
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getByPeriod(java.util.Date,java.util.Date, com.gcom.osms.messagelog.po.model.MessageLogEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLogEntity> getByPeriod(final Date startDateTime,
			final Date endDateTime, final MessageLogEntity log)
			throws OSMSMessageLogServiceException {
		// TODO Auto-generated method stub
		return this.eManager
				.createNamedQuery(
						OSMSMessageLogDBConstants.QRY_FIND_BY_PERIOD_RANGE)
				.setParameter(OSMSMessageLogDBConstants.PARAM_START_DATE_TIME,
						startDateTime)
				.setParameter(OSMSMessageLogDBConstants.PARAM_END_DATE_TIME,
						endDateTime).getResultList();
	}

	/**
	 * Gets the list of MessageLogEntity by period(interval)
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getByPeriod(java.lang.Integer, com.gcom.osms.messagelog.po.model.MessageLogEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLogEntity> getByPeriod(final Integer interval,
			final MessageLogEntity log) throws OSMSMessageLogServiceException {
		Date date = new Date(System.currentTimeMillis() - interval * SECONDS);
		return this.eManager
				.createNamedQuery(OSMSMessageLogDBConstants.QRY_FIND_BY_PERIOD)
				.setParameter(OSMSMessageLogDBConstants.PARAM_TIME, date)
				.getResultList();
	}

	/**
	 * Gets the MessageLogCount by criteria
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getMessageLogCountByCriteria(com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest)
	 */
	@Override
	public Long getMessageLogCountByCriteria(
			final SearchMessageLogRequest request)
			throws OSMSMessageLogServiceException {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT count(n.messagelogId) FROM MessageLogEntity n");

		// {messageLogType=OUT, correlationId=3, status=r, messageKey=p, ori=4}

		sqlQuery.append(" WHERE n.insertDate >= :"
				+ OSMSMessageLogDBConstants.PARAM_START_DATE_TIME
				+ " and n.insertDate <= :"
				+ OSMSMessageLogDBConstants.PARAM_END_DATE_TIME);

		Map<String, Object> params = request.getParams();

		Set<String> paramKeys = params.keySet();

		if (CollectionUtils.isNotEmpty(paramKeys)) {
			for (String paramKey : paramKeys) {

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_KEY
						.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.messageKey) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_MESSAGE_KEY);
				}

				if (OSMSMessageLogCommonConstants.FILTER_ORI.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.ori) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_ORI);
				}

				if (OSMSMessageLogCommonConstants.FILTER_CORRELATION_ID
						.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.correlationId) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_CORRELATIONID);
				}

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_LOG_TYPE
						.equals(paramKey)) {
					sqlQuery.append(" and n.messageLogType = :"
							+ OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE);
				}

				if (OSMSMessageLogCommonConstants.FILTER_FBI_NUMBER
						.equals(paramKey)) {
					sqlQuery.append(" and  UPPER(n.fbiNumber) LIKE :"
							+ OSMSMessageLogDBConstants.PARAM_FBI_NUMBER);
				}

				if (OSMSMessageLogCommonConstants.FILTER_STATE_ID
						.equals(paramKey)) {
					sqlQuery.append(" and n.sid = :"
							+ OSMSMessageLogDBConstants.PARAM_SID);
				}

				if (OSMSMessageLogCommonConstants.FILTER_SYSTEM
						.equals(paramKey)) {
					sqlQuery.append(" and UPPER(n.systemName) LIKE  :"
							+ OSMSMessageLogDBConstants.PARAM_SYSTEM_NAME);
				}

			}
		}

		Query jpaQuery = this.eManager.createQuery(sqlQuery.toString());

		Date startDateTime = request.getStartDateTime();
		Date endDateTime = request.getEndDateTime();

		jpaQuery.setParameter(OSMSMessageLogDBConstants.PARAM_START_DATE_TIME,
				startDateTime).setParameter(
				OSMSMessageLogDBConstants.PARAM_END_DATE_TIME, endDateTime);

		if (CollectionUtils.isNotEmpty(paramKeys)) {
			for (String paramKey : paramKeys) {
				Object value = params.get(paramKey);

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_KEY
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_MESSAGE_KEY, "%"
									+ value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_ORI.equals(paramKey)) {
					jpaQuery.setParameter(OSMSMessageLogDBConstants.PARAM_ORI,
							"%" + value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_CORRELATION_ID
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_CORRELATIONID, "%"
									+ value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_MESSAGE_LOG_TYPE
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_MESSAGE_LOG_TYPE,
							value.toString());
				}

				if (OSMSMessageLogCommonConstants.FILTER_FBI_NUMBER
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_FBI_NUMBER, "%"
									+ value.toString().toUpperCase() + "%");
				}

				if (OSMSMessageLogCommonConstants.FILTER_STATE_ID
						.equals(paramKey)) {
					jpaQuery.setParameter(OSMSMessageLogDBConstants.PARAM_SID,
							Long.valueOf(value.toString()));
				}

				if (OSMSMessageLogCommonConstants.FILTER_SYSTEM
						.equals(paramKey)) {
					jpaQuery.setParameter(
							OSMSMessageLogDBConstants.PARAM_SYSTEM_NAME, "%"
									+ value.toString().toUpperCase() + "%");
				}

			}
		}

		return (Long) jpaQuery.getSingleResult();
	}

	/**
	 * Gets the next correlation id.
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#getNextCorrelationId()
	 */
	/*@Override
	public long getNextCorrelationId() throws OSMSMessageLogServiceException {

		List<?> nextAssignableValue = this.eManager.createNamedQuery(
				"NEXT_CORRELATION_ID").getResultList();

		return ((Number) nextAssignableValue.get(0)).longValue();
	}*/

	/**
	 * insert MessageLogEntity
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#insert(com.gcom.osms.messagelog.po.model.MessageLogEntity)
	 */
	@Override
	public Long insert(final MessageLogEntity log)
			throws OSMSMessageLogServiceException {
		return this.persist(log);
	}

	/**
	 * Insert MessageLogStatusEntity
	 *
	 * @see com.gcom.osms.messagelog.ds.OSMSMessageLogDataService#insert(com.gcom.osms.messagelog.po.model.MessageLogStatusEntity)
	 */
	@Override
	public Long insert(final MessageLogStatusEntity log)
			throws OSMSMessageLogServiceException {
		return this.persist(log);
	}

	
	/**
	 * Persists the entity using the Entity Manager.
	 * @param mLogEntity
	 * @return
	 */
	private Long persist(final LogEntity mLogEntity) {

		Long databaseId = null;

		if (mLogEntity instanceof MessageLogEntity) {
			MessageLogEntity messageLogEntity = (MessageLogEntity) this.eManager
					.merge(mLogEntity);
			databaseId = messageLogEntity.getMessagelogId();
		} else if (mLogEntity instanceof MessageLogStatusEntity) {
			MessageLogStatusEntity logStatusEntity = (MessageLogStatusEntity) this.eManager
					.merge(mLogEntity);
			databaseId = logStatusEntity.getMessageLog().getMessagelogId();
		}
		// this.eManager.flush();
		return databaseId;
	}

}
