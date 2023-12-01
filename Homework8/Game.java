
// add your own banner here

import java.util.Scanner;

public class Game {
	
	private Player p;
	private Deck cards;
	private boolean active;
	private Scanner response;
	private String tempResponse;
	// you'll probably need some more here
	
	
	public Game(String[] testHand){
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
		cards = new Deck();
		p = new Player();
		response = new Scanner(System.in);
		active = true;
		tempResponse = "";
		/*
		 * Initial Hand Creation
		 */
		for(int i = 0; i < 5; i++){
			//Explanation-=-=-=-=-==-==-=-=-=-=-=-=-=-=--==--==X
			p.addCard(cards.deal());
		}
		
	}
	
	public void play(){
		// this method should play the game	
		while(active && p.getBankroll() > 0){
			System.out.println("How many coins would you like to bet?");

			giveBankroll();
			p.bets(response.nextDouble());
			giveBankroll();

			p.displayHand();

			System.out.println("Would you like to continue to remove any " + 
			"of these cards?");
			System.out.println("1 - Yes   2 - No");
			if(response.nextInt() == 1){
				boolean selection = true;
				while(selection){
					System.out.print("\033c");

					System.out.println("Select index to remove: ");
					p.displayHandIndex();

					System.out.println("Press x to finish removing cards!");

					response.nextLine();

					if(tempResponse.equals("x")){
						selection = false;
					}else{
						p.removeCard(p.getHand().get(Integer.parseInt(tempResponse)-1));
					}

				}
			}


			endGame();

		}
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		
	}

	public void giveBankroll(){
		System.out.println("Current Bankroll: " + p.getBankroll());
	}

	public void endGame(){
		System.out.println("Would you like to play another game?");
		System.out.println("1 - yes    0 - No");
		if(response.nextInt()==0){
			active = false;
		}
	}
	
	
	// you will likely want many more methods here
	// per discussion in class
}
