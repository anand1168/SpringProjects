package com.selleniumexpress.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.selleniumexpress.api.Student;
import com.selleniumexpress.error.StudentNotFoundException;

@Component
public class StudentDaoImpl implements StudentDao {
	
	private List<Student> students=new ArrayList<>();
	
	
	@PostConstruct
	public void setUpStudents() {
		
		Student s1=new Student(1, "Anand", "India");
		Student s2=new Student(2, "Prakash", "India");
		Student s3=new Student(3, "Suchita", "India");
		
		students.add(s1);students.add(s2);students.add(s3);
		
	}
	
	

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return students;
	}

	
	
	
	
	@Override
	public Student getStudentbyID(int id) throws StudentNotFoundException {
		
		Student student = students.stream().filter(st->(st.getId()==id)).findFirst().orElse(null);
		
				
			 if(student == null) {
				  
				  throw new StudentNotFoundException("Student doesn't exists with id " + id);
			  }
		
		
		return student;
	}



	@Override
	public Student getStudentbyName(String studentName) {
		
		Student student = students.stream().filter(st-> st.getName().equalsIgnoreCase(studentName)).findFirst().orElse(null);

		
		return student;
	}



	@Override
	public void saveStudent(Student student) {


		students.add(student);
		
	}



	@Override
	public Student modifyStudent(Student student, int id) throws StudentNotFoundException {

      
		  Student studentbyID = getStudentbyID(id);
		  
		  if(studentbyID == null) {
			  
			  throw new StudentNotFoundException("Student doesn't exists with id " + id);
		  }
		  
		  studentbyID.setName(student.getName());
		  studentbyID.setCountry(student.getCountry());
		  
		  
		return studentbyID;
		
		
	}
	
	
	

}
