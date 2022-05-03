package com.travelAgency.demo.Exception;

public class BiggerThanThreeDaysException extends RuntimeException{
    public BiggerThanThreeDaysException(){
        super("Exception: BiggerThanThreeDays");
    }
}
