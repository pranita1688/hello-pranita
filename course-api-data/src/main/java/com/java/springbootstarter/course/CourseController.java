package com.java.springbootstarter.course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootstarter.topics.Topics;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("topics/{id}/courses")
	public List<Courses> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
				
	}
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Courses> getCourse(@PathVariable String id)
	{
		
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Courses course,@PathVariable String topicId)
	{
		course.setTopic(new Topics(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}/courses/{courseId}")
	public void updateCourse(@RequestBody Courses course,@PathVariable String topicId,@PathVariable String courseId)
	{
		course.setTopic(new Topics(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}/courses/{courseId}")
	public void deleteCourse(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
	
	
}
