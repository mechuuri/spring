package com.sist.spring4;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ClassPathXMLApplicationContext implements ApplicationContext {
	private Map clsMap=new HashMap();

	@Override
	public Object getBean(String key) {
		// TODO Auto-generated method stub
		return clsMap.get(key);
	}
	
	public ClassPathXMLApplicationContext(String path)
	{
		try
		{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser(); // XML 파서기 (등록된 데이터 읽기
			XMLParse xp=new XMLParse();
			sp.parse(new File(path),xp);
			clsMap=xp.getMap();
			
		}catch(Exception ex) {}
	}
	
}
