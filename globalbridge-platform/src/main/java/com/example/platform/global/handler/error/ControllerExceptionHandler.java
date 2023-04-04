package com.example.platform.global.handler.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.platform.global.common.dto.CMRespDto;
import com.example.platform.global.handler.error.ex.CustomApiException;
import com.example.platform.global.handler.error.ex.CustomValidationException;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler<T> {
	
	// 예시 RuntimeException 이 발동하는 에러를 exampleException 함수가 가로챈다. 
	@ExceptionHandler(RuntimeException.class)
	public String exampleException(RuntimeException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(CustomApiException.class)
	public ResponseEntity<?> apiException(CustomApiException e) {
		return new ResponseEntity<>(new CMRespDto<>(-1,e.getMessage(),null),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomValidationException.class)
	public ResponseEntity<?> validationException(CustomValidationException e){
		return new ResponseEntity<>(new CMRespDto<>(-1,e.getMessage(),null),HttpStatus.BAD_REQUEST);
		
	}


}
