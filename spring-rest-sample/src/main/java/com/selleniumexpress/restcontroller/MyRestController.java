package com.selleniumexpress.restcontroller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.selleniumexpress.api.Student;
import com.selleniumexpress.dao.StudentDao;
import com.selleniumexpress.error.StudentNotFoundException;

@RestController
public class MyRestController {

	@Autowired
	private StudentDao studentDao;

	@GetMapping(value = "/student", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Student> getStudent() {

		return studentDao.getAllStudent();

	}

	/*
	 * Since both the method getStudentbyID and getStudentbyName having similalr
	 * uri, we will get nested exception java.lang.IllegalStateException: Ambiguous
	 * handler methods mapped for '/spring-rest-sample/student/1': {public
	 * com.selleniumexpress.api.Student
	 * com.selleniumexpress.restcontroller.MyRestController.getStudent(java.lang.
	 * String), public com.selleniumexpress.api.Student
	 * com.selleniumexpress.restcontroller.MyRestController.getStudent(int)}] with
	 * root cause java.lang.IllegalStateException: Ambiguous handler methods mapped
	 * for '/spring-rest-sample/student/1'
	 * 
	 * To resolve this , we can use params attribute to distinguish between two
	 * requests
	 * 
	 */

	@GetMapping(value = "/student/{id}", params = "aaa")
	public Student getStudentByID(@PathVariable("id") int studentID) throws StudentNotFoundException {

		return studentDao.getStudentbyID(studentID);

	}

	@GetMapping(value = "/student/{name}", params = "bbb")
	public Student getStudentByName(@PathVariable("name") String studentName) {

		return studentDao.getStudentbyName(studentName);

	}

	@PostMapping(value="/student",params = "requestParam")
	public Student creatStudent(@RequestParam("id") int studentID, @RequestParam("name") String studentName,
			@RequestParam("country") String country) {

		Student student = new Student(studentID, studentName, country);

		studentDao.saveStudent(student);

		return student;

	}

	// when we are sending request to consume this endpoint , Accept header is
	// associated with produces and
	// Content-Type header is associated with consumes
	// reference for more details
	// https://kritika-gupta.medium.com/accept-header-vs-content-type-header-b84df3d1214a

	@PostMapping(value = "/student", params = "body", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Student creatStudent(@RequestBody Student student) {

		studentDao.saveStudent(student);

		return student;

	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student)
			throws StudentNotFoundException {

		Student modifyStudent = studentDao.modifyStudent(student, id);

		return ResponseEntity.ok().body(modifyStudent);

	}

}
