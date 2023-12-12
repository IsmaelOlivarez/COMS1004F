/*
 * Ismael Olivarez
 * io2235  
 * Fail2Ban class
 * Meant to read a file of ips and determine which ones were not able to 
 * 3 times or more and record their ips in an output file.
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;


public class Fail2Ban{
    public static void main (String[] args){
        //Initialize Two Arraylist, one containing the ips and the other containing
        //Its corresponding counters.
        ArrayList<String> ips = new ArrayList<>();
        ArrayList<Integer> ipCounter = new ArrayList<>();

        /*
         *Trying for the first input file to read. If there is no file
         *for it to read, it will catch an out of bound error, and if there is no file
         * with that specified name, it will also throw a FileNotFoundException.
         */
        try{
            Scanner sc = new Scanner(new File(args[0]));

            while(sc.hasNextLine()){

                String line = sc.nextLine();
                String[] sections = line.split(" ");

                if(sections.length == 10){
                    int index = ips.indexOf(sections[9]);

                    if(index > -1){
                        int o = ipCounter.get(index);
                        ipCounter.set(index, o + 1);
                    }else{
                        ips.add(sections[9]);
                        ipCounter.add(1);
                    }
                }
            }

        } catch(FileNotFoundException e){
            System.out.println("File " + args[0] + " does not exist!");
            System.exit(-1);

        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No File passed!");
        }

        //Output all of the ips that failed to connect 3 times or more.
        try{
            File f = new File(args[1]);
            PrintWriter output = new PrintWriter(f);

            for(int i = 0; i < ips.size(); i++){
                if(ipCounter.get(i) >= 3){
                    output.println(ips.get(i));
                }
            }
            output.close();

        } catch(FileNotFoundException e){
            System.out.println("File " + args[1] + " does not exist!");
            System.exit(-1);

        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No File passed!");
        }
        
    }

}