package com.hadiRezaie.kodluyoruz.Service.rate;

import java.util.List;

public interface RateService {
    void rateToMovie(Rate rate);
    List<Rate> retrieveByMovieId(int movieId);
}
