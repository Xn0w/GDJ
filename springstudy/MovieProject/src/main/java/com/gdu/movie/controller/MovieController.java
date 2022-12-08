package com.gdu.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.domain.QueryDTO;
import com.gdu.movie.service.MovieService;
import com.gdu.movie.util.SecurityUtil;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private SecurityUtil securityUtil;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@ResponseBody
	@GetMapping(value="/searchAllMovies", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchAllMovies() {
		List<MovieDTO> list = movieService.getAllMovies();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (list.size() == 0) {
			resultMap.put("status", 500);
			resultMap.put("message", "목록이 없습니다.");
			resultMap.put("list", null);
		} else {
			resultMap.put("status", 200);
			resultMap.put("message", "전체 " + list.size() + "개의 목록을 가져왔습니다.");
			resultMap.put("list", list);
		}
		return resultMap;
	}

	@ResponseBody
	@GetMapping(value="/searchMovie", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchMovie(QueryDTO query) {
		query.setSearchText(securityUtil.preventXSS(query.getSearchText()));
		List<MovieDTO> list = movieService.getMoviesByQuery(query);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (list.size() == 0) {
			resultMap.put("status", 500);
			resultMap.put("message", query.getSearchText() + " 검색 결과가 없습니다.");
			resultMap.put("list", null);
		} else {
			resultMap.put("status", 200);
			resultMap.put("message", list.size() + "개의 검색 결과가 있습니다.");
			resultMap.put("list", list);
		}
		return resultMap;
	}

}
