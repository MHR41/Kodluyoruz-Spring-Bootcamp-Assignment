package com.hadiRezaie.kodluyoruz.Repository.movie;

import com.hadiRezaie.kodluyoruz.Repository.rate.RateEntity;
import com.hadiRezaie.kodluyoruz.Controller.movie.MovieGenre;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private MovieGenre movieGenre;

    @Column(nullable = false)
    private String name;

    private int releaseYear;

    @Column(nullable = false)
    private String director;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<RateEntity> rates;
}
