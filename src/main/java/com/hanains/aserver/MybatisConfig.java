package com.hanains.aserver;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class MybatisConfig {
	
	@Autowired
	private MyBatisProperties prop;
	
	@Bean
	public DataSource dataSource() throws Exception{
		
		OracleDataSource dataSource = new OracleDataSource();
		
		dataSource.setURL(prop.getUrl());
		dataSource.setUser(prop.getUsername());
		dataSource.setPassword(prop.getPassword());
		
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryForMyBatis(DataSource dataSource) {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(prop.getConfigLocation());
		
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
		SqlSession sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSession;
	}
	
}
