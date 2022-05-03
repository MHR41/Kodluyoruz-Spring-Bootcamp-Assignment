package com.travelAgency.demo.Controller;

import com.travelAgency.demo.Dto.Passenger.PassengerRequestDto;
import com.travelAgency.demo.Dto.Passenger.PassengerResponseDto;
import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import com.travelAgency.demo.Model.Passenger;
import com.travelAgency.demo.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/save-passenger")
    public ResponseEntity<Long> savePassenger(@Valid @RequestBody PassengerRequestDto passengerRequestDto,
                                                 @RequestParam PassengerEducationStatus educationalStatus
                                               , @RequestParam PassengerAgeCategory ageCategory){
        long passengerId = passengerService.savePassenger(passengerRequestDto, educationalStatus, ageCategory);
        return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PassengerResponseDto> getAllPassengers(){
        List<PassengerResponseDto> passengerResponseDtoList = passengerService.getAllPassengers();
        return passengerResponseDtoList;
    }
}
