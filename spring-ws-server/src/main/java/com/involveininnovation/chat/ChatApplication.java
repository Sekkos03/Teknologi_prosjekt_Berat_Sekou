package com.involveininnovation.chat;
import com.involveininnovation.chat.config.WebSocketConfig;
import com.involveininnovation.chat.controller.ChatController;
import com.involveininnovation.chat.model.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}
}
