package com.hadiRezaie.kodluyoruz.Controller.actor;

import com.hadiRezaie.kodluyoruz.Controller.movie.MovieResponse;
import com.hadiRezaie.kodluyoruz.Service.actor.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @PostMapping("/actors")
    public ActorCreateResponse create(@RequestBody @Valid ActorCreateRequest request) {
        int actorId = actorService.create(request.convertToActor());
        return ActorCreateResponse.builder().id(actorId).build();
    }

    @GetMapping("/actors/{actorId}/movies")
    public List<MovieResponse> retrieveMovies(@PathVariable int actorId) {
        return actorService.retrieveMovies(actorId)
                .stream()
                .map(MovieResponse::convertFrom)
                .collect(Collectors.toList());
    }
}
