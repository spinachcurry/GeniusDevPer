package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ChannelDTO;
import com.app.mapper.TestChannelMapper;

@RestController
public class ApiTestController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	private TestChannelMapper testChannelMapper;
	
	@GetMapping("/")
	public String home() {
		return "웹소켓 시작 성공!";
	}
	
	@GetMapping("/test")
	public boolean test() {
		String text = "메세지 췤췤";
		simpMessagingTemplate.convertAndSend("/topic/bean", text);
		return true;
	}
	
	@PostMapping("/goChannel")
	public List<ChannelDTO> getChannel() {
		return testChannelMapper.getChannel();
	}
}

