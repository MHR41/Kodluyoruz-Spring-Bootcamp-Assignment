package Passenger;

public enum PassengerAgeCategory {
    //the bellow numbers are discount percentage according to age category of passenger
    ADULT(1), CHILD(7);

    private int discountPercentage;
    private PassengerAgeCategory(int discountPercentage){
    
        this.discountPercentage = this.discountPercentage;
    }        

    public int getDiscountPercentage(){
        return discountPercentage;
    }
}
