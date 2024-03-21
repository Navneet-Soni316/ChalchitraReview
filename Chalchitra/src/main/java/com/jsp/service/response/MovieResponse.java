package com.jsp.service.response;

import java.util.List;

import com.jsp.domain.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {
	private String title;
	private Genre genre;
	private double rating;
	private List<ReviewResponse> reviews;
	
}
