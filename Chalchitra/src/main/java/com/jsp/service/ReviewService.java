package com.jsp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jsp.domain.Movie;
import com.jsp.domain.Review;
import com.jsp.repository.MovieRepository;
import com.jsp.repository.ReviewRepository;
import com.jsp.service.response.ReviewResponse;
@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private MovieRepository movieRepository;
	public void addReview(Review review) {
		Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
		reviewRepository.save(review);
		// need to be optimized
		//exception handling
		if(movie !=null) {
			Double average = reviewRepository.getReviewAverage(movie.getId());
			movie.setRating(average);
			movieRepository.save(movie);
			
		}
		
	}
	
	public ReviewResponse getReviewById(Long reviewId) {
		Optional<Review> review =  reviewRepository.findById(reviewId);
		return review.map(Review:: toReviewResponse).orElse(null);
		
		
	}
}
