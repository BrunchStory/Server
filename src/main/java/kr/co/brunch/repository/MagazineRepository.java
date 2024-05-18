package kr.co.brunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {
}
