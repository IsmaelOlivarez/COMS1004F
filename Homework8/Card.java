
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
		String rankString;
		if(rank == 1){
			rankString = "A";
		}else if(rank > 1 && rank < 11){
			rankString = suit + "";
		}else if(rank == 11){
			
		}
	}
	// add some more methods here if needed

	public int getRank(){
		return rank;
	}

	public int getSuit(){
		return suit;
	}

}
