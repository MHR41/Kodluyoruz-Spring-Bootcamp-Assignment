package com.hadiRezaie.kodluyoruz.Repository.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorDaoImpl implements ActorDao{

    private final ActorJpaRepository actorJpaRepository;

    @Override
    public int create(ActorEntity actor) {
       return actorJpaRepository.save(actor).getId();
    }

    @Override
    public List<ActorEntity> create(List<ActorEntity> actors) {
        List<ActorEntity> actorEntities = actorJpaRepository.saveAll(actors);
        return actorEntities;
    }

    @Override
    public List<ActorEntity> retrieve(List<Integer> actorIds) {
        return actorJpaRepository.findAllByIdIn(actorIds);
    }
}
