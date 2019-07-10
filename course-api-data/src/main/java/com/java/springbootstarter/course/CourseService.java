package com.java.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService  {
	@Autowired
	private CourseRepository courseRepository;

	public List<Courses> getAllCourses(String topicId) {
		List<Courses> courseList = new ArrayList<>();

		courseRepository.findByTopicId(topicId).forEach(courseList::add);
		return courseList;
	}

	public Optional<Courses> getCourse(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Courses course) {
		courseRepository.save(course);
	}

	public void updateCourse( Courses course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);

	}

}
