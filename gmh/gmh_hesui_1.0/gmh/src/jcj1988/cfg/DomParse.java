package jcj1988.cfg;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * xml�ĵ�����׼����
 * @author jcj1988
 *
 */
public class DomParse {
	DocumentBuilderFactory dbf = null;
	DocumentBuilder db = null;
	Document document = null;
	NodeList boot = null;

	/**
	 * ���캯��
	 * @param fileName xml�ļ���
	 */
	DomParse(String fileName) {
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			document = db.parse(fileName);
			// DOMConfiguration docConfig = document.getDomConfig();
			// docConfig.setParameter("element-content-whitespace", false);
			// document.normalizeDocument();
			boot = document.getChildNodes();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����ĵ����ڵ�
	 * @return ���ڵ������
	 */
	public NodeList getBoot() {
		return boot;
	}

	/**
	 * ����ĵ�����
	 * @return �ĵ����������
	 */
	public Document getDocument() {
		return document;
	}

}
