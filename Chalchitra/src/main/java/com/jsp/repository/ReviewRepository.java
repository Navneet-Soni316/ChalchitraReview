package com.jsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	@Query(value = "Select avg(rating) from review_table where movie_id = ?", nativeQuery = true)
	double getReviewAverage(Long id);

}
