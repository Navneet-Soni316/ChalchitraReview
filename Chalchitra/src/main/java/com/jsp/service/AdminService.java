package com.jsp.service;

import org.springframework.stereotype.Service;

import com.jsp.domain.Movie;
import com.jsp.repository.MovieRepository;

@Service
public class AdminService {
	private MovieRepository movieRepository;
	//constructor injection
	public AdminService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}
}
