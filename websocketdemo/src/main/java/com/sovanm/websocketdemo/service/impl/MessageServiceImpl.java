package com.sovanm.websocketdemo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sovanm.websocketdemo.dto.MessageDTO;
import com.sovanm.websocketdemo.entity.Message;
import com.sovanm.websocketdemo.repository.MessageRepository;
import com.sovanm.websocketdemo.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	private MessageRepository repository;
	
	@Autowired
	public void setRepository(MessageRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Message saveMessage(MessageDTO message) {
		
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		Message domainMessage = new Message(message.getMessage(), message.getFrom(), time);
		
		domainMessage = repository.save(domainMessage);
		
		return domainMessage;
	}

}
