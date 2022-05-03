package com.travelAgency.demo.Dto.Ticket;

import com.travelAgency.demo.Enum.FlightType;
import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import com.travelAgency.demo.Enum.SeatType;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ResponseTicketDto {

    @NotNull
    private int ticketNo;

    @NotBlank
    private String ticketBookDate;
    @NotNull
    private long passengerId;
    @NotBlank
    private String passengerName;
    @NotBlank
    private String passengerLastName;
    @NotNull
    private PassengerAgeCategory ageCategory;
    @NotNull
    private PassengerEducationStatus educationStatus;

    @NotNull
    private SeatType seatType;

    @NotBlank
    private String flightDate;
    @NotBlank
    private String arrival;
    @NotBlank
    private String departure;
    @NotNull
    private FlightType flightType;
    @NotBlank
    private String airlineName;

    @NotNull
    private double price;

}
