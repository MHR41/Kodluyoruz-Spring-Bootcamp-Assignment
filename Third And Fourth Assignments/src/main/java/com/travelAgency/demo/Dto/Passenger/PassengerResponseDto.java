package com.travelAgency.demo.Dto.Passenger;

import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import lombok.Data;

@Data
public class PassengerResponseDto {

    private String name;
    private String lastName;
    private PassengerEducationStatus passengerEducationStatus;
    private PassengerAgeCategory passengerAgeCategory;
    private long passengerId;
}
