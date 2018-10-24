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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.gcom.osms.messagelog.bo.model.MessageLog;
import com.gcom.osms.messagelog.bo.model.StatusLog;
import com.gcom.osms.messagelog.ds.impl.AbstractDataServiceBaseTest;
import com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.LogStatusRequest;
import com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.RetrieveStatusLogsRequest;
import com.gcom.osms.messagelog.dto.request.SearchMessageLogRequest;
import com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest;
import com.gcom.osms.messagelog.dto.response.CreateMessageLogResponse;
import com.gcom.osms.messagelog.dto.response.OSMSMessageLogResponse;
import com.gcom.osms.messagelog.dto.response.RetrieveMessageLogResponse;
import com.gcom.osms.messagelog.dto.response.RetrieveStatusLogsResponse;
import com.gcom.osms.messagelog.dto.response.SearchMessageLogResponse;


public class OSMSMessageLogServiceImplTest extends AbstractDataServiceBaseTest {

	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#createMessageLog(com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest)}
	 * .
	 */
	@Test
	public void testInsertMessageLog() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		CreateMessageLogRequest request = new CreateMessageLogRequest();

		MessageLog messageLog = new MessageLog();

		messageLog.setCorrelationId(UUID.randomUUID().toString());
		messageLog.setMessageId("31432142");
		messageLog.setMessageKey("CPI");
		messageLog.setMessageLogType("OUT");
		messageLog.setMnemonic("4324324");
		messageLog.setOri("FL7897686");

		messageLog.setHeader("Service Header");
		messageLog.setMessage("Service Unsolicitated Payload");
		messageLog.setStatus("Service Status");
		

		request.setMessageLog(messageLog);

		CreateMessageLogResponse response = service.createMessageLog(request);

		Long id = response.getMessageLog().getLogId();

		Assert.assertNotNull(id);
		Assert.assertTrue(id > 0l);

