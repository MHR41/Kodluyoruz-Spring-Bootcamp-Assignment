package com.hadiRezaie.kodluyoruz.Controller.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieCreateResponse {

    private int id;

    public static MovieCreateResponse convertToMovieCreateResponse(int id){
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }
}
