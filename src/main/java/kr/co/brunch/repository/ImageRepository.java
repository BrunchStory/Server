package kr.co.brunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.brunch.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
