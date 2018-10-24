/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.ds.mapper;

import java.util.ArrayList;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
/**
 * Dozer Mapper
 *
 */
public final class DozerMapperWrapper {
	
	
	private static class DozerMapperWrapperHolder {
		/** The instance. */
		private static DozerMapperWrapper dozerMapperWrapper = new DozerMapperWrapper();
	}
	
	/**
	 * Get the singleton instance
	 * @return
	 */
	public static DozerMapperWrapper instance() {
		return DozerMapperWrapperHolder.dozerMapperWrapper;
	}

	/** The MAPPER. */
	private final DozerBeanMapper mapper;
	
	/**
	 * Instantiates a new dozer MAPPER wrapper.
	 */
	private DozerMapperWrapper() {
		super();
		this.mapper = new DozerBeanMapper();
		final ArrayList<String> mappingFileUrls = new ArrayList<>();
		mappingFileUrls.add("config/dozer/mappings/dissemination-po-bo-mapping.xml");
		this.mapper.setMappingFiles(mappingFileUrls);
	}

	/**
	 * Gets the MAPPER.
	 *
	 * @return the MAPPER
	 */
	public Mapper getMapper() {
		return this.mapper;
	}

}
