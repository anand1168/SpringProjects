package com.selleniumexpress.dao;

import java.util.List;

import com.selleniumexpress.api.Student;
import com.selleniumexpress.error.StudentNotFoundException;

public interface StudentDao {
	
	
	public List<Student> getAllStudent();
	
	public Student getStudentbyID(int id) throws StudentNotFoundException;

	public Student getStudentbyName(String studentName);

	public void saveStudent(Student student);

	public Student modifyStudent(Student student, int id) throws StudentNotFoundException;

}
