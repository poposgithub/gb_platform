package com.example.platform.global.handler.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.platform.global.common.history.HistoryService;
import com.example.platform.global.handler.error.ex.CustomValidationException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Aspect
public class ValidationAdvice {
	@Pointcut("execution(* com.example.platform.domain.*.*Controller.*(..))")
	private static void advicePoint() {
	}
	
	
	@Around("advicePoint()")
	public Object checkValidation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object[] args = proceedingJoinPoint.getArgs();
		for (Object arg : args) {
			if (arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				if (bindingResult.hasErrors()) {
					Map<String, String> errorMap = new HashMap<>();
					for (FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					throw new CustomValidationException("유효성검사실패", errorMap);
				}
			}
		}
		return proceedingJoinPoint.proceed();

	}

}
