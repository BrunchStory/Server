package kr.co.brunch.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Keyword {

	@Id
	@GeneratedValue
	private Long keywordNo;

	private String description;
	private boolean isNew;
}
