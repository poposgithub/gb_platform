package com.example.platform.global.handler.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.platform.global.common.history.HistoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Aspect 
public class LogAdvice { // 로그를 더 알아보기 쉽게 찍어보기 
	@Pointcut("execution(* com.example.platform.domain.*.*Controller.*(..))")
	private static void advicePoint() {
	}

}
