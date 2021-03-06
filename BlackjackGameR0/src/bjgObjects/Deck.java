package bjgObjects;

import java.util.Random;

public class Deck {
	
	// Deck fields
	private String[][] deck;
	
	// Constructor
	public Deck() {
		deck = new String[][] {
			{ "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH" },
			{ "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD" },
			{ "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC" },
			{ "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AS" }
		};
	}
	
	// Methods
	public String drawCard() {
		String card = "X";
		int suit;
		int value;
		int noOfSuits = 4;
		int noOfValues = 13;
		
		do {
			
			Random generator = new Random();
			suit = generator.nextInt(noOfSuits);
			value = generator.nextInt(noOfValues);
			
			card = this.deck[suit][value];
			
		} while(card == "X");
		
		this.deck[suit][value] = "X";
		return card;
	}
	
	// Getters and setters
	public String[][] getDeck() {
		return deck;
	}

	public void setDeck(String[][] deck) {
		this.deck = deck;
	}
}
