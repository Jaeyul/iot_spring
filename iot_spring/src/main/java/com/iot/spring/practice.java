package com.iot.spring;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class practice {

	public static void main(String[] args) {
//		InputStream is = Excute.class.getResourceAsStream("/beans.xml");
		InputStream is = practice.class.getResourceAsStream("/beans2.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document document = (Document) db.parse(is);
			NodeList nl = document.getElementsByTagName("bean");
			for (int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				Element e = (Element) node;
				
				System.out.println(e);
				Class c = Class.forName(e.getAttribute("class"));
				
			}

		} catch (ParserConfigurationException e1) {			
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		} catch (SAXException e1) {			
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
		
		
	}
}
