package com.travelAgency.demo.Dto.Flight;

import com.travelAgency.demo.Enum.FlightType;
import lombok.Data;

@Data
public class FlightResponseDto {

    private int id;
    private String planeName;
    private String date;
    private FlightType flightType;
    private String arrival;
    private String departure;
}
