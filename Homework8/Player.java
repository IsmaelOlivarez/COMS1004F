
// add your own banner here

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
        private double bet;

	// you may choose to use more instance variables
		
	public Player(){		
	    // create a player here
	}

	public void addCard(Card c){
	    // add the card c to the player's hand
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
        }
		
        public void bets(double amt){
            // player makes a bet
        }

        public void winnings(double odds){
            //	adjust bankroll if player wins
        }

        public double getBankroll(){
            // return current balance of bankroll
        }

        // you may wish to use more methods here
}


