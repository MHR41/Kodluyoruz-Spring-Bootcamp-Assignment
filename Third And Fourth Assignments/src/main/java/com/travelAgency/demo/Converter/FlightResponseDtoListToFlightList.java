package com.travelAgency.demo.Converter;

import com.travelAgency.demo.Dto.Flight.FlightResponseDto;
import com.travelAgency.demo.Model.Flight;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class FlightResponseDtoListToFlightList {

    public List<FlightResponseDto> convertFromFlightResponseDtoListToFlightList(List<Flight> flightList){
        List<FlightResponseDto> flightResponseDtoList = new ArrayList<>();
        for (Flight flight : flightList) {
            FlightResponseDto flightResponseDto = new FlightResponseDto();

            //converting the Date format to string because JSON does not accept Date format
            String date = new SimpleDateFormat("dd-MM-yyyy",   Locale.getDefault()).format(flight.getDate());
            flightResponseDto.setDate(date);
            flightResponseDto.setId(flight.getId());
            flightResponseDto.setPlaneName(flight.getPlane().getPlaneName());
            flightResponseDto.setFlightType(flight.getFlightType());

            flightResponseDtoList.add(flightResponseDto);
        }
        return flightResponseDtoList;
    }
}
