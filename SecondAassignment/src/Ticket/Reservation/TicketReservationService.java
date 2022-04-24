package Ticket.Reservation;

import Flight.Flight;
import Flight.FlightType;
import Flight.PegasusAirlinesFlight;
import Flight.TurkishAirlinesFlight;
import Passenger.Passenger;
import Ticket.FlightTickets.FlightTicket;
import Ticket.FlightTickets.PegasusAirlinesFlightTicket;
import Ticket.FlightTickets.SeatClassType;
import Ticket.FlightTickets.TurkishAirlinesFlightTicket;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import Passenger.*;
import java.util.Random;
import java.util.Scanner;

public class TicketReservationService {

    public Scanner sc = new Scanner(System.in);
    public Random random = new Random();
    public static ArrayList<FlightTicket> soldFlightTicketList = new ArrayList<>();

    ArrayList<StringBuffer> ticketNumberList_TurkishAirline = getTicketNumberList(120);
    ArrayList<StringBuffer> seatNoList_TurkishAirline = getSeatNumberList(120);
    ArrayList<StringBuffer> ticketNumberList_PegasusAirline = getTicketNumberList(105);
    ArrayList<StringBuffer> seatNoList_PegasusAirline = getSeatNumberList(105);

    public boolean CheckForAvailabilityOfFlight(Flight flight, int businessClassPassengerNo, int economyClassPassengerNo) throws InterruptedException {

        if(flight instanceof TurkishAirlinesFlight){
            boolean businessClassSeatAvailable = flight.isBusinessClassSeatAvailable(businessClassPassengerNo);
            boolean economyClassSeatAvailability = flight.isEconomyClassSeatAvailable(economyClassPassengerNo);

            if(businessClassSeatAvailable && economyClassSeatAvailability){
                flight.reserveEconomyClassSeat(economyClassPassengerNo);
                flight.reserveBusinessClassSeat(businessClassPassengerNo);
                System.out.print("Available seats were found for your request. You are redirecting to a page for filling your tickets information ");
                sleep(1000);
                return true;
            } else {
                return  false;
            }
        }
        if(flight instanceof PegasusAirlinesFlight){
            boolean businessClassSeatAvailable = flight.isBusinessClassSeatAvailable(businessClassPassengerNo);
            boolean economyClassSeatAvailability = flight.isEconomyClassSeatAvailable(economyClassPassengerNo);

            if(businessClassSeatAvailable && economyClassSeatAvailability){
                flight.reserveEconomyClassSeat(economyClassPassengerNo);
                flight.reserveBusinessClassSeat(businessClassPassengerNo);
                System.out.print("Available seats were found for your request. You are redirecting to a page for filling your tickets information ");
                sleep(1000);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public List<FlightTicket> bookTicket(Flight flight, int businessClassPassengerNo, int economyClassPassengerNo) {

        ArrayList<FlightTicket> flightTickets;
        if(flight.airlineName.equalsIgnoreCase("Turkish_Airlines")){
            flightTickets = fillTicketInfoForRequestedPassengerNo(businessClassPassengerNo, economyClassPassengerNo, flight);
            soldFlightTicketList.addAll(flightTickets);
            return flightTickets;
        }
        else if(flight.airlineName.equalsIgnoreCase("Pegasus_Airlines")){
            flightTickets = fillTicketInfoForRequestedPassengerNo(businessClassPassengerNo, economyClassPassengerNo, flight);
            soldFlightTicketList.addAll(flightTickets);
            return flightTickets;
        }
        return null;
    }

    private ArrayList<FlightTicket> fillTicketInfoForRequestedPassengerNo(int businessClassPassengerNo, int economyClassPassengerNo, Flight flight) {

        ArrayList<FlightTicket> flightTicketList = new ArrayList<>();
        if(businessClassPassengerNo > 0){
            for(int i=businessClassPassengerNo ; i >= 1 ; i--){

                Passenger passenger = getPassengerInfo();
                FlightType flightType = flight.getFlightType();
                SeatClassType seatClassType = SeatClassType.BUSINESS;
                StringBuffer ticketNumber;
                StringBuffer seatNumber;
                LocalDate date = LocalDate.now();

                if(flight.airlineName.equalsIgnoreCase("Turkish_Airlines")){
                    System.out.println("**********************");
                     ticketNumber = getTicketNumberFromTurkishAirlines();
                     seatNumber = getSeatNumberFromTurkishAirlines();

                    TurkishAirlinesFlightTicket turkishAirlinesFlightTicket = new TurkishAirlinesFlightTicket(date, passenger, flightType, seatClassType, ticketNumber, seatNumber);
                    flightTicketList.add(turkishAirlinesFlightTicket);

                }
                else{
                    ticketNumber = getTicketNumberFromPegasusAirlines();
                    seatNumber = getSeatNumberFromPegasusAirlines();

                    PegasusAirlinesFlightTicket pegasusAirlinesFlightTicket = new PegasusAirlinesFlightTicket(date, passenger, flightType, seatClassType, ticketNumber, seatNumber);
                    flightTicketList.add(pegasusAirlinesFlightTicket);
                }
            }
        }
        if(economyClassPassengerNo > 0){
            for(int i=economyClassPassengerNo ; i >= 1 ; i--){

                Passenger passenger = getPassengerInfo();
                FlightType flightType = flight.getFlightType();
                SeatClassType seatClassType = SeatClassType.ECONOMY;
                StringBuffer ticketNumber;
                StringBuffer seatNumber;
                LocalDate date = LocalDate.now();

                if(flight.airlineName.equalsIgnoreCase("Turkish_Airlines")){
                    ticketNumber = getTicketNumberFromPegasusAirlines();
                    seatNumber = getSeatNumberFromPegasusAirlines();

                    TurkishAirlinesFlightTicket turkishAirlinesFlightTicket = new TurkishAirlinesFlightTicket(date, passenger, flightType, seatClassType, ticketNumber, seatNumber );
                    flightTicketList.add(turkishAirlinesFlightTicket);
                }
                else{
                    ticketNumber = getTicketNumberFromPegasusAirlines();
                    seatNumber = getSeatNumberFromPegasusAirlines();


                    PegasusAirlinesFlightTicket pegasusAirlinesFlightTicket = new PegasusAirlinesFlightTicket(date, passenger, flightType, seatClassType, ticketNumber, seatNumber);
                    flightTicketList.add(pegasusAirlinesFlightTicket);
                }
            }
        }

        return flightTicketList;
    }

    private Passenger getPassengerInfo() {
        System.out.print("What is your name?" );
        String name = sc.nextLine();
        System.out.print("What is your last name? ");
        String lastName = sc.nextLine();
        System.out.print("Are you student?(1/0): ");
        int educationalStatus = sc.nextInt();
        PassengerEducationalStatus passengerEducationalStatus;
        if (educationalStatus == 1) {
            passengerEducationalStatus = PassengerEducationalStatus.STUDENT;
        } else {
            passengerEducationalStatus = PassengerEducationalStatus.NORMAL;
        }
        System.out.print("Are you Child or Adult? (child(1)/adult(0)): ");
        int ageStatus = sc.nextInt();
        PassengerAgeCategory passengerAgeCategory;
        if (ageStatus == 1) {
            passengerAgeCategory = PassengerAgeCategory.CHILD;
        } else {
            passengerAgeCategory = PassengerAgeCategory.ADULT;
        }
        return new Passenger(name, lastName, passengerEducationalStatus, passengerAgeCategory);
    }

    private StringBuffer getTicketNumberFromTurkishAirlines() {
        StringBuffer ticketNO = ticketNumberList_TurkishAirline.get(ticketNumberList_TurkishAirline.size()-1);
        this.ticketNumberList_TurkishAirline.remove(ticketNumberList_TurkishAirline.size()-1);
        return ticketNO;
    }

    private StringBuffer getSeatNumberFromTurkishAirlines() {
        StringBuffer seatNo = seatNoList_TurkishAirline.get(seatNoList_TurkishAirline.size()-1);
        this.seatNoList_TurkishAirline.remove(seatNoList_TurkishAirline.size()-1);
        return seatNo;
    }

    private StringBuffer getTicketNumberFromPegasusAirlines() {
        StringBuffer ticketNO = ticketNumberList_PegasusAirline.get(ticketNumberList_PegasusAirline.size()-1);
        this.ticketNumberList_PegasusAirline.remove(ticketNumberList_PegasusAirline.size()-1);
        return ticketNO;
    }

    private StringBuffer getSeatNumberFromPegasusAirlines() {
        StringBuffer seatNo = seatNoList_PegasusAirline.get(seatNoList_PegasusAirline.size()-1);
        this.seatNoList_PegasusAirline.remove(seatNoList_PegasusAirline.size()-1);
        return seatNo;
    }

    public Float calculateTicketPrice(List<FlightTicket> ticketList, Flight flight) {

        float totalPrice = 0;
        for (FlightTicket flightTicket : ticketList) {
            if(flightTicket instanceof  TurkishAirlinesFlightTicket){
                totalPrice = calculateTicketPriceTurkishAirlines(ticketList, flight);
                return totalPrice;
            }
            if(flightTicket instanceof  PegasusAirlinesFlightTicket){
                totalPrice =calculateTicketPricePegasusAirlines(ticketList, flight);
                return totalPrice;
            }
        }
        return null;
    }

    private float calculateTicketPricePegasusAirlines(List<FlightTicket> ticketList, Flight flight) {

        float totalPrice = 0.0f;
        float ticketPriceWithNormalDiscount;

        for (FlightTicket flightTicket : ticketList) {
            if(flight.flightNo.equalsIgnoreCase("12AR39ZP")){
                float normalTicketPrice = flight.getNormalPrice();
                ticketPriceWithNormalDiscount = calculateTicketPriceWithNormalDiscount(flightTicket.getPassenger().getEducationalStatus(), flightTicket.getPassenger().getAgeCategory(), normalTicketPrice);
                flightTicket.setTicketPrice(ticketPriceWithNormalDiscount);
                totalPrice += ticketPriceWithNormalDiscount;
            }
        }
        return totalPrice;
    }

    private float calculateTicketPriceTurkishAirlines(List<FlightTicket> ticketList, Flight flight) {
        float totalPrice = 0.0f;
        float ticketPriceWithNormalDiscount;

        for (FlightTicket flightTicket : ticketList) {
            if(flight.flightNo.equalsIgnoreCase("12AR39ZP")){
                float normalTicketPrice = flight.getNormalPrice();
                ticketPriceWithNormalDiscount = calculateTicketPriceWithNormalDiscount(flightTicket.getPassenger().getEducationalStatus(), flightTicket.getPassenger().getAgeCategory(), normalTicketPrice);
                flightTicket.setTicketPrice(ticketPriceWithNormalDiscount);
                totalPrice += ticketPriceWithNormalDiscount;
            }
        }
        //since passenger can buy all his tickets from only one airline then
        //if we check only one element of his ticket list for qualifying his special discount would be enough
        float specialDiscount = ((TurkishAirlinesFlightTicket)ticketList.get(0)).specialDiscount(ticketList.size());
        return totalPrice -= specialDiscount;
    }


    public float calculateTicketPriceWithNormalDiscount(PassengerEducationalStatus educationalStatus, PassengerAgeCategory ageCategory, float normalTicketPrice){
        float ticketPriceWithNormalDiscount = (educationalStatus.getDiscountPercentage()/100)* normalTicketPrice + (ageCategory.getDiscountPercentage()/100)* normalTicketPrice;
        return ticketPriceWithNormalDiscount;
    }

    //Canceling Ticket Operation
    public void cancelTicket(List<Flight> flightList){
        String flightNumber,ticketNumber;
        System.out.println("What is your flight number? ");
        flightNumber = sc.nextLine();
        for (Flight flight : flightList) {
            if(flight.flightNo.equalsIgnoreCase(flightNumber)){
                System.out.print("What is your ticket number ?");
                ticketNumber = sc.nextLine();
                boolean isTicketNumberFound = checkTicketNumberForCancellation(ticketNumber, flight);
                if(isTicketNumberFound){
                    System.out.println("Your ticket were canceled successfully");
                }
                else{
                    System.out.println("Cancellation process was failed. Your ticket was not found in the system!");
                }
            }
        }
    }

    private boolean checkTicketNumberForCancellation(String ticketNumber, Flight flight) {
        for (FlightTicket flightTicket : soldFlightTicketList) {
            if(flightTicket.getTicketNumber().equals(new StringBuffer(ticketNumber))){
                if(checkDateValidation(flight, flightTicket)){
                    soldFlightTicketList.remove(flightTicket);
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    private boolean checkDateValidation(Flight flight, FlightTicket flightTicket) {
        //Ticket cancellation is valid for 3 days after purchasing ticket
        Period differenceDay = Period.between(flightTicket.getDate(),LocalDate.now());
        if(flight.flightTime.isBefore(LocalDate.now())){
            if(differenceDay.getDays() <= 3){
                return true;
            }
            else
                return false;
        }
        return false;
    }

    //Holding the program for 3 seconds for having a nice look(means your request is in progress)
    public void sleep(int sleepMilisecond) throws InterruptedException {
        for(int i=0 ; i<3 ; i++){
            Thread.sleep(sleepMilisecond);
            System.out.print(".");
        }
        System.out.println();
    }


    // Generating Seat Number And Ticket Number

    ArrayList<StringBuffer> getTicketNumberList(int totalTicketNo) {

        ArrayList<StringBuffer> ticketNumberList = new ArrayList<>();
        int min = 65;
        int max = 90;
        //Generating Ticket Number(mix of character and integer)
        StringBuffer randomTicketNo  = new StringBuffer( );
        for(int i =1 ;i <= totalTicketNo ; i++){
            for(int j=0 ; j<10; j++){
                int randomNumber = random.nextInt(9);
                if(randomNumber % 2 == 0){
                    int randomNo = min + (int)(random.nextFloat() * (max - min + 1));
                    randomTicketNo.append((char) randomNo);
                } else{
                    randomTicketNo.append(randomNumber);
                }
            }
            ticketNumberList.add(randomTicketNo);
            randomTicketNo.delete(0,10);
        }
        return ticketNumberList;
    }

    private ArrayList<StringBuffer> getSeatNumberList(int totalSeatNo) {
        ArrayList<StringBuffer> seatNumberList = new ArrayList<>();

        //Generating Seat Number(mix of character and integer)
        StringBuffer randomSeatNo  = new StringBuffer( );

        Break:
        for(int i =1 ;i <= totalSeatNo ; i++){
            for(char j='A'; j <='Z'; j++){
                for(int k=1 ; k<7 ; k++){
                    randomSeatNo.append(k);
                    randomSeatNo.append(j);
                    seatNumberList.add(randomSeatNo);
                    randomSeatNo.delete(0,2);
                    if(seatNumberList.size()==105)
                        break Break;
                }
            }
        }
        return seatNumberList;
    }
}
