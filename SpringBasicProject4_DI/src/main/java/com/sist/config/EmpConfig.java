package com.sist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sist.dao.EmpDAO;

/*
 
 */
@Configuration
public class EmpConfig {
	@Bean("dao")
	public EmpDAO empDao()
	{
		EmpDAO dao=new EmpDAO("oracle.jdbc.driver.OracleDriver");
		dao.setUrl("jdbc:oracle:thin:@localhost:1521:XM");
		dao.setUser("hr");
		dao.setPwd("happy");
		return dao;
	}
}
