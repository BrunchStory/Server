package kr.co.brunch.domain;

import java.util.Arrays;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Image {

	@Id
	@GeneratedValue
	private Long imageNo;

	private String originName;
	private String storeName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_no")
	private Article article;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	private final static String[] supportedExtension = {"jpg", "jpeg", "gif", "bmp", "png"};

	public Image(String originName) {
		this.originName = originName;
		this.storeName = generateUniqueName(extractExtension(originName));
	}

	private String extractExtension(String originName) {
		int idx = originName.lastIndexOf('.');
		String extension = originName.substring(idx + 1);
		if (isSupportedExtension(extension)) {
			return extension;
		}
		return null;
	}

	private static boolean isSupportedExtension(String extension) {
		return Arrays.stream(supportedExtension).anyMatch(e -> e.equalsIgnoreCase(extension));
	}

	private String generateUniqueName(String extension) {
		return UUID.randomUUID().toString() + "." + extension;
	}

	public void initArticle(Article article) {
		if (this.article == null) {
			this.article = article;
		}
	}
}
