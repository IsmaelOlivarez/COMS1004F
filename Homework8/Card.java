
// add your own banner here

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		this.suit = s;
		this.rank = r;
	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted
		if(this.getRank()>c.getRank()){
			return 1;
		}else if(this.getRank()<c.getRank()){
			return -1;
		}else if(this.getSuit()>c.getSuit()){
			return 1;
		}else if(this.getSuit()<c.getSuit()){
			return -1;
		}
		return 0;

	}
	
	public String toString(){
		// use this method to easily print a Card object
		String rankString = "";
		String suitString = "";

		if(rank == 1){
			rankString = "A";
		}else if(rank > 1 && rank < 11){
			rankString = rank + "";
		}else if(rank == 11){
			rankString = "J";
		}else if(rank == 12){
			rankString = "Q";
		}else {
			rankString = "K";
		}

		if(suit == 1){
			suitString = "c";
		}else if(suit == 2){
			suitString = "d";
		}else if(suit == 3){
			suitString = "h";
		}else{
			suitString = "s";
		}
		
		return rankString + suitString;
	}

	// add some more methods here if needed
	public int getRank(){
		return rank;
	}

	public int getSuit(){
		return suit;
	}

	

}
