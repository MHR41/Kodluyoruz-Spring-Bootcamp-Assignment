package com.hadiRezaie.kodluyoruz.Service.actor;

import com.hadiRezaie.kodluyoruz.Service.movie.Movie;

import java.util.List;

public interface ActorService {
    int create(Actor actor);
    List<Movie> retrieveMovies(int actorId);
}
