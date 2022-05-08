package com.hadiRezaie.kodluyoruz.Controller.movie;

import com.hadiRezaie.kodluyoruz.Controller.actor.ActorCreateRequest;
import com.hadiRezaie.kodluyoruz.NetflixApplicationTests;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorEntity;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorJpaRepository;
import com.hadiRezaie.kodluyoruz.Repository.matching.MatchingEntity;
import com.hadiRezaie.kodluyoruz.Repository.matching.MatchingJpaRepository;
import com.hadiRezaie.kodluyoruz.Repository.movie.MovieEntity;
import com.hadiRezaie.kodluyoruz.Repository.movie.MovieJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;


class MovieControllerTest extends NetflixApplicationTests {

    @Autowired
    MovieJpaRepository movieJpaRepository;

    @Autowired
    ActorJpaRepository actorJpaRepository;

    @Autowired
    MatchingJpaRepository matchingJpaRepository;

    @Test
    void should_create_movie_with_actors_in_db_and_new_actors() {

        //given
        MovieRequest request = new MovieRequest();
        request.setName("movie name");
        request.setMovieGenre(MovieGenre.ACTION);
        request.setDirector("movie director");
        request.setReleaseYear(2010);

        ActorCreateRequest actorCreateRequest1 = new ActorCreateRequest();
        actorCreateRequest1.setBirthDate(LocalDateTime.of(2000,1,12,14,30,0));
        actorCreateRequest1.setName("actor name1");

        ActorCreateRequest actorCreateRequest2 = new ActorCreateRequest();
        actorCreateRequest1.setBirthDate(LocalDateTime.of(2001,1,12,14,30,0));
        actorCreateRequest1.setName("actor name2");

        List<ActorCreateRequest> actorList = new ArrayList<>();
        actorList.add(actorCreateRequest1);
        actorList.add(actorCreateRequest2);

        List<Integer> actorIds = new ArrayList<>();

        request.setActors(actorList);
        request.setActorIds(actorIds);


        //when
        ResponseEntity<MovieCreateResponse> response = testRestTemplate.postForEntity("/movies",request,MovieCreateResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isNotNull();

        //validate movie
        Optional<MovieEntity> movie = movieJpaRepository.findById(response.getBody().getId());
        assertThat(movie).isPresent();
        assertThat(movie.get()).isEqualTo("movie name");


        //validate actor
        List<ActorEntity> actors = actorJpaRepository.findAll();
        assertThat(actors).hasSize(2)
                .extracting("name","birthDate")
                .containsExactlyInAnyOrder(
                        tuple("actor name1", LocalDateTime.of(2000,1,12,14,30,0)),
                        tuple("actor name2",LocalDateTime.of(2001,1,12,14,30,0))
                );

        //validate matching
        List<MatchingEntity> matchings = matchingJpaRepository.findAll();
        assertThat(matchings).hasSize(2);
    }
}