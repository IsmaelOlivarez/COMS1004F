/** Change.java - add your solutiuon to program 3 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Change {
    
    public static final void main(String[] args) {
        //Scaner initialization
        Scanner s = new Scanner(System.in);

        //Amounts
        System.out.println("Amount due in pennies: "); //Due
        int due = s.nextInt();

        System.out.println("Amount received from Customer: "); //received
        int given = s.nextInt();

        //Change
        int change = given - due;
        int inChange = change;
        
        //Dollars
        int dollars = change / 100;
        change %= 100;

        //Quarters
        int quarters = change / 25;
        change %= 25;

        //Dimes
        int dimes = change / 10;
        change %= 10;

        //Nickels
        int nickels = change / 5;
        change %= 5;

        System.out.println("Your change is " + inChange + ", which is " +
                            dollars + " dollar(s), " + quarters + 
                            " quarter(s), " + dimes + " dime(s), " + 
                            nickels + " nickel(s), and " + change + 
                            " pennie(s)");
        
    }
    
    
}
