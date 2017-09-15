package com.sovanm.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.sovanm.websocketdemo.dto.MessageDTO;
import com.sovanm.websocketdemo.entity.Message;
import com.sovanm.websocketdemo.service.MessageService;

@RestController
public class MessageController {

	private MessageService messageService;
	
	@Autowired
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public Message send (MessageDTO message)throws Exception{
		return messageService.saveMessage(message);
	}
}
