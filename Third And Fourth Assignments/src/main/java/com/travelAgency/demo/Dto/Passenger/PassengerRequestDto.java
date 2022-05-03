package com.travelAgency.demo.Dto.Passenger;

import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PassengerRequestDto {

    @NotNull
    private long passengerId;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    private PassengerEducationStatus passengerEducationStatus;
    private PassengerAgeCategory passengerAgeCategory;
}
