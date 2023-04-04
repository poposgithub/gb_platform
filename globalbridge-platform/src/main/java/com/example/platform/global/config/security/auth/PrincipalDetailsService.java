package com.example.platform.global.config.security.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.platform.domain.user.User;
import com.example.platform.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService");
		System.out.println("여기까지 요청이 들어옵니까?????? " + username);
		// TODO Auto-generated method stub
		User userEntity = userRepository.findByUsername(username);
		System.out.println("userEntity" + userEntity);
		
		if(userEntity == null)  {
			return null;
		} else {
			System.out.println("loadUserByUsername return 하는 부분 ");
			return new PrincipalDetails(userEntity);
		}
		
	}

}
