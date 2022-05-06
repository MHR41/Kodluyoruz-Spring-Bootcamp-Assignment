package com.hadiRezaie.kodluyoruz.Service.movie;

import com.hadiRezaie.kodluyoruz.Repository.actor.ActorEntity;
import com.hadiRezaie.kodluyoruz.Repository.matching.MatchingEntity;
import com.hadiRezaie.kodluyoruz.Repository.movie.MovieEntity;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorDao;
import com.hadiRezaie.kodluyoruz.Repository.matching.MatchingDao;
import com.hadiRezaie.kodluyoruz.Repository.movie.MovieDao;
import com.hadiRezaie.kodluyoruz.Service.actor.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieDao movieDao;
    private final ActorDao actorDao;
    private final MatchingDao matchingDao;

    @Override
    public int create(Movie movie, List<Actor> actors, List<Integer> actorIds) {

        List<ActorEntity> existingActors = retrieveExistingActors(actorIds);
        List<ActorEntity> createdActors = createActors(actors);
        MovieEntity movieEntity = movieDao.save(movie.convertToMovieEntity());

        ArrayList<ActorEntity> actorEntities = new ArrayList<>();
        actorEntities.addAll(existingActors);
        actorEntities.addAll(createdActors);

        List<MatchingEntity> matchingEntities = actorEntities.stream()
                .map(actorEntity -> {
                    MatchingEntity matchingEntity = new MatchingEntity();
                    matchingEntity.setMovieEntity(movieEntity);
                    matchingEntity.setActorEntity(actorEntity);
                    return matchingEntity;
                }).collect(Collectors.toList());
        matchingDao.create(matchingEntities);

        return movieEntity.getId();
    }

    @Override
    public Movie retrieve(int id) {
        MovieEntity movieEntity = movieDao.retrieve(id);
        return Movie.convertFrom(movieEntity);
    }

    private List<ActorEntity> retrieveExistingActors(List<Integer> actorIds) {

        if(!CollectionUtils.isEmpty(actorIds)) {
            //check if the actor's Id list available in the DB or  not. If not then throw an exception
            List<ActorEntity> retrievedActors = actorDao.retrieve(actorIds);

            if(retrievedActors.size() < actorIds.size()){
                throw new RuntimeException("The given actor ides were not found in database.");
            }
            return retrievedActors;
        }
        return new ArrayList<>();
    }

    private List<ActorEntity> createActors(List<Actor> actors) {
        if(!CollectionUtils.isEmpty(actors)){
            List<ActorEntity> actorEntities = actors.stream()
                    .map(Actor::convertToActorEntity)
                    .collect(Collectors.toList());
            return actorDao.create(actorEntities);
        }
        return new ArrayList<>();
    }

}
