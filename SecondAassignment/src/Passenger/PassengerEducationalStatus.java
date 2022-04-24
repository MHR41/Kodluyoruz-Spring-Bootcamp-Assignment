package Passenger;

public enum PassengerEducationalStatus{
    //the bellow numbers are discount percentage according to passenger educational status
    STUDENT(8), NORMAL(1);

    private int discountPercentage;
    private PassengerEducationalStatus(int discountPercentage){

        this.discountPercentage = this.discountPercentage;
    }

    public int getDiscountPercentage(){
        return discountPercentage;
    }
}