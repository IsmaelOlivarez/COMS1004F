
// add your own banner here

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;

	// you may choose to use more instance variables
		
	public Player(){		
	    // create a player here
        hand = new ArrayList<>();
        bankroll = 50;
        bet = 0;
        
	}

	public void addCard(Card c){
	    // add the card c to the player's hand
        this.hand.add(c);
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
        hand.remove(c);
    }
		
    public void bets(double amt){
        // player makes a bet
        this.bet = amt;
        this.bankroll -= bet;
    }

    public void winnings(double odds){
        //	adjust bankroll if player wins
        this.bankroll += bet * odds;
    }

     public double getBankroll(){
        // return current balance of bankroll
       return bankroll;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void displayHand(){
        int i = 0;
        Collections.sort(hand);
        System.out.println("Your hand: ");
        System.out.print("{");
        while(i < 5){
            System.out.print(hand.get(i).toString() + ", ");
            i++;
        }
        System.out.print("}");
        System.out.println();
    }

    public void displayHandIndex(){
        int i = 0;
        Collections.sort(hand);
        
        System.out.println("Your hand: ");
        System.out.print("{");

        while(i < hand.size()){
            System.out.print(hand.get(i).toString() + "[" + (i+1) +"],");
            i++;
        }

        System.out.print("}");
        System.out.println();
    }

    // you may wish to use more methods here
}


