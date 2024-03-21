package com.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.domain.Genre;
import com.jsp.domain.Movie;

@Repository // because of this annotation the method body is not needed and it will be handled by jpa
public interface MovieRepository extends JpaRepository<Movie, Long> { 
	public Movie findByTitle(String title);
	public List<Movie> findByGenre(Genre genre);
	
}
