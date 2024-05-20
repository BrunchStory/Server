package kr.co.brunch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.brunch.domain.Article;
import kr.co.brunch.domain.DayOfWeek;
import kr.co.brunch.domain.Keyword;
import kr.co.brunch.domain.Magazine;
import kr.co.brunch.dto.ArticleDto;
import kr.co.brunch.dto.EditorPicksDto;
import kr.co.brunch.dto.FirstItemDto;
import kr.co.brunch.dto.MagazineDto;
import kr.co.brunch.dto.ResponseDto;
import kr.co.brunch.dto.SerialResponseDto;
import kr.co.brunch.dto.TopKeywordDto;
import kr.co.brunch.dto.WeekContent;
import kr.co.brunch.dto.WeekListDto;
import kr.co.brunch.service.ArticleService;
import kr.co.brunch.service.KeywordService;
import kr.co.brunch.service.MagazineService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {

	private final MagazineService magazineService;
	private final ArticleService articleService;
	private final KeywordService keywordService;

	@GetMapping("/posts/week")
	public ResponseDto users() {
		List<Magazine> mondayList = magazineService.findByDayOf(DayOfWeek.MONDAY);
		List<Magazine> tuesdayList = magazineService.findByDayOf(DayOfWeek.TUESDAY);
		List<Magazine> wednesdayList = magazineService.findByDayOf(DayOfWeek.WEDNESDAY);
		List<Magazine> thursdayList = magazineService.findByDayOf(DayOfWeek.THURSDAY);
		List<Magazine> fridayList = magazineService.findByDayOf(DayOfWeek.FRIDAY);
		List<Magazine> saturdayList = magazineService.findByDayOf(DayOfWeek.SATURDAY);
		List<Magazine> sundayList = magazineService.findByDayOf(DayOfWeek.SUNDAY);

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

	@GetMapping("/posts/keywords")
	public ResponseDto keywords() {
		List<Keyword> allKeyword = keywordService.findAllKeyword();
		List<TopKeywordDto> collect = allKeyword.stream()
			.map(k -> new TopKeywordDto(k.getKeywordNo(), k.getKeywordNo(), k.getDescription(), k.isNew()))
			.collect(Collectors.toList());

		return ResponseDto.response(new WeekListDto(collect));
	}

	@GetMapping("/posts/editor-picks")
	public ResponseDto picks(@RequestParam(value = "flag", defaultValue = "0") int flag) {

		List<Magazine> magazineList = magazineService.findAll();
		List<Article> articleList = articleService.findAll();
		List<MagazineDto> magazineDtoList = magazineList.stream()
			.map(m -> new MagazineDto(m.getMagazineTitle(), m.getUser().getUserName(), null, null, null))
			.collect(Collectors.toList());
		List<ArticleDto> articleDtoList = articleList.stream()
			.map(a -> new ArticleDto(a.getArticleTitle(), a.getUser().getUserName(),
				null, null))
			.collect(Collectors.toList());

		FirstItemDto firstItemDto;
		if (flag == 0) {
			Article article = articleList.get(0);
			firstItemDto = new FirstItemDto(
				article.getArticleTitle(),
				article.getArticleContentSummary(),
				article.getUser().getUserName(),
				article.getLikeCount(),
				article.getImageList().get(0).getStoreName(),
				null);
		} else {
			Magazine magazine = magazineList.get(0);
			firstItemDto = new FirstItemDto(
				magazine.getMagazineTitle(),
				null,
				magazine.getUser().getUserName(),
				0,
				null,
				null);
		}
		return ResponseDto.response(new EditorPicksDto(firstItemDto, magazineDtoList, articleDtoList));
	}
}
