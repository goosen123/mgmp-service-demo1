package com.goosen.commons.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * xml处理工具类
 * 2018-04-24 11:38:01
 * @author Goosen
 *
 */
public class XmlUtil {
	/**
	 * xml字符串转换成map
	 * @param xml
	 * @return
	 */
	public static Map<String, String> xmlToMap(String xml) throws ParserConfigurationException, SAXException, IOException{
		if(null == xml || xml.trim().length() == 0)
			return new HashMap<String, String>();
		Map<String, String> item = getMapFromXML(xml);
		return item;
	}

    private static Map<String,String> getMapFromXML(String xmlString) throws ParserConfigurationException, SAXException, IOException {
        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is =  getStringStream(xmlString);
        Document document = builder.parse(is);
        //获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, String> map = new HashMap<String, String>();
        int i=0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if(node instanceof Element){
                map.put(node.getNodeName(),node.getTextContent());
            }
            i++;
        }
        return map;
    }
    
    private static InputStream getStringStream(String sInputString) {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
        }
        return tInputStringStream;
    }
    
    /**
     * 将map中的key跟value转换为xml格式的字符串返回
     * @param params
     * @return
     */
	public static String mapToXMLStr(Map params){
		Set keySet = params.keySet();
		Iterator it = keySet.iterator();
		String str = "";
		while(it.hasNext()){
			String key = (String) it.next();
			String value = CommonUtil.getStrValue(params, key);
			if(CommonUtil.isTrimNull(value)){
				value = "";
			}
			str += "<" + key + "><![CDATA[" + value + "]]></" + key + ">\n";
		}
		return "<xml>\n" + str + "</xml>";
	}
}
