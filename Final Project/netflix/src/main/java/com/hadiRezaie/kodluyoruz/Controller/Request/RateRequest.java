package com.hadiRezaie.kodluyoruz.Controller.Request;

import com.hadiRezaie.kodluyoruz.Service.rate.Rate;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RateRequest {

    @NotNull
    private int memberId;

    @NotNull
    private int movieId;

    @Min(1)
    @Max(5)
    @NotNull
    private int point;

    public Rate convertToRate() {
        return Rate.builder()
                .memberId(memberId)
                .movieId(movieId)
                .point(point)
                .build();
    }
}
