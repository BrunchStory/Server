package kr.co.brunch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.brunch.domain.DayOfWeek;
import kr.co.brunch.domain.Magazine;
import kr.co.brunch.repository.MagazineRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService {

	private final MagazineRepository magazineRepository;

	public List<Magazine> findByDayOf(DayOfWeek dayOfWeek) {
		return magazineRepository.findByDayOf(dayOfWeek);
	}
}
