package com.gdu.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.domain.QueryDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public List<MovieDTO> getAllMovies() {
		return movieMapper.selectAllMovies();
	}
	
	@Override
	public List<MovieDTO> getMoviesByQuery(QueryDTO query) {
		return movieMapper.selectMoviesByQuery(query);
	}
	
}
