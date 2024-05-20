package kr.co.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
	private String title;
	private String author;
	private String image;
	private String link;
}
