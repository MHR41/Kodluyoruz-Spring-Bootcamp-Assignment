package com.hadiRezaie.kodluyoruz.Repository.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ActorJpaRepository extends JpaRepository<ActorEntity, Integer> {
    List<ActorEntity> findAllByIdIn(List<Integer> ids);
}
