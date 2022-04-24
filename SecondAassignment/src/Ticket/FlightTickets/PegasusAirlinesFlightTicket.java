package Ticket.FlightTickets;

import Flight.FlightType;
import Passenger.Passenger;

import java.time.LocalDate;

public final class PegasusAirlinesFlightTicket extends FlightTicket {

    public PegasusAirlinesFlightTicket(LocalDate date, Passenger passenger, FlightType flightType, SeatClassType seatClassType, StringBuffer ticketNumber, StringBuffer seatNumber) {
        super(date, passenger, flightType, seatClassType, ticketNumber, seatNumber);
    }
}

