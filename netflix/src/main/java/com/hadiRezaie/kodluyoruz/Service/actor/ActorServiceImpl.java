package com.hadiRezaie.kodluyoruz.Service.actor;

import com.hadiRezaie.kodluyoruz.Repository.actor.ActorDao;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorEntity;
import com.hadiRezaie.kodluyoruz.Repository.movie.MovieDao;
import com.hadiRezaie.kodluyoruz.Service.movie.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService{

    private final ActorDao actorDao;
    private final MovieDao movieDao;

    @Override
    public int create(Actor actor) {

        ActorEntity actorEntity = actor.convertToActorEntity();
        return actorDao.create(actorEntity);
    }

    @Override
    public List<Movie> retrieveMovies(int actorId) {
        return movieDao.retrieveByActorId(actorId)
                .stream()
                .map(Movie::convertFrom)
                .collect(Collectors.toList());
    }
}
