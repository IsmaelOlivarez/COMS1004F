/** F2C.java - add your solutiuon to program 1 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class F2C {
    
    public static final void main(String[] args) {
        // (32°F − 32) × 5/9 = 0°C
        //Scanner initialization
        Scanner s = new Scanner(System.in);

        //Prompt
        System.out.println("Enter the temperature in fahrenheit!");

        //Save Values
        int fTemp = s.nextInt();
        int cTemp = ((fTemp - 32) * 5 / 9);

        //Output
        System.out.println("Your temperature " + fTemp + 
                           " in fahrenheit is about " + cTemp + " in Celsius");
        
    }
    
    
}
