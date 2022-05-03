package com.travelAgency.demo.Dto.Flight;

import com.travelAgency.demo.Enum.FlightType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class FlightRequestDto {

    @NotBlank
    private int  planeId;

    @NotBlank
    private String date;

    private FlightType flightType;

    @NotBlank
    private String departure;

    @NotBlank
    private String arrival;
}
