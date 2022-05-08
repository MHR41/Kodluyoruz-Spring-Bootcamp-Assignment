package com.hadiRezaie.kodluyoruz.Controller.movie;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreateResponse {

    private int id;

    public static MovieCreateResponse convertToMovieCreateResponse(int id){
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }
}
