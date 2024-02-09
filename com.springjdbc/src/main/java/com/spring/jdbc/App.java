package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("PROGRAM STARTED");
		//SPRING JDBC uses jdbcTemplate
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");  
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		//inserting data operation
//		Student student = new Student();
//		student.setCity("lucknow");
//		student.setId(123);
//		student.setName("lakhan");
//		int insert = studentDao.insert(student);
//		System.out.println(insert + " : no of rows inserted");
		
//		Student student1 = new Student();
//		student1.setId(39);
//		student1.setName("dakota");
//		student1.setCity("canberra");
//		int update = studentDao.update(student1);
//		System.out.println(update + " : no of rows updated");
		
		//update a row operation
//		Student student2 = new Student();
//		student2.setId(33);
//		student2.setName("Steven smith");
//		student2.setCity("perth");
//		int update = studentDao.update(student2);
//		System.out.println(update + " : no of rows updated");
//		
//		int delete = studentDao.delete(39);
//		System.out.println(delete + " : no of rows delete");
//		//insert query
//        String query1 = "insert into Student(id,name,city) values(?,?,?)";
//        
//        //fire query
//        int result = template.update(query1,39,"john","sydney");
//        System.out.println(result + " : no of rows updated");
//		
		Student student1 = new Student();
		student1.setCity("khammam");
		student1.setId(788);
		student1.setName("hariom");
		int insert = studentDao.insert(student1);
		System.out.println(insert + " : no of rows inserted");
		Student student = studentDao.getStudent(33);
		System.out.println(student + "");
		Student student2 = studentDao.getStudent(222);
		System.out.println(student2+"");
		List<Student> students = studentDao.getAllStudents();
		
		for(Student s: students)
		{
			System.out.println(s);
		}
	}

}
