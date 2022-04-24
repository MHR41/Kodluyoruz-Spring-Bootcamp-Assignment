package Ticket.FlightTickets;

import Flight.FlightType;
import Passenger.Passenger;
import Ticket.Discount.PassengerDiscount;
import java.time.LocalDate;

public final class TurkishAirlinesFlightTicket extends FlightTicket implements PassengerDiscount {

    public TurkishAirlinesFlightTicket(LocalDate date, Passenger passenger, FlightType flightType, SeatClassType seatClassType, StringBuffer ticketNo, StringBuffer seatNo) {
        super(date, passenger, flightType, seatClassType, ticketNo, seatNo);
    }

    @Override
    public float specialDiscount(int totalTicketNo) {

        float discountInUsDollar = 0;
        if(totalTicketNo > 5){
            discountInUsDollar = 200f;
        }
        return discountInUsDollar;
    }
}
