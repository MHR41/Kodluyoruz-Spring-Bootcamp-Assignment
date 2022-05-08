package com.hadiRezaie.kodluyoruz.Service.actor;

import com.hadiRezaie.kodluyoruz.Repository.actor.ActorEntity;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class Actor {

    private int id;
    private String name;
    private LocalDateTime birthDate;

    public ActorEntity convertToActorEntity() {
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setName(name);
        actorEntity.setBirthDate(birthDate);
        return actorEntity;
    }
}
