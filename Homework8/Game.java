
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
		// example: testhand = {s1 s13 s12 s11 s10} = royal flush
		/*
		 * All functionality is working--all of the different checks are all operational.
		 */

		p = new Player();
		for(int i = 0; i < 5; i++){
			char suit = testHand[i].charAt(0);
			int s = 0;
			int rank = Integer.parseInt(testHand[i].substring(1));
			if(suit == 'c'){
				s = 1;
			}else if(suit == 'd'){
				s = 2;
			}else if(suit == 'h'){
				s = 3;
			}else if(suit == 's'){
				s = 4;
			}
			Card cards = new Card(s, rank);
			p.addCard(cards);
		}
		p.displayHand();
		System.out.println(checkHand(p.getHand()));
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
						System.out.println("Please select valid index!");
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
			giveBankroll();

			cards = new Deck();
			endGame();

		}
		if(p.getBankroll() < 0){
			System.out.println("Thank you for playing! You are now in debt to us.");
		}
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		//Checking for Pair
		if(straight(hand)==2 && flush(hand)==1){ //Royal Flush
			p.winnings(250);
			return "Royal Flush!";
		}else if(straight(hand)==1 && flush(hand)==1){ //Straight Flush
			p.winnings(50);
			return "Straight Flush!";
		}else if(four(hand)==1){ //Four
			p.winnings(25);
			return "Four of a kind!";
		}else if(pairs(hand)==2&&triple(hand)==1){ //Full house
			p.winnings(6);
			return "Full House!";
		}else if(flush(hand)==1){ // Flush
			p.winnings(5);
			return "Flush!";
		}else if(straight(hand)==1||straight(hand)==2){ //Straight
			p.winnings(4);
			return "Straight!";
		}else if(triple(hand)==1){ //Three
			p.winnings(3);
			System.out.println(pairs(hand));
			return "Three of a kind!";
		}else if(pairs(hand) == 2){ //Two pair
			p.winnings(2);
			return "Two pairs!";
		}else if(pairs(hand) == 1){ //One pair
			p.winnings(1);
			return "One pair";
		}
		return "Nothing... tough luck.";
		
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
		for(int i = 0; i < 5; i++){
			p.removeCard(p.getHand().get(0));
		}
		for(int i = 0; i < 5; i++){
			p.addCard(cards.deal());
		}

	}

	public int pairs(ArrayList<Card> hand){
		int pairNum = 0;
		for(int i = 0; i < 5; i++){
			if(i == 4){
				return pairNum;
			}else if(hand.get(i).getRank()==hand.get(i+1).getRank()){
				i++;
				pairNum++;
			}
		}
		return pairNum;
	}

	public int triple(ArrayList<Card> hand){
		for(int i = 0; i<3; i++){
			if(hand.get(i).getRank()==hand.get(i+2).getRank()){
				return 1;
			}
		}
		return 0;
	}

	public int four(ArrayList<Card> hand){
		for(int i = 0; i<2;i++){
			if(hand.get(i).getRank()==hand.get(i+3).getRank()){
				return 1;
			}
		}
		return 0;
	}

	public int flush(ArrayList<Card> hand){
		int suit = hand.get(0).getSuit();
		if(suit==hand.get(1).getSuit()&&suit==hand.get(2).getSuit()
		&&suit==hand.get(3).getSuit()&&suit==hand.get(4).getSuit()){
				return 1;
		}
		return 0;
	}
	
	public int straight(ArrayList<Card> hand){
		if(pairs(hand) >= 1){
			return 0;
		}else if(hand.get(4).getRank()-hand.get(0).getRank() == 4){
			return 1;
		}else if(hand.get(0).getRank() == 1&&hand.get(3).getRank()==4
		&&hand.get(4).getSuit()==13){
			return 1;
		}else if(hand.get(0).getRank() == 1&&hand.get(2).getRank()==3&&
		hand.get(3).getRank()==12&&hand.get(4).getSuit()==13){
			return 1;
		}else if(hand.get(0).getRank() == 1&&hand.get(1).getRank()==2&&
		hand.get(2).getRank()==11&&hand.get(4).getSuit()==13){
			return 1;
		}else if(hand.get(0).getRank()==1&&hand.get(1).getRank()==10
		&&hand.get(4).getRank()==13){
			return 2;
		}
		return 0;
	}
	
	// you will likely want many more methods here
	// per discussion in class
}
