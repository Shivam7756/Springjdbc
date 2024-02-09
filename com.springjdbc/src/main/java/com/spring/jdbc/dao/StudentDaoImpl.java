package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

	@Override
	public Student getStudent(int studentId) {
		//select single student data
		String query = "select * from student where id = ?";
	    RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		//selecting multiple students
		String query = "Select * from Student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
   
	
}
