package kr.co.brunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
