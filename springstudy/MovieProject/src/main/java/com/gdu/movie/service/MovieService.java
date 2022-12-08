package com.gdu.movie.service;

import java.util.List;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.domain.QueryDTO;

public interface MovieService {
	public List<MovieDTO> getAllMovies();
	public List<MovieDTO> getMoviesByQuery(QueryDTO query);	
}
