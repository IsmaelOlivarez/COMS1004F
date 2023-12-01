
// add your own banner here

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Player p;
	private Deck cards;
	private boolean active;
	private Scanner response;
	private int tempResponse;
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
		tempResponse = 0;
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
			int cardOwe = 0;
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

					System.out.println("Press 9 to finish removing cards!");

					tempResponse = response.nextInt();
					
					if(tempResponse == 9){
						selection = false;
					}else if(tempResponse != 9 && tempResponse > p.getHand().size()){
						System.out.println("Please select vald index!");
					}else{
						p.removeCard(p.getHand().get(tempResponse-1));
						cardOwe++;
					}
				}
			}

			System.out.println("Here is your new hand!");
			for(int i = 0; i < cardOwe; i++){
				p.addCard(cards.deal());
			}

			System.out.print("\033c");
			p.displayHand();

			System.out.println(checkHand(p.getHand()));

			cards = new Deck();
			p = new Player();
			endGame();

		}
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		//Checking for Pair
		
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

	public int pairs(ArrayList<Card> hand){
		int pairNum=0;
		for(int i = 0; i < 5; i++){
			if(i == 4){
				return pairNum;
			}else if(hand.get(i).getRank()==hand.get(i+1).getRank()
					&&hand.get(i+1).getRank()!=hand.get(i+2).getRank()&&i!=2){
				i++;
				pairNum++;
			}else if(hand.get(i).getRank()==hand.get(i+1).getRank()){
				i++;
				pairNum++;
			}
		}
		return pairNum;
	}

	public int triple(ArrayList<Card> hand){
		for(int i = 0; i<5; i++){
			if(i == 3){
				//
			}else if(hand.get(i).getRank()==hand.get(i+1).getRank()){
				if(hand.get(i).getRank()==hand.get(i+2).getRank()){
					return 1;
				}
				i++;
				if(i==2){
					i=4;
					return 0;
				}
			}
		}
		return 0;
	}

	public int four(ArrayList<Card> hand){
		for(int i = 0; i<2;i++){
			if(hand.get(i).getRank()==hand.get(i+1).getRank()){
				if(hand.get(i+1).getRank()==hand.get(i+2).getRank()){
					if(hand.get(i+2).getRank()==hand.get(i+3).getRank()){
						return 1;
					}
				}
			}
		}
		return 0;
	}

	public int flush(ArrayList<Card> hand){
		if(hand.get(0).getSuit()==hand.get(1).getSuit()==hand.get(2).getSuit()==hand.get(3).getSuit()==hand.get(4).getSuit()){
				return 1;
		}
		return 0;
		
	}
	
	
	// you will likely want many more methods here
	// per discussion in class
}
