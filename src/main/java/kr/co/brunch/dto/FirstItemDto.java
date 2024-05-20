package kr.co.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FirstItemDto {
	private String title;
	private String description;
	private String author;
	private int cheerCount;
	private String image;
	private String link;
}
