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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.gcom.osms.messagelog.bo.model.MessageLog;
import com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl;
import com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest;
import com.gcom.osms.messagelog.dto.response.RetrieveMessageLogResponse;
import com.gcom.osms.messagelog.exception.OSMSMessageLogServiceException;
import com.gcom.osms.messagelog.po.model.MessageLogEntity;
import com.gcom.osms.messagelog.po.model.MessageLogHeaderEntity;
import com.gcom.osms.messagelog.po.model.MessageLogPayloadEntity;
import com.gcom.osms.messagelog.po.model.MessageLogStatusEntity;

public class OSMSMessageLogDataServiceImplTest extends
		AbstractDataServiceBaseTest {

	/*@Test
	public void testGenerateNextCCHMessageId() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());
		long cchMessageId = dataService.generateNextCCHMessageId();

		Assert.assertTrue(cchMessageId > 0l);

		System.out.println("Next CCH Message ID:" + cchMessageId);
	}*/

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getAllStatusByLogId(com.gcom.osms.messagelog.po.model.MessageLogStatusEntity)}
	 * .
	 */
	@Test
	public void testgetAllStatusByLogId() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		MessageLogStatusEntity sLogEntity = new MessageLogStatusEntity();
		MessageLogEntity messageLog = new MessageLogEntity();
		messageLog.setMessagelogId(14996l);

		sLogEntity.setMessageLog(messageLog);

		List<MessageLogStatusEntity> retval = dataService
				.getAllStatusByLogId(sLogEntity);

		Assert.assertTrue(!retval.isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getAllStatusByLogIdSortedByInsertDate(com.gcom.osms.messagelog.po.model.MessageLogEntity)}
	 * .
	 */
	@Test
	public void testgetAllStatusByLogIdSortedByInsertDate() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		MessageLogEntity messageLog = new MessageLogEntity();
		messageLog.setMessagelogId(14996l);

		List<MessageLogStatusEntity> retval = dataService
				.getAllStatusByLogIdSortedByInsertDate(messageLog);

		Assert.assertTrue(!retval.isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByCorrelationIdAndMessageLogType(com.gcom.osms.messagelog.po.model.MessageLogEntity)}
	 * .
	 */
	@Test
	public void testGetByCorrelationIdAndMessageLogType() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		MessageLogEntity log = new MessageLogEntity();

		log.setMessageLogType("OUT");
		log.setCorrelationId("27a6ef34-726e-4aeb-b3b4-ea52d2adc8fa");

		MessageLogEntity retval = dataService
				.getByCorrelationIdAndMessageLogType(log);

		Assert.assertNotNull(retval);

	}
	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByCorrelationIdMessageLogTypeAndSystemName(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)}
	 * .
	 */
	@Test
	public void testGetByCorrelationIdMessageLogTypeAndSystemName() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());
		RetrieveMessageLogRequest req = new RetrieveMessageLogRequest();
		MessageLog messageLog = new MessageLog();
		messageLog.setMessageLogType("OUT");
		messageLog.setCorrelationId("10f2c0af-82f5-4900-a4c9-5cdeb9a50b93");
		messageLog.setSystem("SABIS");
		req.setMessageLog(messageLog);

		MessageLogEntity retval = dataService
				.getByCorrelationIdMessageLogTypeAndSystemName(req);

		Assert.assertNotNull(retval);

	}
	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByCorrelationIdMessageLogTypeAndSystemName(com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest)}
	 * .
	 */
	@Test
	public void testGetByCriteria() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());
		SearchMessageLogRequest req = new SearchMessageLogRequest();
		Map<String, Object> params = new HashMap<>();
		req.setParams(params);
		req.setStartDateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-10"));
		req.setEndDateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-23"));
		List<MessageLogEntity> retval = dataService.getByCriteria(req);

		Assert.assertNotNull(retval);
		Assert.assertTrue(retval.size()>0);

	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByLogId(com.gcom.osms.messagelog.po.model.MessageLogEntity)}
	 * .
	 */
	@Test
	public void testGetByLogId() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());
		MessageLogEntity log = new MessageLogEntity();
		log.setMessagelogId(14996l);
		MessageLogEntity retval = dataService.getByLogId(log);
		Assert.assertNotNull(retval);
	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByMessageIdAndMessageLogTypeAndMessageKey(com.gcom.osms.messagelog.po.model.MessageLogEntity)}
	 * .
	 */
	@Test
	public void testGetByMessageIdAndMessageLogTypeAndMessageKey()
			throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		MessageLogEntity log = new MessageLogEntity();
		log.setMessageLogType("OUT");
		log.setMessageId("31432142");
		log.setMessageKey("CPI");

		MessageLogEntity retval = dataService
				.getByMessageIdAndMessageLogTypeAndMessageKey(log);

		Assert.assertNotNull(retval);
	}
	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByPeriod(java.util.Date,java.util.Date,com.gcom.osms.messagelog.po.model.MessageLogEntity)}
	 * .
	 */
	@Test
	public void testGetByPeriodWithDate() throws Exception {
		OSMSMessageLogDataServiceImpl service = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		List<MessageLogEntity> retval = service
				.getByPeriod(new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-10"),
						new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-23")
						, null);

		Assert.assertNotNull(retval);
		Assert.assertTrue(!retval.isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByPeriod(java.lang.Integer,com.gcom.osms.messagelog.po.model.MessageLogEntity)}
	 * .
	 */
	@Test
	public void testGetByPeriod() throws Exception {
		OSMSMessageLogDataServiceImpl service = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		List<MessageLogEntity> retval = service
				.getByPeriod(7 * 24 * 3600, null);

		Assert.assertNotNull(retval);
		Assert.assertTrue(!retval.isEmpty());
	}
	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getMessageLogCountByCriteria(com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest)}
	 * .
	 */
	@Test
	public void testGetMessageLogCountByCriteria() throws Exception {
		OSMSMessageLogDataServiceImpl dataService = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());
		SearchMessageLogRequest req = new SearchMessageLogRequest();
		Map<String, Object> params = new HashMap<>();
		req.setParams(params);
		req.setStartDateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-10"));
		req.setEndDateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-23"));
		long count = dataService.getMessageLogCountByCriteria(req);

		Assert.assertTrue(count>0);

	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#getByLogId(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogResponse)}
	 * .
	 */
	@Test
	public void testGetMessageLog() throws OSMSMessageLogServiceException {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		RetrieveMessageLogRequest request = new RetrieveMessageLogRequest();

		MessageLog findLog = new MessageLog();
		findLog.setMessagelogId(14996l);

		request.setMessageLog(findLog);

		RetrieveMessageLogResponse response = service.getByLogId(request);

		MessageLog messageLogResponse = response.getMessageLog();

		System.out.println("Header: " + messageLogResponse.getHeader());
		System.out.println("Payload: \n" + messageLogResponse.getMessage());

	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#insert(com.gcom.osms.messagelog.po.model.MessageLogEntity)}
	 * .
	 */
	@Test
	public void testInsertMessageLog() throws Exception {
		OSMSMessageLogDataServiceImpl service = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		MessageLogEntity logEntity = new MessageLogEntity();
		logEntity.setCorrelationId(UUID.randomUUID().toString());
		logEntity.setMessageId("31432142");
		logEntity.setMessageKey("CPI");
		logEntity.setMessageLogType("IN");
		logEntity.setMnemonic("4324324");
		logEntity.setOri("FL7897686");

		MessageLogHeaderEntity headerEntity = new MessageLogHeaderEntity();
		headerEntity.setHeader("Test Header".getBytes());
		headerEntity.setReplyTo("Test_Sender");

		MessageLogPayloadEntity payloadEntity = new MessageLogPayloadEntity();
		payloadEntity.setPayload("Test Payload".getBytes());
		payloadEntity.setMessageLog(logEntity);

		logEntity.addMessageLogHeader(headerEntity);

		List<MessageLogPayloadEntity> messageLogPayloads = new ArrayList<MessageLogPayloadEntity>();
		messageLogPayloads.add(payloadEntity);

		logEntity.setMessageLogPayloads(messageLogPayloads);

		Long id = service.insert(logEntity);

		Assert.assertNotNull(id);
		Assert.assertTrue(id > 0l);

		System.out.println("ID inserted:" + id);
	}
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#insert(com.gcom.osms.messagelog.po.model.MessageLogStatusEntity)}
	 * .
	 */
	@Test
	public void testInsertStatusLog() throws Exception {
		OSMSMessageLogDataServiceImpl service = new OSMSMessageLogDataServiceImpl(
				this.getTestEntityManager());

		MessageLogEntity log = new MessageLogEntity();
		log.setMessagelogId(14996l);

		MessageLogStatusEntity statusLogEntity = new MessageLogStatusEntity();
		statusLogEntity.setStatus("Test_Initiated");
		statusLogEntity.setMessageLog(log);

		Long messageId = service.insert(statusLogEntity);

		System.out.println("Status for ID inserted:" + messageId);

	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogDataServiceImpl#updateMessageLogHeader(com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest)}
	 * .
	 */
	@Test
	public void testUpdateMessageLogHeader()
			throws OSMSMessageLogServiceException {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		UpdateMessageLogRequest request = new UpdateMessageLogRequest();

		MessageLog messagelog = new MessageLog();

		messagelog.setMessagelogId(14996l);
		messagelog.setHeader("Test_Header1");

		request.setMessagelog(messagelog);
		service.updateMessageLogHeader(request);
	}

}
