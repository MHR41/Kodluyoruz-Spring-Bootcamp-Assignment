package com.hadiRezaie.kodluyoruz.Controller.movie;

import com.hadiRezaie.kodluyoruz.Controller.actor.ActorCreateRequest;
import com.hadiRezaie.kodluyoruz.Service.actor.Actor;
import com.hadiRezaie.kodluyoruz.Service.movie.Movie;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MovieRequest {

    @NotBlank
    private String name;

    @NotNull
    private int releaseYear;

    @NotNull
    private MovieGenre movieGenre;

    @NotBlank
    private String director;

    private List<ActorCreateRequest> actors;
    private List<Integer> actorIds;

    public Movie convertToMovie(){
        return Movie.builder()
                .director(director)
                .movieGenre(movieGenre)
                .releaseYear(releaseYear)
                .name(name)
                .build();
    }

    public List<Actor> convertToActors() {
        if(CollectionUtils.isEmpty(actors)) {
            return new ArrayList<>();
        }

        return actors.stream()
                .map(ActorCreateRequest::convertToActor)
                .collect(Collectors.toList());
    }
}
