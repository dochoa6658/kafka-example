package com.example.infra.kafka.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.user.Producer;
import com.example.user.User;

@Service
public class UserProducer implements Producer {

	private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
	private static final String TOPIC = "users";

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	@Override
	public void sendMessage(User message) {

		logger.info(String.format("###### -> Producing message -> %s", message));
		this.kafkaTemplate.send(TOPIC, message);
	}
}
