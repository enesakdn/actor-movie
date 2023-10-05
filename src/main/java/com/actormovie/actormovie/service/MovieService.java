package com.actormovie.actormovie.service;

import com.actormovie.actormovie.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(int id);
    Movie save(Movie movie);
    Movie delete(int id);
}
