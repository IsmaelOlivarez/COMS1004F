/** Minutes.java - add your solutiuon to program 2 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Minutes {
    
    public static final void main(String[] args) {
        //Scanner initialization
        Scanner s = new Scanner(System.in);

        //Hours
        System.out.println("Enter the number of Hours: ");
        int hours = s.nextInt() * 60;

        //Days
        System.out.println("Enter the number of Days: ");
        int days = s.nextInt() * 24 * 60;
        
        //Weeks
        System.out.println("Enter the number of Weeks: ");
        int weeks = s.nextInt() * 24 * 60 * 7;

        //Years
        System.out.println("Enter the number of Years: ");
        int years = s.nextInt() * 525600;

        //Final minutes
        int minutes = hours + days + weeks + years;


        //Output
        System.out.println("The total number of minutes within all of the " + 
                            "hours, days, weeks, and years is " + minutes +
                             " minutes.");
        
        
        
    }
    
    
}
