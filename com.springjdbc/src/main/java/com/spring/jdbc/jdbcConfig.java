package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})//scans the particular package , and gets the studentDaoImpl class
//and then creates its object ,dont need to use the bean tag now for creating studentdao object
public class jdbcConfig {

	@Bean("ds")
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
	
	// @Bean("studentDao") , This is not needed as we are using the @ComponentScan() Annotation
	// public StudentDao getStudentDao()
	// {
	// 	StudentDaoImpl studentDao = new StudentDaoImpl();
	// 	studentDao.setJdbcTemplate(getTemplate());
	// 	return studentDao;
	// }
}
