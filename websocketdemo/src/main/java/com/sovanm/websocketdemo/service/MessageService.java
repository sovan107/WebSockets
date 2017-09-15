package com.sovanm.websocketdemo.service;

import com.sovanm.websocketdemo.dto.MessageDTO;
import com.sovanm.websocketdemo.entity.Message;

public interface MessageService {

	Message saveMessage(MessageDTO domainMessage);

}
