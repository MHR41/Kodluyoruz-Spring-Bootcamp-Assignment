package com.hadiRezaie.kodluyoruz.Repository.movie;

import java.util.List;

public interface MovieDao {

    MovieEntity save(MovieEntity movieEntity);

    MovieEntity retrieve(int id);

    List<MovieEntity> retrieveByActorId(int actorId);
}
