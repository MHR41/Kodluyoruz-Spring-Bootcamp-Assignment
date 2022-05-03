package com.travelAgency.demo.Service;

import com.travelAgency.demo.Converter.FlightRequestDtoToFlight;
import com.travelAgency.demo.Converter.FlightResponseDtoListToFlightList;
import com.travelAgency.demo.Dto.Flight.FlightRequestDto;
import com.travelAgency.demo.Dto.Flight.FlightResponseDto;
import com.travelAgency.demo.Enum.FlightType;
import com.travelAgency.demo.Exception.NotFoundException;
import com.travelAgency.demo.Model.Flight;
import com.travelAgency.demo.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightRequestDtoToFlight flightRequestDtoToFlight;

    @Autowired
    FlightResponseDtoListToFlightList flightResponseDtoListToFlightList;

    public Integer saveFlight(FlightRequestDto flightRequestDto, FlightType flightType) {
        flightRequestDto.setFlightType(flightType);
        Flight flight = flightRequestDtoToFlight.convertFromFlightRequestDtoToFlight(flightRequestDto);
        return flightRepository.save(flight).getId();
    }

    public List<FlightResponseDto> findAllFlights(){
        List<FlightResponseDto> flightResponseDtoList = new ArrayList<>();
        List<Flight> flightList = flightRepository.findAll();

        for (Flight flight : flightList) {
            FlightResponseDto flightResponseDto = new FlightResponseDto();

            flightResponseDto.setId(flight.getId());
            flightResponseDto.setPlaneName(flight.getPlane().getPlaneName());
            flightResponseDto.setDeparture(flight.getDeparture());
            flightResponseDto.setArrival(flight.getArrival());

            //converting the Date format to string because JSON does not accept Date format
            String date = new SimpleDateFormat("dd-MM-yyyy hh:mm",   Locale.getDefault()).format(flight.getDate());
            flightResponseDto.setDate(date);
            flightResponseDto.setFlightType(flight.getFlightType());

            flightResponseDtoList.add(flightResponseDto);
        }
        return flightResponseDtoList;
    }

    public List<FlightResponseDto> findAllFlightsByPlaneId(int planeId){
        List<Flight> flightList = flightRepository.findAllByPlaneId(planeId);
        return flightResponseDtoListToFlightList.convertFromFlightResponseDtoListToFlightList(flightList);
    }

    public void deleteById(int flightId) {
        flightRepository.findById(flightId).orElseThrow(()-> new NotFoundException("Flight not exist with id"+ flightId));
        flightRepository.deleteById(flightId);
    }

    public Flight findFlightById(int flightId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(()-> new NotFoundException("Flight not exist with id "+ flightId));
        return flightRepository.findById(flightId).get();
    }
}
