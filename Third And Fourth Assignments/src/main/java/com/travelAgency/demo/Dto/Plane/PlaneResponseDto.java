package com.travelAgency.demo.Dto.Plane;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PlaneResponseDto {

    @NotNull
    private int id;

    @NotBlank
    private String planeName;

    @NotNull
    private int capacity;
}
