package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
@Component("ds")
// 사용자 정의는 어노테이션, 라이브러리는 XML
public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(10);
		setMaxIdle(10);
		setMaxWait(-1);
	}
}
