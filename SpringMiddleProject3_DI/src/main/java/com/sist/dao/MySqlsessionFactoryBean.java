package com.sist.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ssf")
//Target(value={TYPE}) 클래스 위에만 올릴 수 있음 
public class MySqlsessionFactoryBean extends SqlSessionFactoryBean {

	@Autowired // 생성자, 메서드, 파라미터 위에 올라갈 수 있음 
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	
	/*
	 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	 	p:dataSource-ref="ds"
			/>
	 */
	
	
}
