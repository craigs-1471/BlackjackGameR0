package bjgObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleDecks {
	
	// Fields
	private int numberOfPacks;
	private List<Deck> packsOfCards;
	private int count;
	private int cardsRemoved;
	
	// Constructors 
	public MultipleDecks(int numberOfPacks) {
		setNumberOfPacks(numberOfPacks);
		packsOfCards = new ArrayList<Deck>();
		for(int i = 0; i < getNumberOfPacks(); i++) {
			packsOfCards.add(new Deck());
		}
	}
	
	public MultipleDecks() {
		setNumberOfPacks(1);
		packsOfCards = new ArrayList<Deck>();
		packsOfCards.add(new Deck());
	}
	
	// Methods
	public String pickRandomCard() {
		String card = "X";
		int suit;
		int value;
		int pack;
		int noOfSuits = 4;
		int noOfValues = 13;
		
		Random rnd = new Random();
		do {
	
			suit = rnd.nextInt(noOfSuits);
			value = rnd.nextInt(noOfValues);
			pack = rnd.nextInt(numberOfPacks);
			card = packsOfCards.get(pack).getDeck()[suit][value];

		} while(card == "X");
		
		cardsRemoved++;
		if(value <= 4) {
			count++;
		}
		else if(value >= 8) {
			count--;
		}
		return card;
	}
	
	// Getters and setters
	public int getNumberOfPacks() {
		return numberOfPacks;
	}
	public void setNumberOfPacks(int numberOfPacks) {
		this.numberOfPacks = numberOfPacks;
	}
	public List<Deck> getPacksOfCards() {
		return packsOfCards;
	}
	public void setPacksOfCards(List<Deck> packsOfCards) {
		this.packsOfCards = packsOfCards;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCardsRemoved() {
		return cardsRemoved;
	}
	public void setCardsRemoved(int cardsRemoved) {
		this.cardsRemoved = cardsRemoved;
	}
}
