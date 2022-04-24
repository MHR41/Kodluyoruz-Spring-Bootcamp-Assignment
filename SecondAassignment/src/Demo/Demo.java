package Demo;

import Flight.Flight;
import Ticket.FlightTickets.FlightTicket;
import Ticket.Reservation.TicketReservationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Flight.TurkishAirlinesFlight;
import Flight.PegasusAirlinesFlight;

public class Demo {

    public static Scanner sc = new Scanner(System.in);
    public static List<Flight> flightList = new ArrayList<>();
    public static TicketReservationService ticketReservationService = new TicketReservationService();

    public static void main(String[] args) throws InterruptedException {

        //Just two flights are available for now
        TurkishAirlinesFlight turkishAirlinesFlight = TurkishAirlinesFlight.getFlight();
        PegasusAirlinesFlight pegasusAirlinesFlight = PegasusAirlinesFlight.getFlight();
        flightList.add(turkishAirlinesFlight);
        flightList.add(pegasusAirlinesFlight);



        boolean stop = false;
        String welcome = "------------------------Welcome To Travel Agency Program------------------------";
        String menu = "1- Checking Available Flights\n" +
                "2- Request Ticket\n" +
                "3- Cancel Ticket\n" +
                "4- quite\n";
        System.out.println(welcome);
        while (!stop) {
            System.out.println("Please, select one of the following option to start.");
            System.out.println(menu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showAvailableFlights(flightList);
                    break;
                case 2:
                    requestForTicket();
                    break;
                case 3:
                    cancelTicket(flightList);
                    break;
                case 4:
                    stop = true;
                    break;
                default:
            }
        }
    }

    private static void requestForTicket() throws InterruptedException {
        System.out.print("Which airline do you want to travel with(From airlines that are available in item 1 of menu)? ");
        sc.nextLine();
        String airlineName = sc.nextLine();
        System.out.print("How many economy class seat do you need ? ");
        int economySeatNo = sc.nextInt();
        System.out.print("How many business class seat do you need? ");
        int businessSeatNo = sc.nextInt();

        for (Flight flight : flightList) {
            if (airlineName.equalsIgnoreCase(flight.airlineName)) {
                boolean isAvailable = ticketReservationService.CheckForAvailabilityOfFlight(flight, businessSeatNo, economySeatNo);
                if(isAvailable){
                    bookTickets(flight, businessSeatNo, economySeatNo);
                }
                else{
                    System.out.println("Unfortunately, there is not enough vacant seat for you request!");
                    break;
                }
            }
        }
    }

    private static void bookTickets(Flight flight, int businessSeatNo , int economySeatNo) throws InterruptedException {
        List<FlightTicket> bookedRequestedTickets;

        System.out.println("Do you Want To Book The Tickets ?(1/0) ");
        int answer = sc.nextInt();
        if(answer == 1){
            bookedRequestedTickets = ticketReservationService.bookTicket(flight, businessSeatNo, economySeatNo);
            float totalPriceOfTickets = ticketReservationService.calculateTicketPrice(bookedRequestedTickets , flight);
            System.out.println("Total price of your tickets is: "+ totalPriceOfTickets+" US dollars");
            System.out.print("Your Tickets Are Ready, The Result Well Be Printed In A Second:");
            ticketReservationService.sleep(1000);
            showBookedTickets(bookedRequestedTickets);
        }
    }

    private static void showBookedTickets(List<FlightTicket> ticketList) {

        System.out.println("List Of Your Ticket Are As Follow: ");
        System.out.println("-----------------------------------------");
        for (FlightTicket flightTicket : ticketList) {
            System.out.println(flightTicket.toString());;
            System.out.println("-----------------------------------------");
        }
    }


    private static void showAvailableFlights (List < Flight > flightList) {
        System.out.println("Flights List:");
        System.out.println("______________________________");
        for (Flight flight : flightList) {
            System.out.println(flight.toString());
            System.out.println("______________________________");
        }
    }

    private static void cancelTicket(List<Flight> flightList) {
        ticketReservationService.cancelTicket(flightList);
    }
}