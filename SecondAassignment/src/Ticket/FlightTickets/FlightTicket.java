package Ticket.FlightTickets;

import Flight.FlightType;
import Passenger.Passenger;

import java.time.LocalDate;

public abstract class FlightTicket {

    private LocalDate date;
    private StringBuffer ticketNumber;
    private StringBuffer seatNumber;
    private Passenger passenger;
    private FlightType flightType;
    private SeatClassType seatClassType;
    private float ticketPrice;

    public FlightTicket(LocalDate date, Passenger passenger, FlightType flightType, SeatClassType seatClassType, StringBuffer ticketNumber, StringBuffer seatNumber) {
        this.date = date;
        this.passenger = passenger;
        this.flightType = flightType;
        this.seatClassType = seatClassType;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
    }

    //getter and setters


    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public SeatClassType getSeatClassType() {
        return seatClassType;
    }

    public void setSeatClassType(SeatClassType seatClassType) {
        this.seatClassType = seatClassType;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public StringBuffer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(StringBuffer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public StringBuffer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(StringBuffer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "FlightTicket{" +
                " book date=" + getDate() +
                ", ticket Number=" + ticketNumber +
                ", seat Number=" + seatNumber +
                ", flight Type=" + flightType +
                ", seatClass Type=" + seatClassType +
                ", ticket Price=" + ticketPrice +
                '}'+" " +passenger.toString() ;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate setDate(LocalDate date) {
        return this.date = date;
    }
}
