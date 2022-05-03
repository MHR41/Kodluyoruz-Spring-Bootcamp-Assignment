package com.travelAgency.demo.Enum;

public enum PassengerAgeCategory {
    //the bellow numbers are discount percentage according to age category of passenger
    ADULT(1), CHILD(7);

    private double discountPercentage;
    private PassengerAgeCategory(double discountPercentage){

        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage(){
        return discountPercentage;
    }
}