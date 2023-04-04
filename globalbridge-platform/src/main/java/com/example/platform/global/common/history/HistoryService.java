package com.example.platform.global.common.history;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HistoryService {
	private final HistoryRepository historyRepository;
	

	@Transactional
	public void saveHistory(History history) {
		historyRepository.save(history);
	}
}
