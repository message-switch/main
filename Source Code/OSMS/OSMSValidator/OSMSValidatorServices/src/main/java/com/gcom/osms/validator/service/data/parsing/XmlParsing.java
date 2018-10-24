/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package com.gcom.osms.validator.service.data.parsing;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * 
 * The XmlParsing class parse the xml content received for rule validations
 *
 */
public class XmlParsing {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(XmlParsing.class);
	
	/**
	 * Convert String to Document object
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private static Document stringToDocumet(String str) throws Exception {
		LOGGER.debug("Xml String::"+str);
		String xmlString = null;
		if (str != null) {
			xmlString = str;
		}
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = db.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
		return document;
	}

	/**
	 * Get the XPath value by passing xmlString and xPath
	 * @param str
	 * @param xPathStr
	 * @return
	 * @throws Exception
	 */
	public static String getXPathVal(String xmlString, String xPathStr) throws Exception {
		LOGGER.debug("getXPathVal str::"+xmlString);
		LOGGER.debug("getXPathVal xPathStr::"+xPathStr);
		String result = null;
		Document doc = stringToDocumet(xmlString);
		List<Object> list = XmlParsing.getXPathVal(doc, xPathStr);
		if(!CollectionUtils.isEmpty(list) && list.size()==1){
			result = list.get(0).toString();
		}
		LOGGER.debug("return ::"+result);
		return result;
	}

	/**
	 * Get the XPath value by passing Document and xPathStr
	 * @param str
	 * @param xPathStr
	 * @return
	 * @throws Exception
	 */
	private static List<Object> getXPathVal(Document doc, String xPathStr) throws XPathExpressionException {
		List<Object> list = new ArrayList<>();
		// Get XPath expression
		XPathFactory xpathfactory = XPathFactory.newInstance();
		XPath xpath = xpathfactory.newXPath();
		// xpath.setNamespaceContext(new NamespaceResolver(doc));
		XPathExpression expr = xpath.compile(xPathStr);

		// Search XPath expression
		Object result = expr.evaluate(doc, XPathConstants.NODESET);

		// Iterate over results and fetch book names
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			list.add(nodes.item(i).getNodeValue());
		}
		return list;
	}

}

class NamespaceResolver implements NamespaceContext {
	// Store the source document to search the namespaces
	private Document sourceDocument;

	public NamespaceResolver(Document document) {
		sourceDocument = document;
	}

	// The lookup for the namespace uris is delegated to the stored document.
	public String getNamespaceURI(String prefix) {
		if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
			return sourceDocument.lookupNamespaceURI(null);
		} else {
			return sourceDocument.lookupNamespaceURI(prefix);
		}
	}

	public String getPrefix(String namespaceURI) {
		return sourceDocument.lookupPrefix(namespaceURI);
	}

	@SuppressWarnings("rawtypes")
	public Iterator getPrefixes(String namespaceURI) {
		return null;
	}
}
