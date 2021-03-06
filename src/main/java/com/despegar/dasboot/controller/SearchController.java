package com.despegar.dasboot.controller;

import com.despegar.dasboot.model.movie.Movie;
import com.despegar.dasboot.model.movie.MovieInfo;
import com.despegar.dasboot.service.search.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //@Controller + @ResponseBody
public class SearchController {

    private Logger logger = LoggerFactory.getLogger(SearchController.class);

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/search")
    public List<MovieInfo> search(@RequestParam(value = "q") String query, @RequestParam Optional<Integer> page) {
        logger.info("search request received with param: {}", query);
        return this.searchService.searchMovie(query, page.orElse(1));
    }
}
