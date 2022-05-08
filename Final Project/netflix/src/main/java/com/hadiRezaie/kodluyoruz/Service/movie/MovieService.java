package com.hadiRezaie.kodluyoruz.Service.movie;

import com.hadiRezaie.kodluyoruz.Service.actor.Actor;

import java.util.List;

public interface MovieService {
    int create(Movie movie, List<Actor> actors, List<Integer> actorIds);
    Movie retrieve(int id);
}
