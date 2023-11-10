/*****************************************
 * Ismael Olivarez
 * io2235
 * Human player class used to initialize the human
 * player and allow for moveset.
 * A template for a Human Nim player
 ****************************************/ 
import java.util.Scanner;

public class Human{
   
    private int choice;
    private Scanner input;
    
    //Constructor
    public Human(){
        input = new Scanner(System.in);
        choice = -1;
    }
    
    //Move method--prompts user to type however many marbles it wishes to take.
    public void move(){
        System.out.println("How many marbles would you like to take?");
        choice = input.nextInt();
        
    }
    
    //Returns choice so that game can move forward and keep count.
    public int getChoice(){
        return choice;
    }
    
    
}
