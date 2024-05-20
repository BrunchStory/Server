package kr.co.brunch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	@EntityGraph(attributePaths = {"user"})
	List<Article> findAll();
}
