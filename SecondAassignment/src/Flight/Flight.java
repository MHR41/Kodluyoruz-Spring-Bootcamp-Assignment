package Flight;

import java.time.LocalDate;

public abstract class Flight {
    public final String airlineName;
    public final String flightNo;
    public final LocalDate flightTime;
    public final FlightType flightType;
    public final int baggageAllowanceBusinessClass;
    public final int baggageAllowanceEconomyClass;
    public final int businessClassSeatCapacity;
    public final int economyClassSeatCapacity;
    public final String arrival;
    public final String departure;
    private int businessClassTotalReservedSeatNo = 0;
    private int economyClassTotalReservedSeatNo = 0;
    private float normalPrice; // In US Dollar




    public Flight(String flightNo, int baggageAllowanceBusinessClass, int baggageAllowanceEconomyClass, int businessClassSeatCapacity, int economyClassSeatCapacity, String departure, String arrival, LocalDate flightTime, FlightType flightType, String airlineName) {
        this.flightNo = flightNo;
        this.baggageAllowanceBusinessClass = baggageAllowanceBusinessClass;
        this.baggageAllowanceEconomyClass = baggageAllowanceEconomyClass;
        this.businessClassSeatCapacity = businessClassSeatCapacity;
        this.economyClassSeatCapacity = economyClassSeatCapacity;
        this.flightType = flightType;
        this.departure = departure;
        this.arrival = arrival;
        this.flightTime = flightTime;
        this.airlineName = airlineName;
    }

    public boolean isBusinessClassSeatAvailable(int totalNumOfSeat){
        if( businessClassTotalReservedSeatNo + totalNumOfSeat <= businessClassSeatCapacity){
            return true;
        } else {
            return false;
        }
    }

    public boolean isEconomyClassSeatAvailable(int totalNumOfSeat){
        if(economyClassTotalReservedSeatNo + totalNumOfSeat <= economyClassSeatCapacity){
            return true;
        } else {
            return false;
        }
    }

    public void reserveEconomyClassSeat(int economySeatNo){
        businessClassTotalReservedSeatNo += economySeatNo;
    }
    public void reserveBusinessClassSeat(int businessSeatNo){
        economyClassTotalReservedSeatNo +=  businessSeatNo;
    }

    @Override
    public String toString(){
        return  "Airline Name: "+airlineName+"\n"+
                "FlightNo:"+ flightNo+"\n"
                +"Departure: "+ departure+"\n"
                +"Arrival: "+ arrival+"\n"
                +"Flight Type: "+flightType+"\n"
                +"Flight Time: "+ flightTime+"\n"
                +"Baggage Allowance In Economy Class: "+baggageAllowanceEconomyClass+"KG\n"
                +"Baggage Allowance In Business Class: "+baggageAllowanceBusinessClass+"KG\n";
    }

    public FlightType getFlightType(){
        return this.flightType;
    }

    public float getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(float normalPrice) {
        this.normalPrice = normalPrice;
    }
}
