package com.agung.agungtesting;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.agung.agungtesting.dao")
public class AgungTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgungTestingApplication.class, args);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory (DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource (dataSource);
		sessionFactory.setMapperLocations (
				applicationContext.getResources ("classpath:/mapper/**/*.xml"));
		return sessionFactory.getObject ();
	}
}
