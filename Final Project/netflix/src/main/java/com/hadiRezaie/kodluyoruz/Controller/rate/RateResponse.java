package com.hadiRezaie.kodluyoruz.Controller.rate;

import com.hadiRezaie.kodluyoruz.Service.rate.Rate;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class RateResponse {

    private int memberId;
    private int movieId;
    private int point;
    private LocalDateTime createdDate;

    private static RateResponse convertFromRate(Rate rate){
        return RateResponse.builder()
                .createdDate(rate.getCreatedDate())
                .memberId(rate.getMemberId())
                .movieId(rate.getMovieId())
                .point(rate.getPoint())
                .build();
    }

    public static List<RateResponse> convertFromRateList(List<Rate> rateList) {
        return rateList.stream()
                .map(RateResponse::convertFromRate)
                .collect(Collectors.toList());
    }
}
