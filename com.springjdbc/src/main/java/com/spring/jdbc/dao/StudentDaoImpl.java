package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
     private JdbcTemplate jdbcTemplate;//for using the jdbctemplate methods such as update,delete,insert etc.

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		   String query = "insert into Student(id,name,city) values(?,?,?)";
		   int update = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return update;
	}

	@Override
	public int update(Student student) {
		//updating data
		String query = "update student set name=?,city=? where id=?";
		int update = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return update;
		
	}

	@Override
	public int delete(int studentId) {
		//delete operation
		String query = "Delete from student where id=?";
		int delete = this.jdbcTemplate.update(query,studentId);//fire query
		return delete;
	}

}
