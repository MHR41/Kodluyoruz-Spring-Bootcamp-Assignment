package Ticket.Discount;

public interface PassengerDiscount {
    //discount will be given according to total number of tickets that purchased by one passenger
    float specialDiscount(int totalTicketNo);
}
