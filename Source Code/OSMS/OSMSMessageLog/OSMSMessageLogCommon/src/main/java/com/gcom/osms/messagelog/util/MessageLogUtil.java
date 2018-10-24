/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.messagelog.util;

import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.xml.bind.Marshaller.JAXB_ENCODING;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.gcom.osms.messagelog.bo.model.MessageMetadata;

/**
 * The class MessageLogUtil.
 */
public class MessageLogUtil {

	
	/**
	 * Gets the message.
	 * @param messageMetadata
	 * @return
	 * @throws JAXBException
	 */
	public static String getMessage(final MessageMetadata messageMetadata)
			throws JAXBException {
		JAXBContext jaxbContext = JAXBContext
				.newInstance(MessageMetadata.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(JAXB_ENCODING, UTF_8.name());
		StringWriter writer = new StringWriter();
		marshaller.marshal(messageMetadata, writer);
		return writer.toString();
	}

	// Convert message content to Message Meta data

	
	/**
	 * Gets the message metada.
	 * @param messageContent
	 * @return
	 * @throws JAXBException
	 */
	public static MessageMetadata getMessageMetada(final String messageContent)
			throws JAXBException {
		MessageMetadata messageMetadata = null;
		JAXBContext jaxbContext = JAXBContext
				.newInstance(MessageMetadata.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(messageContent);
		messageMetadata = (MessageMetadata) unmarshaller.unmarshal(reader);
		return messageMetadata;
	}
}
