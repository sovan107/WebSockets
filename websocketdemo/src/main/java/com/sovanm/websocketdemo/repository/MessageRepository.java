package com.sovanm.websocketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sovanm.websocketdemo.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
