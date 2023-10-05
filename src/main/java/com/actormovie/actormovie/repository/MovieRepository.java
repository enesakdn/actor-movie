package com.actormovie.actormovie.repository;

import com.actormovie.actormovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  MovieRepository extends JpaRepository<Movie,Integer> {
}
