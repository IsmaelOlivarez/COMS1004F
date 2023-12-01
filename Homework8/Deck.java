
// add your own banner here

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
	
	private Card[] cards;
	private int top;// the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		top = 0;
		cards = new Card[52];
		int count = 0;
		for(int r = 1; r <=13; r++){
			for(int s = 1; s <= 4;s++){
				cards[count] = new Card(s,r);
				count++;
			}
		}
		count = 0;
		shuffle();
	}
	
	public void shuffle(){
		// shuffle the deck here
		/*Collections libary is just a library that is already used by
		*Java where it takes in some sort of list and spits it back out
		*But randomized. 
		*/
		ArrayList<Card> tempList = new ArrayList<>(Arrays.asList(cards));
		Collections.shuffle(tempList);
		for(int i = 0; i < 52; i++){
			cards[i] = tempList.get(i);
		}
		//cards = Card[]tempList.toArray();
		
	}
	
	public Card deal(){
		// deal the top card in the deck
		if(top>51){
			top++;
			return cards[51];
		}else{
			Card deal = cards[top];
			top++;
			return deal;
		}
	}
	
	// add more methods here if needed

}
