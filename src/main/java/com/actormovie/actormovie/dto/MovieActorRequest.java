package com.actormovie.actormovie.dto;


import com.actormovie.actormovie.entity.Actor;
import com.actormovie.actormovie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieActorRequest {
    private Movie movie;
    private Actor actor;
}
