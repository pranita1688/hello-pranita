package com.java.springbootstarter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService  {
	@Autowired
	private TopicRepository topicRepository;

	public List<Topics> getAllTopics() {
		List<Topics> topicList = new ArrayList<>();

		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}

	public Optional<Topics> getTopic(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void addTopics(Topics topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topics topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);

	}

}
