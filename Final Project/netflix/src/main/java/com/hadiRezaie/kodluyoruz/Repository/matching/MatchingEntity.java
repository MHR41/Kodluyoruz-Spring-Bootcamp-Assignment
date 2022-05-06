package com.hadiRezaie.kodluyoruz.Repository.matching;

import com.hadiRezaie.kodluyoruz.Repository.movie.MovieEntity;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "matching")
@Table(name = "matching")
public class MatchingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private MovieEntity movieEntity;

    @ManyToOne
    private ActorEntity actorEntity;
}