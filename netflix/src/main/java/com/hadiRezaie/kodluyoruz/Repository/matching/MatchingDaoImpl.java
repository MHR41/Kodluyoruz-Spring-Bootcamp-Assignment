package com.hadiRezaie.kodluyoruz.Repository.matching;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingDaoImpl implements MatchingDao{

    private final MatchingJpaRepository matchingJpaRepository;

    @Override
    public void create(List<MatchingEntity> matchingEntityList) {
        matchingJpaRepository.saveAll(matchingEntityList);
    }
}
