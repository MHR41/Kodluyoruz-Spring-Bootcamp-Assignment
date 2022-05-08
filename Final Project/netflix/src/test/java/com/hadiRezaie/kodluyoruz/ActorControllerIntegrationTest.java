package com.hadiRezaie.kodluyoruz;

import com.hadiRezaie.kodluyoruz.Controller.actor.ActorCreateRequest;
import com.hadiRezaie.kodluyoruz.Controller.actor.ActorCreateResponse;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorEntity;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActorControllerIntegrationTest extends NetflixApplicationTests{

    @Autowired
    ActorJpaRepository actorJpaRepository;

    @Test
    void should_create_actor(){
        //given
        ActorCreateRequest request = new ActorCreateRequest();
        request.setName("test actor");
        request.setBirthDate(LocalDateTime.of(2000, 1, 12, 23, 30, 0));

        //when
        ResponseEntity<ActorCreateResponse> response = testRestTemplate.postForEntity("/actors", request, ActorCreateResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        Optional<ActorEntity> actorEntity = actorJpaRepository.findById(response.getBody().getId());
        assertThat(actorEntity).isPresent();
        assertThat(actorEntity.get()).extracting("name", "birthDate")
                .containsExactly("test actor", LocalDateTime.of(2000,1,12,23,30, 0));
    }
}
