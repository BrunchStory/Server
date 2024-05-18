package kr.co.brunch.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

	@Id
	@GeneratedValue
	@Column(name = "article_no")
	private Long articleNo;

	private String articleTitle;
	private String articleSubTitle;
	private String articleContentSummary;

	private LocalDateTime publishTime;
	private int likeCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_no")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "magazine_no")
	private Magazine magazine;

	@OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Image> imageList = new ArrayList<>();

	public Article(String articleTitle, String articleSubTitle, String articleContentSummary, User user,
		Magazine magazine, List<Image> imageList) {
		this.articleTitle = articleTitle;
		this.articleSubTitle = articleSubTitle;
		this.articleContentSummary = articleContentSummary;
		this.publishTime = LocalDateTime.now();
		this.likeCount = 0;
		this.user = user;
		this.magazine = magazine;
		addImages(imageList);
	}

	private void addImages(List<Image> imageList) {
		for (Image image : imageList) {
			this.imageList.add(image);
			image.initArticle(this);
		}
	}
}
