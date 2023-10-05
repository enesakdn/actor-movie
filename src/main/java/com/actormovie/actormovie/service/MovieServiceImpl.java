package com.actormovie.actormovie.service;

import com.actormovie.actormovie.entity.Actor;
import com.actormovie.actormovie.entity.Movie;
import com.actormovie.actormovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> movie =  movieRepository.findById(id);
        if(movie.isPresent()){
            return movie.get();
        }
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie delete(int id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
        return movie;
    }
}
