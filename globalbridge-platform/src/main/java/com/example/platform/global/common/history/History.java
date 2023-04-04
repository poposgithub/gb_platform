package com.example.platform.global.common.history;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;	
	private int userId;
	private String apiUri;
	private String method;
	private String ip;
	
	private LocalDateTime createDateTime;

	@PrePersist
	public void createDate() {
		this.createDateTime = LocalDateTime.now();
	}

}
