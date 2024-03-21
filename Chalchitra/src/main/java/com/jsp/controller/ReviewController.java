package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.domain.Review;
import com.jsp.service.ReviewService;
import com.jsp.service.request.ReviewRequest;
import com.jsp.service.response.ReviewResponse;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/add")
	public void addReview(@RequestBody ReviewRequest reviewRequest) {
		reviewService.addReview(reviewRequest.toReview());
		
	}
	
	@GetMapping("/find")
	public ReviewResponse getReview(@RequestParam Long reviewId) {
		return reviewService.getReviewById(reviewId);
	}
}
