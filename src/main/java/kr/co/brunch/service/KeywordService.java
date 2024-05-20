package kr.co.brunch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.brunch.domain.Keyword;
import kr.co.brunch.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KeywordService {

	private final KeywordRepository keywordRepository;

	public List<Keyword> findAllKeyword() {
		return keywordRepository.findAll();
	}
}
