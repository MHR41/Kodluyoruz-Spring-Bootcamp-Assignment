package Flight;

import Airline.PegasusAirlines;

import java.time.LocalDate;

public final class PegasusAirlinesFlight extends Flight implements PegasusAirlines {

    private static PegasusAirlinesFlight pegasusAirlinesFlight;

    private PegasusAirlinesFlight(String flightNo, int baggageAllowanceBusinessClass, int baggageAllowanceEconomyClass, int businessClassSeatCapacity, int economyClassSeatCapacity, String departure, String arrival) {
        super(flightNo,baggageAllowanceBusinessClass,baggageAllowanceEconomyClass,businessClassSeatCapacity, economyClassSeatCapacity, departure, arrival, LocalDate.of(2022,05,10), FlightType.INTERNATIONAL, PegasusAirlines.airlineName);
    }

    //Applying singleton design pattern
    public static PegasusAirlinesFlight getFlight(){
        if(pegasusAirlinesFlight == null){
            pegasusAirlinesFlight = new PegasusAirlinesFlight("12AR39ZP", 30,20,15,90,"Turkey","Russia");
        }
        return pegasusAirlinesFlight;
    }

    @Override
    public String foodService(FlightType flightType) {
        String outPut = "";
        if(flightType.equals(FlightType.INTERNATIONAL)) {
            outPut = "Our flight will serve food beside drinks for international flights :) Good Appetite";
        }
        else if(flightType.equals(FlightType.DOMESTIC)){
            outPut = "flight serve only drinks for domestic flights ;)";
        }
        return outPut;
    }

    @Override
    public String toString() {
        return super.toString()+ foodService(FlightType.INTERNATIONAL);
    }

    public void setNormalPrice() {
        super.setNormalPrice(150);
    }
}
