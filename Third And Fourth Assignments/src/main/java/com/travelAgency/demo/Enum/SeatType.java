package com.travelAgency.demo.Enum;

public enum SeatType {
    ECONOMY(100),BUSINESS(120);

    private int seatPrice;
    private SeatType(int price){
        this.seatPrice = this.seatPrice;
    }

    public int getSeatPrice(){
        return seatPrice;
    }
}