package kr.co.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopKeywordDto {
	private Long no;
	private Long id;
	private String description;
	private boolean isNew;
}
