package com.jsp.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.service.response.ReviewResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "review_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Review {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String movieReview;
	private Double rating; // rating dedicated to each review
	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	@JsonIgnore
	private Movie movie; // it will add the foriegn key in a table with <TABLE_NAME>_<ID_NAME>-->movie_movie_id
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updateddate;
	
	public static ReviewResponse toReviewResponse(Review review) {
		return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
		
	}
	
	public static List<ReviewResponse> toReviewResponse(List<Review> reviewList) {
		if(Objects.isNull(reviewList))
			return new ArrayList<>();
		else
			return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
	}
	
	
	
	
	
}
