package com.spring.course.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.course.dao.CourseDao;
import com.spring.course.entities.Course;
import com.spring.course.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getAllCourses() {
		return courseDao.findAll();
	}

	@Override
	public Optional<Course> getCourse(int id) 
	{
		return courseDao.findById(id);
	}
	
	@Override
	public Course addCourse(Course course) 
	{
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(int id) 
	{
		courseDao.deleteById(id);
	}
}
