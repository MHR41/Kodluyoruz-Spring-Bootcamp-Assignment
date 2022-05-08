package com.hadiRezaie.kodluyoruz.Repository.rate;

import com.hadiRezaie.kodluyoruz.Repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "rate")
@Table(name = "rate")
public class RateEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private int memberId;

    @Column(nullable = false)
    private int point;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;
}
