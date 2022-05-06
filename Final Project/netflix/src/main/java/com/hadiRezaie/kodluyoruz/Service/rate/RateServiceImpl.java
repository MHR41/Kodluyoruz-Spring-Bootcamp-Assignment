package com.hadiRezaie.kodluyoruz.Service.rate;

import com.hadiRezaie.kodluyoruz.Repository.movie.MovieEntity;
import com.hadiRezaie.kodluyoruz.Repository.rate.RateEntity;
import com.hadiRezaie.kodluyoruz.Repository.movie.MovieDao;
import com.hadiRezaie.kodluyoruz.Repository.rate.RateDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService{

    private final RateDao rateDao;
    private final MovieDao movieDao;

    @Override
    public void rateToMovie(Rate rate) {
        MovieEntity movieEntity = movieDao.retrieve(rate.getMovieId());
        RateEntity rateEntity = rate.convertToRateEntity(movieEntity);
        rateDao.rateToMovie(rateEntity);
    }

    @Override
    public List<Rate> retrieveByMovieId(int movieId) {
        MovieEntity movieEntity = movieDao.retrieve(movieId);
        return  movieEntity.getRates()
                .stream()
                .map(Rate::convertFromRateEntity)
                .collect(Collectors.toList());
    }
}
