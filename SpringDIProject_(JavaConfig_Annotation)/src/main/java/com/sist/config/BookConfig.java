package com.sist.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Value;

@Configuration // 스프링 셋팅 파일 (app.xml대신 사용)
// 어노테이션 메모리 할당 요청
@ComponentScan(basePackages = {"com.sist.*"})
// interface 구현
@MapperScan(basePackages = {"com.sist.mapper"})
@PropertySource("classpath:/db.properties")
public class BookConfig {
	@Value("${db.driver}")
	private String driver;
	@value("$")

}
