package com.jsp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.jsp.domain.Genre;
import com.jsp.domain.Movie;
import com.jsp.repository.MovieRepository;
import com.jsp.service.response.MovieResponse;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	public MovieResponse findMovie(String title) {
		Movie movie = movieRepository.findByTitle(title);
		if(Objects.nonNull(movie))
			return movie.toMovieResponse();
		return null;
	}
	
	public List<MovieResponse> findMoviesByGenre(String genre) {
		if(Arrays.stream(Genre.values()).noneMatch(g->g.toString().equals(genre))) // checking whether the genre is valid or not
			return new ArrayList<>(); 
		List<Movie> movieList = movieRepository.findByGenre(Genre.valueOf(genre));
		// stream will sort the movie for us in descending order of reviews
		if(!CollectionUtils.isEmpty(movieList)) {
		List <MovieResponse> movieResponseList = movieList.stream().sorted(Comparator.comparing(Movie::getRating,Comparator.reverseOrder())).map(m -> m.toMovieResponse()).collect(Collectors.toList());
		if(movieResponseList.size()>5) { // if no. of movies > 5 then trim to have 4
			return movieResponseList.subList(0, 4);
		}
		return movieResponseList;
		}
		return new ArrayList<>();
	}

}
