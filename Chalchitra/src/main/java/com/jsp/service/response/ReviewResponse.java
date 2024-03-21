package com.jsp.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // this will create the object for this
public class ReviewResponse {
	private String review;
	private double rating;
	
}
