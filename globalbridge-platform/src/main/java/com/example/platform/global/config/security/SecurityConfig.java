package com.example.platform.global.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.platform.global.handler.aop.NoLogging;

@EnableWebSecurity
@Configuration

public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfig");
		http.csrf().disable();
		http.authorizeHttpRequests()
		.antMatchers("/api/**").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/auth/signin") // FrontEnd  router 주소 부분 (협업)
		.loginProcessingUrl("/auth/signin")
		.defaultSuccessUrl("/api/users");
		return http.build();
	}
}
