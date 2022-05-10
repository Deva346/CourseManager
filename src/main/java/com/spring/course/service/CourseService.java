package com.spring.course.service;

import java.util.List;
import java.util.Optional;

import com.spring.course.entities.Course;

public interface CourseService 
{
	public List<Course> getAllCourses();
	
	public Optional<Course> getCourse(int id);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(int id);
	
}
