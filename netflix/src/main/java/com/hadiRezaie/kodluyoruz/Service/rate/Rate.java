package com.hadiRezaie.kodluyoruz.Service.rate;

import com.hadiRezaie.kodluyoruz.Repository.movie.MovieEntity;
import com.hadiRezaie.kodluyoruz.Repository.rate.RateEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
@EqualsAndHashCode
public class Rate {

    private LocalDateTime createdDate;
    private int memberId;
    private int movieId;
    private int point;

    RateEntity convertToRateEntity(MovieEntity movieEntity){
        RateEntity rateEntity = new RateEntity();
        rateEntity.setCreatedDate(LocalDateTime.now());
        rateEntity.setMemberId(memberId);
        rateEntity.setMovie(movieEntity);
        rateEntity.setPoint(point);
        return rateEntity;
    }

    public static Rate convertFromRateEntity(RateEntity rateEntity) {
        return Rate.builder()
                .movieId(rateEntity.getMovie().getId())
                .point(rateEntity.getPoint())
                .createdDate(rateEntity.getCreatedDate())
                .memberId(rateEntity.getMemberId())
                .build();
    }
}
