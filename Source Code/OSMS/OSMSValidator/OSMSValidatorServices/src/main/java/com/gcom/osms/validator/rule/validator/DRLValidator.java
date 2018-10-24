/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.rule.validator;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcom.osms.validator.common.ValidatorRequest;

/**
 * 
 * Validator class for executing DRL validations
 *
 */
public class DRLValidator extends Validator{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -3772835927057245996L;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(DRLValidator.class);
	
	/**
	 * Method to execute DRL validations
	 */
	@Override
	public Map<String, Object[]> validate(ValidatorRequest request, String fileName) throws Exception {
		LOGGER.debug("inside validate");
		Map<String, Object[]> response = executeRule(request,fileName);
		return response;
	}
	
	/**
	 * Execute list of rules
	 * @param request
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object[]> executeRule(ValidatorRequest request,String fileName) throws Exception {
		KnowledgeBase kbase = readKnowledgeBase(fileName);
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		Map<String, Object[]> errorMessages = new HashMap<>();
		ksession.setGlobal("errorMessages",errorMessages);
		ksession.insert(request);
		ksession.fireAllRules();
		System.out.println("Completed the rule execution ");
		Object results = ksession.getGlobal("errorMessages");
		System.out.println("results:: "+results);
		Map<String, Object[]> errorMsgs = (Map<String, Object[]>)results;
		return errorMsgs;
	}

	/**
	 * Get the KnowledgeBase object
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	private static KnowledgeBase readKnowledgeBase(String fileName) throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("rules/drl/"+fileName), ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();

		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		return kbase;
	}
	
}
