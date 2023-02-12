package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.UserProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	private final UserProducer producer;
	
	@Autowired
	public KafkaController(UserProducer producer) {

		this.producer = producer;
	}
	
	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message){
		this.producer.sendMessage(message);
	}
}
