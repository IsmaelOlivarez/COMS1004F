
// add your own banner here

public class Game {
	
	private Player p;
	private Deck cards;
	// you'll probably need some more here
	
	
	public Game(int level){
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
		
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		
	}
	
	public void play(){
		// this method should play the game	
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		
	}
	
	
	// you will likely want many more methods here
	// per discussion in class
}
