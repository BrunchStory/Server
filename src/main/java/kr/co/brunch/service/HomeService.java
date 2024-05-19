package kr.co.brunch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.brunch.domain.DayOfWeek;
import kr.co.brunch.domain.Keyword;
import kr.co.brunch.domain.Magazine;
import kr.co.brunch.repository.KeywordRepository;
import kr.co.brunch.repository.MagazineRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService {

	private final MagazineRepository magazineRepository;
	private final KeywordRepository keywordRepository;

	public List<Magazine> findByDayOf(DayOfWeek dayOfWeek) {
		return magazineRepository.findByDayOf(dayOfWeek);
	}

	public List<Keyword> findAllKeyword() {
		return keywordRepository.findAll();
	}
}
