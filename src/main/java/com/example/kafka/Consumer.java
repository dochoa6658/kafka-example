package com.example.kafka;

import com.example.user.User;

public interface Consumer {

	public void consume(User message);
}
