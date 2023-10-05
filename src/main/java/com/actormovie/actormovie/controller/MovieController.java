package com.actormovie.actormovie.controller;

import com.actormovie.actormovie.dto.ActorResponse;
import com.actormovie.actormovie.dto.MovieActorRequest;
import com.actormovie.actormovie.dto.MovieActorResponse;
import com.actormovie.actormovie.dto.MovieResponse;
import com.actormovie.actormovie.entity.Actor;
import com.actormovie.actormovie.entity.Movie;
import com.actormovie.actormovie.service.MovieService;
import com.actormovie.actormovie.util.HollywoodUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll() {
        List<MovieResponse> movieResponses = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for (Movie movie : movies) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return movieResponses;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        return new MovieResponse(foundMovie.getId(), foundMovie.getName(), foundMovie.getDirectorName(),
                foundMovie.getRating(), foundMovie.getReleaseDate());

    }

    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest) {
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return HollywoodUtility.convertMovieActorResponse(savedMovie, actor);
    }

    @PostMapping("/addActor/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId) {
        Movie movie = movieService.findById(movieId);
        movie.addAllActor(actors);
        Movie savedMovie = movieService.save(movie);
        return HollywoodUtility.convertActorResponses(savedMovie);
    }


    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie, @PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        movie.setId(id);
        movie.setActors(foundMovie.getActors());
        Movie updatedMovie = movieService.save(movie);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id) {
        Movie movie = movieService.delete(id);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

}
