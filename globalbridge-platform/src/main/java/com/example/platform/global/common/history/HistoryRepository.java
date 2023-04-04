package com.example.platform.global.common.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


public interface HistoryRepository extends JpaRepository<History, Integer> {
	

}
