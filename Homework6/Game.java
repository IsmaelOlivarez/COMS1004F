/*****************************************
 * A template for a Nim game
 ****************************************/ 
import java.util.Random;

public class Game{
    private Random gen = new Random();
    private int marbles;
    private int turn;
    private Human humanPlayer;
    private Computer computerPlayer;
    
    //Setting difficulty
    public Game(int difficulty){
        //Automatically assign 'stupid mode' if mode chosen
        //is not within the bounds.
        if(difficulty != 1 && difficulty != 2){
            System.out.println("Difficulty automatically set to "
            + "Default! (Easy)");
            difficulty = 1;
        }
        //Setting 'Computer' difficulty and 'Human' up
        //'turn' also given value to determine who goes first
        computerPlayer = new Computer(difficulty);
        humanPlayer = new Human();
        turn = gen.nextInt(2);

        //Marbles
        marbles = gen.nextInt(91) + 10;
        
    }
     
    public void play(){
        //Announce which side goes first
        if(turn == 0){
            System.out.println("Player has been chosen to go first!\n");
        }else {
            System.out.println("Computer has been chosen to go first!\n");
        }

        System.out.println("There are " + marbles + " marbles in this game!\n");

        while(marbles > 1){
            if(turn == 0){
                humanPlayer.move();
                legalCheck();
                marbles -= humanPlayer.getChoice();
                humanAnnounce();
                if(endGame()){
                    turn = -1;
                    break;
                }

                computerPlayer.move(marbles, turn);
                marbles -= computerPlayer.getChoice();
                compAnnounce();
                if(endGame()){
                    turn = 1;
                    break;
                }
            }else{
                computerPlayer.move(marbles, turn);
                marbles -= computerPlayer.getChoice();
                compAnnounce();
                if(endGame()){
                    turn = 1;
                    break;
                }

                humanPlayer.move();
                legalCheck();
                marbles -= humanPlayer.getChoice();
                humanAnnounce();
                if(endGame()){
                    turn = -1;
                    break;
                }
            }
        }
        
    }

    /*
     * Announcements mainly used for user interface
     * No real use--just so the player knows the count and how many
     * is being taken and what is left.
     */

    public void compAnnounce(){
        System.out.println("Computer took " + 
        computerPlayer.getChoice() + " marbles(s)! \n");
        System.out.println(marbles + " marble(s) left.\n");
    }

    public void humanAnnounce(){
        System.out.println("Player took " + 
        humanPlayer.getChoice() + " marbles(s)!\n");
        System.out.println(marbles + " marble(s) left.\n");
    }

    //Check whether or not the move the player is committing is okay or not
    //Computer has been coded so it CANNOT make illegal moves.
    public void legalCheck(){
        while(humanPlayer.getChoice() > marbles/2){
            System.out.println("Too many marbles! Please enter a legal move.\n");
            humanPlayer.move();
        }
    }

    //Checking whether the game has essentially 'ended' or not.
    //If so, prompts the winner and returns true so that the 
    //while loop can be 'break'ed, thus ending the game.
    public boolean endGame(){
        if(marbles == 1 && turn == -1) { 
            System.out.println("Player has won the game!\n");
            return true;
        }else if(marbles == 1 && turn == 1){
            System.out.println("Computer has won the game!\n");
            return true;
        }
        return false;
    }



}