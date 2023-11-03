package MidtermPractice1;
import java.util.Random;


public class hw5 {
    public static void main(String[] args) {
        int[] arrr = new int[6];
        int i = 5;
        //System.out.println("running");
        makeCombination(arrr, i);
        for(int x = 0; x < arrr.length; x++)
            System.out.print(arrr[x] + " ");
    }

    public static void makeCombination(int[] values, int n)
{
Random generator = new Random();
int[] numbers = new int[values.length]; for (int i = 0; i < numbers.length; i++) {
numbers[i] = generator.nextInt(n); }
values = numbers; 
//for(int i = 0; i < numbers.length; i++)
    //System.out.print(numbers[i] + " ");
System.out.println();
//for(int i = 0; i < values.length; i++)
    //System.out.print(values[i] + " ");
//System.out.println("runningpart2");
}
    
}
