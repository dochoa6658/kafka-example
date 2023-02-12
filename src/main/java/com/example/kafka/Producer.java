package com.example.kafka;

import com.example.user.User;

public interface Producer {

	public void sendMessage(User message);
}
