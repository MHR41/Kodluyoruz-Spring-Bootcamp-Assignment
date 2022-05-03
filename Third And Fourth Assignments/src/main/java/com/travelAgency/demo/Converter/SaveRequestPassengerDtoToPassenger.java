package com.travelAgency.demo.Converter;

import com.travelAgency.demo.Dto.Passenger.PassengerRequestDto;
import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import com.travelAgency.demo.Model.Passenger;
import org.springframework.stereotype.Component;

@Component
public class SaveRequestPassengerDtoToPassenger {

    public Passenger convertSaveRequestPassengerDtoToPassenger(PassengerRequestDto saveCustomerRequestDto){
        Passenger passenger = new Passenger();
        passenger.setLastName(saveCustomerRequestDto.getLastName());
        passenger.setName(saveCustomerRequestDto.getName());
        passenger.setPassengerId(saveCustomerRequestDto.getPassengerId());
        passenger.setPassengerEducationStatus(saveCustomerRequestDto.getPassengerEducationStatus());
        passenger.setPassengerAgeCategory(saveCustomerRequestDto.getPassengerAgeCategory());

        return passenger;
    }
}
