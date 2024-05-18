package kr.co.brunch.dto;

import java.util.Comparator;
import java.util.Set;

import kr.co.brunch.domain.Article;
import kr.co.brunch.domain.Magazine;
import kr.co.brunch.domain.SerialStatus;
import lombok.Getter;

@Getter
public class SerialResponseDto {
	private String userId;
	private String userName;
	private Long magazineNo;
	private String magazineTitle;
	private Long articleNo;
	private String articleTitle;
	private String articleSubTitle;
	private String articleContentSummary;
	private int publishTime;
	private int likeCount;
	private SerialStatus serialStatus;

	public SerialResponseDto(Magazine magazine) {
		userId = magazine.getUser().getUserId();
		userName = magazine.getUser().getUserName();

		magazineNo = magazine.getMagazineNo();
		magazineTitle = magazine.getMagazineTitle();
		serialStatus = magazine.getSerialStatus();

		Set<Article> articleSet = magazine.getArticleSet();
		Article article = articleSet.stream()
			.max(Comparator.comparing(Article::getArticleNo))
			.orElse(null);

		articleNo = article.getArticleNo();
		articleTitle = article.getArticleTitle();
		articleSubTitle = article.getArticleSubTitle();
		articleContentSummary = article.getArticleContentSummary();
		publishTime = article.getPublishTime().getNano();
		likeCount = article.getLikeCount();
	}
}
