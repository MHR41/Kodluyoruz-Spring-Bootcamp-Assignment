package com.hadiRezaie.kodluyoruz.Repository.actor;

import java.util.List;

public interface ActorDao {
    int create(ActorEntity actor);
    List<ActorEntity> create(List<ActorEntity> actors);
    List<ActorEntity> retrieve(List<Integer> actorIds);
}
