package com.travelAgency.demo.Enum;

public enum PassengerEducationStatus{
    //the bellow numbers are discount percentage according to passenger educational status
    STUDENT(8), NORMAL(1);

    private double discountPercentage;
    private PassengerEducationStatus(double discountPercentage){

        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage(){
        return discountPercentage;
    }
}