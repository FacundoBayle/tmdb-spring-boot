package com.despegar.dasboot.model.movie;

import com.despegar.dasboot.model.review.MovieReviews;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Movie {
    private String id;
    private String name;
    private String description;
    private List<String> genres;
    private List<MovieCast> cast;
    private List<MovieCrew> crew;
    private List<MovieReviews> reviews;
    private List<SimilarMovies> similarMovies;

    public Movie(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("genres") List<String> genres,
            @JsonProperty("cast") List<MovieCast> cast,
            @JsonProperty("crew") List<MovieCrew> crew,
            @JsonProperty("reviews") List<MovieReviews> reviews,
            @JsonProperty("similar_movies") List<SimilarMovies> similarMovies) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.cast = cast;
        this.crew = crew;
        this.reviews = reviews;
        this.similarMovies = similarMovies;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getId() {
        return id;
    }

    public List<MovieCrew> getCrew() {
        return crew;
    }

    public List<MovieCast> getCast() {
        return cast;
    }

    public List<SimilarMovies> getSimilarMovies() {
        return similarMovies;
    }

    public List<MovieReviews> getReviews() {
        return reviews;
    }
}