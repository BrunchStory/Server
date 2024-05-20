package kr.co.brunch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.brunch.domain.Article;
import kr.co.brunch.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {

	private final ArticleRepository articleRepository;

	public List<Article> findAll() {
		return articleRepository.findAll();
	}
}
