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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.messagelog.ds.OSMSMessageLogDataService;
import com.gcom.osms.messagelog.ds.impl.OSMSMessageLogDataServiceImpl;

/**
 * The base class for Data Service testing.
 * 
 *
 */
public abstract class AbstractDataServiceBaseTest {

	protected static final Logger LOGGER = LoggerFactory
			.getLogger("unitTestLogger");
	protected static final String USER_ID = "JUNIT";

	private static EntityManagerFactory EM_FACT = null;

	private static final String PERSISTENCE_UNIT_NAME = "OSMSMessageLog";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
		if (EM_FACT == null) {
			EM_FACT = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	protected OSMSMessageLogDataService service;

	private EntityManager testEntityManager;

	public EntityManager getTestEntityManager() {
		return this.testEntityManager;
	}

	@Before
	public void setUp() throws Exception {
		this.testEntityManager = EM_FACT.createEntityManager();
		this.testEntityManager.setFlushMode(FlushModeType.COMMIT);
		this.service = new OSMSMessageLogDataServiceImpl(
				this.testEntityManager);

		this.testEntityManager.getTransaction().begin();
		// this.messageLogEntityEntry();
	}

	@After
	public void tearDown() throws Exception {
		this.endTransaction();
		// this.beginTransaction();
		// this.messageLogEntityDelete();
		// this.endTransaction();
	}

	private void beginTransaction() {
		final EntityTransaction transaction = this.testEntityManager
				.getTransaction();
		if (transaction == null || !transaction.isActive()) {
			this.testEntityManager.getTransaction().begin();
		}
	}

	private void endTransaction() {
		// this.testEntityManager.flush();
		final EntityTransaction transaction = this.testEntityManager
				.getTransaction();
		if (transaction != null && transaction.isActive()) {
			System.out.println("endTransaction Transaction Commit");
			transaction.commit();
		}
	}

}
