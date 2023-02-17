package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.infra.kafka.user.UserProducer;
import com.example.user.User;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	private final UserProducer producer;
	
	public KafkaController(UserProducer producer) {

		this.producer = producer;
	}
	
	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestBody User message){
		this.producer.sendMessage(message);
	}
}
