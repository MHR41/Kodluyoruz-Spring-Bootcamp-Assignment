package com.travelAgency.demo.Dto.Ticket;


import lombok.Data;

@Data
public class RequestTicketDto {

    private long passengerId;
    private int flightId;
}
