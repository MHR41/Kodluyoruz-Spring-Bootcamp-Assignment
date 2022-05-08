package com.hadiRezaie.kodluyoruz.Controller.movie;

import com.hadiRezaie.kodluyoruz.Service.movie.Movie;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieResponse {

    private String name;
    private int releaseYear;
    private MovieGenre movieGenre;
    private String director;

    public static MovieResponse convertFrom(Movie movie) {
        return MovieResponse.builder()
                .name(movie.getName())
                .movieGenre(movie.getMovieGenre())
                .director(movie.getDirector())
                .releaseYear(movie.getReleaseYear())
                .build();
    }
}
