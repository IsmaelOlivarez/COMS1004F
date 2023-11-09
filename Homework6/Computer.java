/*****************************************
 * A template for a computer Nim player
 ****************************************/ 
import java.util.Random;

public class Computer{
    
    private int mode;
    private int choice;
    private Random gen = new Random();
    
    public Computer(int m){
        mode = m;
        choice = -1;
    }

    public void move(int marblesLeft, int turn){
        /*
         * Checking for difficulty. If difficulty is 'stupid', the computer
         * will do the same move no matter what, for it is in stupid
         * mode, but if its not in stupid mode, we check for the turn
         * because if its taking the first turn, it has the opportunity to win.
         * MUST check in case the starting pile is a power of two--this
         * is the only way it MAY not be able to win with the first turn.
         */
        if(mode == 1){
            //Stupid mode no matter the turn || Bound to lose (if player allows)
            choice = gen.nextInt(marblesLeft/2 ) + 1;
        }else if (turn == 0){
            //Smart mode on second turn
            /*
             * Deciding whether or not it can even TRY to win
             * If the conditions are met, it could take the game and win.
             * Player has to almost let the computer win out of 
             * stupidity.
             */
            if(marblesLeft == (int)Math.pow(2,
                Math.ceil(Math.log(marblesLeft)/Math.log(2))) - 1){
                choice = gen.nextInt(marblesLeft/2) + 1;
            }else{
                choice = marblesLeft - ((int)Math.pow(2, 
                        Math.floor(Math.log(marblesLeft)/Math.log(2))) - 1);
            }
        }else if(turn == 1){ //Smart mode first turn
            //Checking for the starting pile to be a power of two...
            if(marblesLeft == (int)Math.pow(2,
            Math.ceil(Math.log(marblesLeft)/Math.log(2))) - 1){
            choice = gen.nextInt(marblesLeft/2) + 1;
        }else{
            choice = marblesLeft - ((int)Math.pow(2, 
                    Math.floor(Math.log(marblesLeft)/Math.log(2))) - 1);
        }

        }
        
    }
    
    
    public int getChoice(){
        return choice;
    }
    
    
}
