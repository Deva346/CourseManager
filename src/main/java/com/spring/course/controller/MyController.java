package com.spring.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.course.entities.Course;
import com.spring.course.service.impl.CourseServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController 
{
	@Autowired
	private CourseServiceImpl courseService;

	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}

	// get Courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return this.courseService.getAllCourses();
	}
	
	//get course by id
	@GetMapping("/courses/{id}")
	public Optional<Course> getCourse(@PathVariable int id)
	{
		return this.courseService.getCourse(id);
	}

	// add course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}

	// Update Course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}

	// Delete Course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
