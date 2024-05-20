package kr.co.brunch.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditorPicksDto {
	private FirstItemDto firstItem;
	private List<MagazineDto> magazineList;
	private List<ArticleDto> articleList;
}
