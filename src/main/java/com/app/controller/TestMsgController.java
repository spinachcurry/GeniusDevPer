package com.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.app.dto.PayloadMessageDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestMsgController {
	
	@Autowired
	private SimpMessagingTemplate simMessagingTemplate;
	
	//"/showmsg/conn" 접속
	@MessageMapping("/conn")
	@SendTo("/topic/bean")
	public Map<String, String> conn(Map<String, String> paraMap) {
		log.info("page: {}", "/conn");
		return paraMap;
	}
	
	//"showmsg/window" >> 접속 되는 부분
	@MessageMapping("/window")
	public void conn1(@Payload PayloadMessageDTO payloadDTO, SimpMessageHeaderAccessor headerAccessor) {
		log.info("pate : {}", "/window");
		String sessionId = headerAccessor.getSessionId();
		log.info("sessionId : {}", sessionId);
	}
	
	@MessageMapping("/set")
	@SendTo("/topic/get")
	public void conn2(String msg) {
		System.out.println("내가 왔노라!\n" + msg);
	}
}
