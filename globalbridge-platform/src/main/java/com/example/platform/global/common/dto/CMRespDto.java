package com.example.platform.global.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 공통 응답  DTO
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMRespDto<T> {
	
	private int code; // 성공, 실패 (우리가 정함 )
	private String message; // ex) 회원가입 성공 
	private T data;  // data 의 타입을 지금 결정할 수 없으므로 제네릭으로 받음 

}
