package MidtermPractice1;

import java.util.Scanner;

public class Midterm {
    public static void main (String args[]){
        Scanner s = new Scanner(System.in);

        //First Challenge
        while(true){
            System.out.println("Enter an integer: ");
            int num = s.nextInt();

            if(num == 5 || num == 7 || num == 11){
                System.out.println("That's my lucky number!");
            }else if(num <= 0){
                break;
            }

        }


        //Second Challenge

        
        while(true){
            System.out.println("Enter a non-negative integer");
            int num = s.nextInt();
            if(num >= 0){
                System.out.println(num);
            }else{
                break;
            }
        }


        //Third Challenge

        System.out.println("How large is the Array?");
        int size = s.nextInt();
        int[] userArray = new int[size];
        for(int i = 0; i < userArray.length; i++){
            System.out.println("Enter int value for position " + i + " of the Array");
            userArray[i] = s.nextInt();
        }
    }
    
}
