package kr.co.brunch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.brunch.domain.DayOfWeek;
import kr.co.brunch.domain.Magazine;
import kr.co.brunch.dto.ResponseDto;
import kr.co.brunch.dto.SerialResponseDto;
import kr.co.brunch.dto.WeekContent;
import kr.co.brunch.dto.WeekListDto;
import kr.co.brunch.service.HomeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {

	private final HomeService homeService;

	@GetMapping("/posts/week")
	public ResponseDto users() {
		List<Magazine> mondayList = homeService.findByDayOf(DayOfWeek.MONDAY);
		List<Magazine> tuesdayList = homeService.findByDayOf(DayOfWeek.TUESDAY);
		List<Magazine> wednesdayList = homeService.findByDayOf(DayOfWeek.WEDNESDAY);
		List<Magazine> thursdayList = homeService.findByDayOf(DayOfWeek.THURSDAY);
		List<Magazine> fridayList = homeService.findByDayOf(DayOfWeek.FRIDAY);
		List<Magazine> saturdayList = homeService.findByDayOf(DayOfWeek.SATURDAY);
		List<Magazine> sundayList = homeService.findByDayOf(DayOfWeek.SUNDAY);

		List<SerialResponseDto> mondaySerialUpdateMagazineResponseList = new ArrayList<>();
		List<SerialResponseDto> tuesdaySerialUpdateMagazineResponseList = new ArrayList<>();
		List<SerialResponseDto> wednesdaySerialUpdateMagazineResponseList = new ArrayList<>();
		List<SerialResponseDto> thursdaySerialUpdateMagazineResponseList = new ArrayList<>();
		List<SerialResponseDto> fridaySerialUpdateMagazineResponseList = new ArrayList<>();
		List<SerialResponseDto> saturdaySerialUpdateMagazineResponseList = new ArrayList<>();
		List<SerialResponseDto> sundaySerialUpdateMagazineResponseList = new ArrayList<>();
		mondayList.forEach(e -> mondaySerialUpdateMagazineResponseList.add(new SerialResponseDto(e)));
		tuesdayList.forEach(e -> tuesdaySerialUpdateMagazineResponseList.add(new SerialResponseDto(e)));
		wednesdayList.forEach(e -> wednesdaySerialUpdateMagazineResponseList.add(new SerialResponseDto(e)));
		thursdayList.forEach(e -> thursdaySerialUpdateMagazineResponseList.add(new SerialResponseDto(e)));
		fridayList.forEach(e -> fridaySerialUpdateMagazineResponseList.add(new SerialResponseDto(e)));
		saturdayList.forEach(e -> saturdaySerialUpdateMagazineResponseList.add(new SerialResponseDto(e)));
		sundayList.forEach(e -> sundaySerialUpdateMagazineResponseList.add(new SerialResponseDto(e)));

		List<WeekContent> weekContentList = new ArrayList<>();
		weekContentList.add(
			new WeekContent(DayOfWeek.MONDAY.toString(), mondaySerialUpdateMagazineResponseList, null, null));
		weekContentList.add(
			new WeekContent(DayOfWeek.TUESDAY.toString(), tuesdaySerialUpdateMagazineResponseList, null, null));
		weekContentList.add(
			new WeekContent(DayOfWeek.WEDNESDAY.toString(), wednesdaySerialUpdateMagazineResponseList, null, null));
		weekContentList.add(
			new WeekContent(DayOfWeek.THURSDAY.toString(), thursdaySerialUpdateMagazineResponseList, null, null));
		weekContentList.add(
			new WeekContent(DayOfWeek.FRIDAY.toString(), fridaySerialUpdateMagazineResponseList, null, null));
		weekContentList.add(
			new WeekContent(DayOfWeek.SATURDAY.toString(), saturdaySerialUpdateMagazineResponseList, null, null));
		weekContentList.add(
			new WeekContent(DayOfWeek.SUNDAY.toString(), sundaySerialUpdateMagazineResponseList, null, null));

		return ResponseDto.response(new WeekListDto(weekContentList));
	}
}
