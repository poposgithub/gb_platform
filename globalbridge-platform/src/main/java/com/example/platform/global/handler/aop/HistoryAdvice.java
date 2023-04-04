package com.example.platform.global.handler.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.platform.global.common.history.History;
import com.example.platform.global.common.history.HistoryService;
import com.example.platform.global.config.security.auth.PrincipalDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Aspect // maven dependency 추가 후에 사용가능함
public class HistoryAdvice {
	private final HistoryService historyService;
	private static final Logger logger = LoggerFactory.getLogger(HistoryAdvice.class);
	// @Before
	// @After
	// @Around

	// pointcut 에 선언해놓은 경로 아래의 모든 서비스 로직들 에서 saveLog가 실행된다.
	@Pointcut("execution(* com.example.platform.domain.*.*Controller.*(..))")
	private static void advicePoint() {
	}

	@Pointcut("execution(* com.example.platform.global.config.security.auth.*.*(..))")
	private static void loginPoint() {
	}

//	@Around("advicePoint()")
//	public Object saveHistory(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		System.out.println("saveHistory AOP 동작?");
//		Object result = null;
//		try {
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
//			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
//					.getRequest();
//			int userId = principalDetails.getUser().getId();
//			String username = principalDetails.getUser().getUsername();
//			String apiUri = request.getRequestURI();
//			String method = request.getMethod();
//			String ip = getClientIp(request);
//
//			History history = new History();
//			history.setApiUri(apiUri);
//			history.setMethod(method);
//			history.setUserId(userId);
//			history.setUsername(username);
//			historyService.saveHistory(history);
//
//			result = proceedingJoinPoint.proceed();
//		} catch (Throwable e) {
//			throw e;
//		}
//		return result;
//	}

	// 로그인이나 회원가입
//	@After("loginPoint()")
//	public void saveLoginHistory(@AuthenticationPrincipal PrincipalDetails principalDetails) throws Throwable {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
//		System.out.println("saveLoginHistory AOP 동작?");
//		
//		System.out.println("auth " + auth);
//		
//		System.out.println("principalDetails " + principalDetails);
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
//				.getRequest();
//		int userId = principalDetails.getUser().getId();
//		String username = principalDetails.getUser().getUsername();
//		String apiUri = request.getRequestURI();
//		String method = request.getMethod();
//		String ip = getClientIp(request);
//
//		History history = new History();
//		history.setApiUri(apiUri);
//		history.setMethod(method);
//		history.setUserId(userId);
//		history.setUsername(username);
//		historyService.saveHistory(history);
//
//	}

	public static String getClientIp(HttpServletRequest req) {
		String ip = req.getHeader("X-Forwarded-For");
		if (ip == null) {
			System.out.println("ip : " + ip);
			ip = req.getRemoteAddr();
		}
		return ip;

	}

}
