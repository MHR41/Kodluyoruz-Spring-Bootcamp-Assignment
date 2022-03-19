public class GroceryStoreProgram{
    /**
     * This program is desinged for a holder of grocery store which can 
     * go to distributor and buy his/her products and then 
     * come back to his store and get the order from customers to sell them
     */
    public static void main(String[] args) throws InterruptedException{

       GroceryStore groceryStore = new GroceryStore();
       groceryStore.Start();
    }
}