package com.hadiRezaie.kodluyoruz.Repository.movie;

import com.hadiRezaie.kodluyoruz.Repository.actor.ActorEntity;
import com.hadiRezaie.kodluyoruz.Repository.matching.MatchingEntity;
import com.hadiRezaie.kodluyoruz.Repository.actor.ActorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao{

    private final MovieJpaRepository movieJpaRepository;
    private final ActorJpaRepository actorJpaRepository;

    @Override
    public MovieEntity save(MovieEntity movieEntity) {
        return movieJpaRepository.save(movieEntity);
    }

    @Override
    public MovieEntity retrieve(int id) {
        Optional<MovieEntity> movieEntityOptional = movieJpaRepository.findById(id);
        if(movieEntityOptional.isPresent()){
            return movieEntityOptional.get();
        }
        else
            throw new RuntimeException("Movie id:"+id+" was not found.");
    }

    @Override
    public List<MovieEntity> retrieveByActorId(int actorId) {
        Optional<ActorEntity> actorEntityOptional = actorJpaRepository.findById(actorId);
        if(actorEntityOptional.isPresent()){
            return actorEntityOptional.get()
                    .getMatchings()
                    .stream()
                    .map(MatchingEntity::getMovieEntity)
                    .collect(Collectors.toList());
        }
        else
            throw new RuntimeException("The actor id wan not found.");
    }
}
