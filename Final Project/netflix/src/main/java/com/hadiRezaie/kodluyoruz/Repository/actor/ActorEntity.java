package com.hadiRezaie.kodluyoruz.Repository.actor;

import com.hadiRezaie.kodluyoruz.Repository.matching.MatchingEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity(name = "actor")
@Table(name = "actor")
public class ActorEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @OneToMany(mappedBy = "actorEntity")
    private List<MatchingEntity> matchings;

}
