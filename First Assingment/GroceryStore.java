import java.util.Scanner;

public class GroceryStore{

    private int appleQuentity = 0;
    private int pearQuentity = 0;
    private int cherryQuentity = 0;
    Scanner sc  = new Scanner(System.in);


    // the start of program
    public void Start() throws InterruptedException{

        boolean exit = false;
        String menu = "1-Fruit Distributor\n2-Grocery Store\n3-Exit";
        int choice;
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-WELCOME TO GROCERY STORE PROGRAM _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        
        while (!exit) {

            System.out.println(menu);
            System.out.println("Please select item of the place you want to go");
            choice = sc.nextInt();
            
            switch(choice){

                case 1:
                    goToFruitDistributor();
                    break;
                
                case 2:
                    getOrderFromCustomer();
                    break;
                
                case 3:
                    exit = true;
                    System.out.print("You Are Quitting The Program");
                    for(int i=0 ; i<3 ; i++){
                        System.out.print(".");
                        Thread.sleep(500);

                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Please chosse the item correctly!");
            }
        }

    }

    //Method related to buying operation from Fruit Distributor

    public void goToFruitDistributor() throws InterruptedException{

        boolean isBying = true;
        int choice ;
        System.out.println("--------------Welcome To Fruite Distributor--------------");
        String menue = "1-Apple\n2-Pear\n3-Cherry\n4-Exit";
        while(isBying){

            System.out.println(menue);
            System.out.println("What do you want to buy from Fruit Distributor? (Please Choose It's Item From The Menue)");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    buyApple();
                    break;
                case 2:
                    buyPear();
                    break;
                case 3:
                    buyCherry();
                    break;
                case 4:
                    isBying = false;
                    System.out.print("You Are Quitting The Fruit Distributor");
                    for(int i=0 ; i<3 ; i++){
                        System.out.print(".");
                        Thread.sleep(500);

                    }
                    System.out.println();
                    break;
                default:
                System.out.println("Please chosse the item correctly!");
            }

        }
    }

    //Method related to getting order from customer
    public void getOrderFromCustomer() {

        String menue = "1-Apple\n2-Pear\n3-Cherry\n4-Exit";
        boolean isBying = true;
        int choice;
        System.out.println("~~~~~~~~~~~~~Welcome To Online Grocery Store~~~~~~~~~~~~~");
        while(isBying){

            System.out.println(menue);
            System.out.println("Please Choose The Item Which You Want To Order");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    buyAppleFromStore();
                    break;
                case 2:
                    buyPearFromStore();
                    break;
                case 3:
                    buyCherryFromStore();
                    break;
                case 4:
                    isBying = false;
                    System.out.println("We will be glad to see you again in our online gorcery store site:)");
                    break;
                default:
                System.out.println("Please chosse the item correctly!");
            }
        }
    }

    //Methos for buying Fruits from distributor

    private void buyApple(){

        System.out.println("How much apple do you want to buy from distributor?");
        int amountOfApple = sc.nextInt();
        this.appleQuentity += amountOfApple;
        System.out.println("The operatoin successfully done.");
        System.out.println("Updated amount of apple in your warehouse: "+getAppleQuentity());
        System.out.println("************************************");
    }

    private void buyCherry(){
        
        System.out.println("How much cherry do you want to buy from distributor?");
        int amountOfCherry = sc.nextInt();
        this.cherryQuentity += amountOfCherry;
        System.out.println("The operatoin successfully done.");
        System.out.println("Updated amount of cherry in your warehouse: "+getCherryQuentity());
        System.out.println("************************************");
        
    }

    private void buyPear(){

        System.out.println("How much pear do you want to buy buy from distributor?");
        int amountOfPear = sc.nextInt();
        this.pearQuentity += amountOfPear;
        System.out.println("The operatoin successfully done.");
        System.out.println("Updated amount of pear in your warehouse: "+getPearQuentity());
        System.out.println("************************************");
    }

    //Methos for bying Fruits from Grocery Store
    private void buyAppleFromStore(){

        System.out.println("How much apple do you want to buy?");
        int amountOfApple = sc.nextInt();
        if(getAppleQuentity() >= amountOfApple){

            setAppleQuentity(amountOfApple);
            System.out.println("Your order has recieved...");
            System.out.println("Your order will reach to you in 10 min, thanks for your patience");
            System.out.println("************************************");
        }
        else{
            System.out.println("We Are So Sorry, But There Is Not Enough Apple In The Store.(");
            System.out.println("************************************");
        }
        
    }

    private void buyCherryFromStore(){

        System.out.println("How much cherry do you want to buy?");
        int amountOfCherry = sc.nextInt();
        if(getCherryQuentity() >= amountOfCherry){

            setCherryQuentity(amountOfCherry);
            System.out.println("Your order has recieved...");
            System.out.println("Your order will reach to you in 10 min, thanks for your patience");
            System.out.println("************************************");
        }
        else{
            System.out.println("We Are So Sorry, But There Is Not Enough Cherry In The Store.(");
            System.out.println("************************************");
        }
        
    }

    private void buyPearFromStore(){

        System.out.println("How much cherry do you want to buy?");
        int amountOfPear = sc.nextInt();
        if(getPearQuentity() >= amountOfPear){

            setPearQuentity(amountOfPear);
            System.out.println("Your order has recieved...");
            System.out.println("Your order will reach to you in 10 min, thanks for your patience");
            System.out.println("************************************");
        }
        else{
            System.out.println("We Are So Sorry, But There Is Not Enough Pear In The Store.(");
            System.out.println("************************************");
        }
        
    }

    //getter and setter methods
    public int getAppleQuentity(){

        if(this.appleQuentity < 0){
            this.appleQuentity = 0;
        }
        return this.appleQuentity;
    }
    public int getPearQuentity(){
        
        if(this.pearQuentity <0){
            this.pearQuentity = 0;
        }
        return this.pearQuentity;
    }
    public int getCherryQuentity(){

        if(this.cherryQuentity <0){
            this.cherryQuentity = 0;
        }
        return this.cherryQuentity;
    }
    private void setCherryQuentity(int amount){

        this.cherryQuentity -= amount;
    }
    private void setAppleQuentity(int amount){

        this.appleQuentity -= amount;
    }
    private void setPearQuentity(int amount){

        this.pearQuentity -= amount;
    }


}