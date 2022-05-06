package com.hadiRezaie.kodluyoruz.Controller.Request;

import com.hadiRezaie.kodluyoruz.Service.actor.Actor;
import lombok.Getter;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class ActorCreateRequest {

    @NotNull
    private String name;

    @NotNull
    private LocalDateTime birthDate;

    public Actor convertToActor() {
        return Actor.builder()
                .birthDate(birthDate)
                .name(name)
                .build();
    }
}
