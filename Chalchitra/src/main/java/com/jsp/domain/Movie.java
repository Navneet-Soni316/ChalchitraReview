package com.jsp.domain;

import java.util.List;

import com.jsp.service.response.MovieResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "movie_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Movie {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private Double rating; // it is a single entity which is average rating of all reviews for a movie
	@Enumerated(EnumType.STRING)
	private Genre genre;
	@OneToMany(mappedBy = "movie")
	private List<Review> reviews;
	
	public  MovieResponse toMovieResponse() {
		return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).reviews(Review.toReviewResponse(this.reviews)).build();
	}
}
