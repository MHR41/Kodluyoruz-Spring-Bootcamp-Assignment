package com.hadiRezaie.kodluyoruz.Controller.movie;

import com.hadiRezaie.kodluyoruz.Controller.Request.MovieRequest;
import com.hadiRezaie.kodluyoruz.Controller.Response.MovieCreateResponse;
import com.hadiRezaie.kodluyoruz.Controller.Response.MovieResponse;
import com.hadiRezaie.kodluyoruz.Service.actor.Actor;
import com.hadiRezaie.kodluyoruz.Service.movie.Movie;
import com.hadiRezaie.kodluyoruz.Service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("movies")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreateResponse create(@RequestBody @Valid MovieRequest request) {

        Movie movie = request.convertToMovie();
        List<Actor> actors = request.convertToActors();
        int id = movieService.create(movie, actors, request.getActorIds());

        return MovieCreateResponse.convertToMovieCreateResponse(id);
    }

    @GetMapping("/movies/{id}")
    public MovieResponse retrieve(@PathVariable int id){
        Movie movie = movieService.retrieve(id);
        return MovieResponse.convertFrom(movie);
    }
}