		System.out.println("ID inserted:" + id);

	}
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#createMessageLogInNewTransaction(com.gcom.osms.messagelog.dto.request.CreateMessageLogRequest)}
	 * .
	 */
	@Test
	public void testCreateMessageLogInNewTransaction() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		CreateMessageLogRequest request = new CreateMessageLogRequest();

		MessageLog messageLog = new MessageLog();

		messageLog.setCorrelationId(UUID.randomUUID().toString());
		messageLog.setMessageId("31432142");
		messageLog.setMessageKey("CPI");
		messageLog.setMessageLogType("OUT");
		messageLog.setMnemonic("4324324");
		messageLog.setOri("FL7897686");
		messageLog.setSystem("SABIS");

		// messageLog.setHeader("Service Header");
		messageLog.setMessage("Service Unsolicitated Payload");
		messageLog.setStatus("Service Status");

		request.setMessageLog(messageLog);

		CreateMessageLogResponse response = service.createMessageLogInNewTransaction(request);

		Long id = response.getMessageLog().getLogId();

		Assert.assertNotNull(id);
		Assert.assertTrue(id > 0l);

		System.out.println("ID inserted:" + id);

	}
	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#generateNextCCHMessageId()}
	 * .
	 */
	/*@Test
	public void testGenerateNextCCHMessageId() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		GenerateNextMessageIdResponse response = service
				.generateNextCCHMessageId();
		String cchMessageId = response.getMessageId();

		Assert.assertNotNull(cchMessageId);

		System.out.println("Next CCH Message ID:" + cchMessageId);

	}*/

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#getAllStatusByLogId(com.gcom.osms.messagelog.dto.request.RetrieveStatusLogsRequest)}
	 * .
	 */
	@Test
	public void testGetAllStatusByLogId() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		RetrieveStatusLogsRequest request = new RetrieveStatusLogsRequest();

		StatusLog findLog = new StatusLog();
		findLog.setMessagelogId(14979l);
		request.setStatusLog(findLog);
		RetrieveStatusLogsResponse response = service
				.getAllStatusByLogId(request);
		List<StatusLog> stats = response.getStatusLogs();

		Assert.assertTrue(!stats.isEmpty());

	}
	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#getByCorrelationIdMessageLogTypeAndSystemName(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)}
	 * .
	 */
	@Test
	public void testGetByCorrelationIdMessageLogTypeAndSystemName() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		RetrieveMessageLogRequest request = new RetrieveMessageLogRequest();

		MessageLog findLog = new MessageLog();
		findLog.setCorrelationId("10f2c0af-82f5-4900-a4c9-5cdeb9a50b93");
		findLog.setMessageLogType("OUT");
		findLog.setSystem("SABIS");
		request.setMessageLog(findLog);
		RetrieveMessageLogResponse response = service
				.getByCorrelationIdMessageLogTypeAndSystemName(request);
		MessageLog messageLog = response.getMessageLog();

		Assert.assertTrue(messageLog.getCorrelationId().equals(findLog.getCorrelationId()));

	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#getByLogId(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)}
	 * .
	 */
	@Test
	public void testGetByLogId() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		RetrieveMessageLogRequest request = new RetrieveMessageLogRequest();

		MessageLog findLog = new MessageLog();
		findLog.setMessagelogId(14995l);
		request.setMessageLog(findLog);

		RetrieveMessageLogResponse response = service.getByLogId(request);

		MessageLog retLog = response.getMessageLog();

		Assert.assertNotNull(retLog);
		Assert.assertNotNull(retLog.getMessage());
		Assert.assertNotNull(retLog.getHeader());
		
	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#getByMessageIdAndMessageLogTypeAndMessageKey(com.gcom.osms.messagelog.dto.request.RetrieveMessageLogRequest)}
	 * .
	 */
	@Test
	public void testGetByMessageIdAndMessageLogTypeAndMessageKey()
			throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		RetrieveMessageLogRequest request = new RetrieveMessageLogRequest();

		MessageLog findLog = new MessageLog();
		findLog.setMessageId("31432142");
		findLog.setMessageLogType("OUT");
		findLog.setMessageKey("CPI");
		request.setMessageLog(findLog);

		RetrieveMessageLogResponse response = service
				.getByMessageIdAndMessageLogTypeAndMessageKey(request);

		MessageLog retLog = response.getMessageLog();

		Assert.assertNotNull(retLog);
	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#getByPeriod(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)}
	 * .
	 */
	@Test
	public void testGetByPeriod() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		OSMSMessageLogRequest request = new OSMSMessageLogRequest();

		MessageLog findLog = new MessageLog();
		request.setMessagelog(findLog);

		request.setInterval(7 * 24 * 3600);

		OSMSMessageLogResponse response = service.getByPeriod(request);

		List<MessageLog> retLog = response.getMessageLogs();
		Assert.assertNotNull(retLog);
		//Assert.assertTrue(!retLog.isEmpty());

	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#getResponse(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)}
	 * .
	 */
	/*@Test
	public void testGetResponseForSolicitedMessage() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		OSMSMessageLogRequest request = new OSMSMessageLogRequest();

		MessageLog findLog = new MessageLog();
		findLog.setMessagelogId(4151l);
		findLog.setCorrelationId("f291a558-dda5-4d7b-bb01-497d9b849d88");
		findLog.setMessageLogType("IN");

		request.setMessagelog(findLog);

		OSMSMessageLogResponse response = null;

		MessageLog retLog = response.getMessageLog();

		Assert.assertNotNull(retLog);
		Assert.assertNotNull(retLog.getHeader());
		Assert.assertNotNull(retLog.getMessage());
	}*/

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#getResponse(com.gcom.osms.messagelog.dto.request.OSMSMessageLogRequest)}
	 * .
	 */
	/*@Test
	public void testGetResponseForUnSolicitedMessage() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		OSMSMessageLogRequest request = new OSMSMessageLogRequest();

		MessageLog findLog = new MessageLog();
		findLog.setMessagelogId(4152l);
		findLog.setCorrelationId("5485b106-ff9f-471d-a12f-472cff1cda97");
		findLog.setMessageLogType("IN");

		request.setMessagelog(findLog);

		OSMSMessageLogResponse response = null;

		MessageLog retLog = response.getMessageLog();

		Assert.assertNotNull(retLog);
		Assert.assertNull(retLog.getHeader());
		Assert.assertNotNull(retLog.getMessage());
	}*/

	

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#logStatus(com.gcom.osms.messagelog.dto.request.LogStatusRequest)}
	 * .
	 */
	@Test
	public void testInsertStatusLog() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		LogStatusRequest request = new LogStatusRequest();

		StatusLog statusLog = new StatusLog();
		statusLog.setMessagelogId(14996l);
		statusLog.setStatus("Test_Service_Initiated");

		request.setStatusLog(statusLog);

		service.logStatus(request);

	}
	
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#logStatusInNewTransaction(com.gcom.osms.messagelog.dto.request.LogStatusRequest)}
	 * .
	 */
	@Test
	public void testLogStatusInNewTransaction() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		LogStatusRequest request = new LogStatusRequest();

		StatusLog statusLog = new StatusLog();
		statusLog.setMessagelogId(14996l);
		statusLog.setStatus("Test_Service_Initiated");

		request.setStatusLog(statusLog);

		service.logStatusInNewTransaction(request);

	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#logStatusInNewTransaction(com.gcom.osms.messagelog.dto.request.LogStatusRequest)}
	 * .
	 */
	@Test
	public void testSearchMessageLog() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		SearchMessageLogRequest request = new SearchMessageLogRequest();
		request.setStartDateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-10"));
		request.setEndDateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-22"));
		request.setParams(new HashMap<>());
		SearchMessageLogResponse resp = service.searchMessageLog(request);
		Assert.assertNotNull(resp);
	}
	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#updateMessageLog(com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest)}
	 * .
	 */
	@Test
	public void testUpdateMessageLog() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		UpdateMessageLogRequest request = new UpdateMessageLogRequest();

		MessageLog messageLog = new MessageLog();
		messageLog.setMessagelogId(14996l);
		messageLog.setHeader("Unsoliciated header");

		request.setMessagelog(messageLog);

		service.updateMessageLog(request);
	}

	/**
	 * Test method for
	 * {@link com.gcom.osms.messagelog.bs.impl.OSMSMessageLogServiceImpl#updateMessageLogHeader(com.gcom.osms.messagelog.dto.request.UpdateMessageLogRequest)}
	 * .
	 */
	@Test
	public void testUpdateMessageLogHeader() throws Exception {
		OSMSMessageLogServiceImpl service = new OSMSMessageLogServiceImpl(
				this.getTestEntityManager());

		UpdateMessageLogRequest request = new UpdateMessageLogRequest();

		MessageLog messageLog = new MessageLog();
		messageLog.setMessagelogId(14996l);
		messageLog.setHeader("Unsoliciated header");

		request.setMessagelog(messageLog);

		service.updateMessageLogHeader(request);
	}

}
