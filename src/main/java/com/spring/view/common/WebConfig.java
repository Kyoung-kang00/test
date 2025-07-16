package com.spring.view.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.spring.biz.common.BoardDTO;

@ComponentScan
@Configuration
public class WebConfig {

	@Bean
	public BoardDTO boardDTO() {		// 메서드 이름: 빈의 이름, return이 객체
		
		return new BoardDTO();
		
	}
	
}
