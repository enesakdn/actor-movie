package com.actormovie.actormovie.repository;

import com.actormovie.actormovie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
