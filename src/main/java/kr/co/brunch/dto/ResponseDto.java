package kr.co.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
	private String desc;
	private int code;
	private String title;
	private T data;

	public static <T> ResponseDto<T> response(T data) {
		return new ResponseDto<>("OK", 200, "", data);
	}
}
