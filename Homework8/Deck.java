
// add your own banner here

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int top; // the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		top = 0;
		for(int r = 1; r <=13; r++){
			for(int s = 1; s <= 4;s++){
				Card newCard = new Card(s,r);
				cards.add(newCard);
			}
		}
	}
	
	public void shuffle(){
		// shuffle the deck here
		/*Collections libary is just a library that is already used by
		*Java where it takes in some sort of list and spits it back out
		*But randomized. 
		*/
		Collections.shuffle(cards);
	}
	
	public Card deal(){
		// deal the top card in the deck
		if(top>51){
			top++;
			return cards.get(52);
		}else{
			Card deal = cards.get(top);
			top++;
			return deal;
		}
	}
	
	// add more methods here if needed

}
