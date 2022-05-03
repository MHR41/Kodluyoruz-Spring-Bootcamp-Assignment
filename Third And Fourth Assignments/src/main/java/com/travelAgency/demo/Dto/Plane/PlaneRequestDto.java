package com.travelAgency.demo.Dto.Plane;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class PlaneRequestDto {

    @NotNull
    private String planeName;

    @NotNull
    private int capacity;
}
