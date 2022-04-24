package Flight;

import Airline.TurkishAirlines;

import java.time.LocalDate;

public class TurkishAirlinesFlight extends Flight implements TurkishAirlines {

    private static TurkishAirlinesFlight turkishAirlinesFlight;

    private TurkishAirlinesFlight(String flightNo, int baggageAllowanceBusinessClass, int baggageAllowanceEconomyClass, int businessClassSeatCapacity, int economyClassSeatCapacity, String departure, String arrival) {
        super(flightNo,baggageAllowanceBusinessClass,baggageAllowanceEconomyClass,businessClassSeatCapacity, economyClassSeatCapacity, departure, arrival, LocalDate.of(2022,05,1), FlightType.INTERNATIONAL, TurkishAirlines.airlineName);
    }

    //Applying singleton design pattern
    public static TurkishAirlinesFlight getFlight(){
        if(turkishAirlinesFlight == null){
            turkishAirlinesFlight = new TurkishAirlinesFlight("12AR39ZP", 34,22,20,100,"US","UK");
        }
        return turkishAirlinesFlight;
    }

    @Override
    public String foodService(FlightType flightType) {
        String outPut = "";
        if(flightType.equals( FlightType.INTERNATIONAL)){
            outPut = "Our international flights serve food as well beside drinks:)";
        }
        else if(flightType.equals(FlightType.DOMESTIC)){
            outPut = "Our Domestic flights only serve drinks.)";
        }
        return outPut;
    }

    @Override
    public String toString() {
        return super.toString()+ foodService(FlightType.INTERNATIONAL);
    }

    public void setNormalPrice() {
        super.setNormalPrice(200);
    }
}
