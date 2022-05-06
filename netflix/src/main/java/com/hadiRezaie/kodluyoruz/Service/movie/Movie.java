package com.hadiRezaie.kodluyoruz.Service.movie;

import com.hadiRezaie.kodluyoruz.Repository.movie.MovieEntity;
import com.hadiRezaie.kodluyoruz.MovieGenre;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Movie {

    private String name;
    private MovieGenre movieGenre;
    private int releaseYear;
    private String director;

    MovieEntity convertToMovieEntity(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setDirector(getDirector());
        movieEntity.setName(getName());
        movieEntity.setMovieGenre(getMovieGenre());
        movieEntity.setReleaseYear(getReleaseYear());
        return movieEntity;
    }

    public static Movie convertFrom(MovieEntity movieEntity){
        return Movie.builder()
                .name(movieEntity.getName())
                .movieGenre(movieEntity.getMovieGenre())
                .releaseYear(movieEntity.getReleaseYear())
                .director(movieEntity.getDirector())
                .build();
    }
}
