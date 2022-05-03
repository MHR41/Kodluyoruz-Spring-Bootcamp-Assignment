package com.travelAgency.demo.Service;

import com.travelAgency.demo.Dto.Ticket.RequestTicketDto;
import com.travelAgency.demo.Dto.Ticket.ResponseTicketDto;
import com.travelAgency.demo.Enum.FlightType;
import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import com.travelAgency.demo.Enum.SeatType;
import com.travelAgency.demo.Exception.BiggerThanThreeDaysException;
import com.travelAgency.demo.Exception.ExceptionHandler;
import com.travelAgency.demo.Exception.FlightDatePassedException;
import com.travelAgency.demo.Exception.NotFoundException;
import com.travelAgency.demo.Model.Flight;
import com.travelAgency.demo.Model.Passenger;
import com.travelAgency.demo.Model.Ticket;
import com.travelAgency.demo.Repository.PassengerRepository;
import com.travelAgency.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerRepository passengerRepository;

    public int saveTicket(RequestTicketDto requestTicketDto, SeatType seatType) {

        Ticket ticket = new Ticket();

        //finding related flight and set it to tikcet's flight object
        Flight flight = flightService.findFlightById(requestTicketDto.getFlightId());
        ticket.setFlight(flight);

        //finding related passenger and set it to ticket's passenger object
        Passenger passenger = passengerRepository.getById(requestTicketDto.getPassengerId());
        ticket.setPassenger(passenger);

        ticket.setSeatType(seatType);

        //filling ticketBookDate and price of ticket
        Date ticketBookData = new Date();
        ticket.setDate(ticketBookData);
        double price = calculateTicketPrice(flight.getFlightType(), passenger.getPassengerAgeCategory(), passenger.getPassengerEducationStatus(), seatType);
        ticket.setPrice(price);

        ticketRepository.save(ticket);
        return ticket.getTicketNo();
    }


    public double calculateTicketPrice(FlightType flightType, PassengerAgeCategory passengerAgeCategory, PassengerEducationStatus passengerEducationStatus, SeatType seatType) {
        double normalPrice = seatType.getSeatPrice();
        double price = 0;
        if(flightType.equals(FlightType.INTERNATIONAL)){
            price += 5;  //International flight have 5 dollars tax
        }
        if(flightType.equals(FlightType.DOMESTIC)){
            price +=1;   //Domestic flight have only 1 dollar tax
        }

        price += seatType.getSeatPrice();
        price -= (passengerAgeCategory.getDiscountPercentage())/100*normalPrice;
        price -= (passengerEducationStatus.getDiscountPercentage())/100*normalPrice;
        return price;
    }

    public ResponseTicketDto findTicketByTicketId(int ticketId) {
        ticketRepository.findById(ticketId).orElseThrow(()-> new NotFoundException("Ticket is not exist with id "+ticketId));
        Ticket ticket = ticketRepository.findById(ticketId).get();

        //converting the Date format to string because JSON does not accept Date format
        String ticketDate = new SimpleDateFormat("dd-MM-yyyy hh:mm",   Locale.getDefault()).format(ticket.getDate());
        String  flightDate = new SimpleDateFormat("dd-MM-yyyy hh:mm",   Locale.getDefault()).format(ticket.getFlight().getDate());

        ResponseTicketDto responseTicketDto = new ResponseTicketDto();
        responseTicketDto.setTicketNo(ticket.getTicketNo());
        responseTicketDto.setTicketBookDate(ticketDate);
        responseTicketDto.setSeatType(ticket.getSeatType());
        responseTicketDto.setPassengerId(ticket.getPassenger().getPassengerId());
        responseTicketDto.setPassengerName(ticket.getPassenger().getName());
        responseTicketDto.setPassengerLastName(ticket.getPassenger().getLastName());
        responseTicketDto.setPrice(ticket.getPrice());
        responseTicketDto.setEducationStatus(ticket.getPassenger().getPassengerEducationStatus());
        responseTicketDto.setAgeCategory(ticket.getPassenger().getPassengerAgeCategory());
        responseTicketDto.setFlightDate(flightDate);
        responseTicketDto.setArrival(ticket.getFlight().getArrival());
        responseTicketDto.setDeparture(ticket.getFlight().getDeparture());
        responseTicketDto.setFlightType(ticket.getFlight().getFlightType());
        responseTicketDto.setAirlineName(ticket.getFlight().getPlane().getPlaneName());

        return responseTicketDto;
    }

    public void deleteTicket(int ticketId) throws BiggerThanThreeDaysException {
        ticketRepository.findById(ticketId).orElseThrow(()-> new NotFoundException("Ticket is not exist with id "+ticketId));
        Ticket ticket = ticketRepository.findById(ticketId).get();

        LocalDate todayDate = LocalDate.now();
        LocalDate ticketDate = convertToLocalDateViaSqlDate(ticket.getDate());
        LocalDate flightDate = convertToLocalDateViaSqlDate(ticket.getFlight().getDate());

        //Ticket cancellation is valid for 3 days after purchasing ticket
        Period differenceDay = Period.between(flightDate,LocalDate.now());
        if(todayDate.isBefore(flightDate)) {
            if(differenceDay.getDays() <= 3){
                ticketRepository.deleteById(ticketId);
            }
            else {
                throw new BiggerThanThreeDaysException();
            }
        }
        else{
            throw new FlightDatePassedException("Flight date passed.");
        }
    }

    private LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
}
