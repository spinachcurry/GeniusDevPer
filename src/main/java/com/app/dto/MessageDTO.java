package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

	private String topic; //올라오는 주소
	private String message; // 읽는 값의 주소
	private String time; // 자바에서 시스템 데이터로 넣어주는 것
	
}
