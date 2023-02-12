package com.example.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.Producer;

@Service
public class UserProducer implements Producer {

	private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
	private static final String TOPIC = "users";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String message) {

		logger.info(String.format("###### -> Producing message -> %s", message));
		this.kafkaTemplate.send(TOPIC, message);
	}
}
