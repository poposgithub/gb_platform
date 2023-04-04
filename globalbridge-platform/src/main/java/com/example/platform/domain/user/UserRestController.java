package com.example.platform.domain.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.platform.global.common.dto.CMRespDto;
import com.example.platform.global.common.dto.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserRestController {
	private final UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {
		List<User> users = userService.사용자들();
		return new ResponseEntity<>(new CMRespDto<>(1,"사용자들 조회 성공",users), HttpStatus.OK);
	}
	
	@PostMapping("/join")
	public ResponseEntity<?> join(@Valid SignupDto signupDto,BindingResult bindingResult) {
		userService.회원가입(signupDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"회원가입 성공",null), HttpStatus.OK);
	}

}
