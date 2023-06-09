package com.sist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sist.dao.EmpDAO;
import com.sist.myapp.MainClass;

@Configuration
public class EmpConfig {
/*
 * 
 */
	@Bean("dao") // id
	public EmpDAO empDAO()
	{
		EmpDAO dao=new EmpDAO("oracle.jdbc.driver.OracleDriver");
		dao.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dao.setUser("hr");
		dao.setPassword("happy");
		
		return dao;
	}
	
	@Bean("mc") // id <bean id="mc">
	public MainClass mainClass()
	{
		MainClass mc=new MainClass();
		mc.setDao(empDAO());
		return mc;
	}
}
