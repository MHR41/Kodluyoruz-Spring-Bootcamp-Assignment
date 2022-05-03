package com.travelAgency.demo.Converter;

import com.travelAgency.demo.Dto.Flight.FlightRequestDto;
import com.travelAgency.demo.Model.Flight;
import com.travelAgency.demo.Model.Plane;
import com.travelAgency.demo.Repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class FlightRequestDtoToFlight {

    @Autowired
    PlaneRepository planeRepository;

    public Flight convertFromFlightRequestDtoToFlight(FlightRequestDto flightRequestDto) {
        Plane plane = planeRepository.findById(flightRequestDto.getPlaneId()).get();
        Flight flight = new Flight();
        flight.setPlane(plane);
        flight.setFlightType(flightRequestDto.getFlightType());
        flight.setDeparture(flightRequestDto.getDeparture());
        flight.setArrival(flightRequestDto.getArrival());

        //Converting string format of ticketBookDate into Date for saving to ticketBookDate base
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm", Locale.ENGLISH);
        String dateInString = flightRequestDto.getDate();
        try {
            Date date = formatter.parse(dateInString);
            flight.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return flight;
    }
}
