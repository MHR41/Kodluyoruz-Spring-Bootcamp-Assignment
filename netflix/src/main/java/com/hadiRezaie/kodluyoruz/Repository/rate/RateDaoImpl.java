package com.hadiRezaie.kodluyoruz.Repository.rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateDaoImpl implements RateDao{

    private final RateJpaRepository rateJpaRepository;

    @Override
    public void rateToMovie(RateEntity rateEntity) {
        rateJpaRepository.save(rateEntity);
    }
}
