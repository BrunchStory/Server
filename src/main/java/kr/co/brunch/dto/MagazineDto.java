package kr.co.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MagazineDto {
	private String title;
	private String author;
	private String releasedDate;
	private String image;
	private String link;
}
