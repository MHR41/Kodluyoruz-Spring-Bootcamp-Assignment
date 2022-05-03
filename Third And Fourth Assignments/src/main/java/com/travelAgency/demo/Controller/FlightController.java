package com.travelAgency.demo.Controller;

import com.travelAgency.demo.Dto.Flight.FlightRequestDto;
import com.travelAgency.demo.Dto.Flight.FlightResponseDto;
import com.travelAgency.demo.Enum.FlightType;
import com.travelAgency.demo.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/save-flight")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createFlight(@RequestBody FlightRequestDto flightRequestDto
                               ,@RequestParam FlightType flightType){
        int flightId = flightService.saveFlight(flightRequestDto, flightType);
        return flightId;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlightResponseDto> getAllFlights(){
        return flightService.findAllFlights();
    }

    @GetMapping("/{planeid}")
    @ResponseStatus(HttpStatus.OK)
    public List<FlightResponseDto> getAllFlightsByPlaneId(@PathVariable int planeid){
        return flightService.findAllFlightsByPlaneId(planeid);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlightById(@RequestParam int flightId){
        flightService.deleteById(flightId);
    }
}
