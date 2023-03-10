package com.example.infra.kafka.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.user.Consumer;
import com.example.user.User;

@Service
public class UserConsumer implements Consumer {

	private final Logger logger = LoggerFactory.getLogger(UserConsumer.class);

	@Override
	@KafkaListener(topics = "users", groupId = "example_id")
	public void consume(User message) {

		logger.info(String.format("#### -> Consumed message -> %s", message.toString()));
	}
}
