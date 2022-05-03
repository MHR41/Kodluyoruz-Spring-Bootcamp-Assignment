package com.travelAgency.demo.Converter;

import com.travelAgency.demo.Dto.Passenger.PassengerResponseDto;
import com.travelAgency.demo.Model.Passenger;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PassengerToPassengerResponseDto {

    public List<PassengerResponseDto> convertFromPassengerToPassengerResponseDto(List<Passenger> passengerList){
        List<PassengerResponseDto> passengerResponseDtoList = new ArrayList<>();
        for (Passenger passenger : passengerList) {
            PassengerResponseDto passengerResponseDto = new PassengerResponseDto();

            passengerResponseDto.setPassengerId(passenger.getPassengerId());
            passengerResponseDto.setPassengerAgeCategory(passenger.getPassengerAgeCategory());
            passengerResponseDto.setPassengerEducationStatus(passenger.getPassengerEducationStatus());
            passengerResponseDto.setName(passenger.getName());
            passengerResponseDto.setLastName(passenger.getLastName());

            passengerResponseDtoList.add(passengerResponseDto);
        }
        return passengerResponseDtoList;
    }
}
