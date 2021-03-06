package bjgObjects;

import java.util.ArrayList;
import java.util.ListIterator;

public class Player {
	
	// Player fields
	private ArrayList<String> currentHand;
	private int currentHandValue;
	private boolean bust;
	private int fivePound;
	private int totalBank;
	
	// Constructor
	public Player() {
		currentHand = new ArrayList<String>();
		bust = false;
		fivePound = 20;
		setTotalBank();
	}
	
	// Methods
	public void addCard(String card) {
		currentHand.add(card);
	}
	
	public void addCard(String card1, String card2) {
		currentHand.add(card1);
		currentHand.add(card2);
	}
	
	public void resetValues() {
		setBust(false);
		setCurrentHandValue(0);
		currentHand.removeAll(currentHand);
	}
	
	public void setTotalBank() {
		int betAmount = 5 * getFivePound();
		setTotalBank(betAmount);
	}
	
	public void placeSingleBet() {
		this.fivePound--;
		setTotalBank();
	}
	
	public void winSingleBet() {
		this.fivePound++;
		setTotalBank();
	}
	
	public void loseSingleBet() {
		this.fivePound--;
		setTotalBank();
	}
	
//		public String currentPlayerHandToString() {
//			String currentHand = "Player's Hand:\n";
//			
//			ListIterator<String> itr = getCurrentHand().listIterator();
//			while(itr.hasNext()) {
//				currentHand+= itr.next() + " ";
//			}
//			
//			currentHand+= "value: " + getCurrentHandValue();
//			
//			return currentHand;
//		}
//	
//		public void displayHand() {
//			
//			System.out.println("Current Hand:");
//			
//			ListIterator<String> itr = getCurrentHand().listIterator();
//			while(itr.hasNext()) {
//				System.out.println(itr.next());
//			}
//			
//			int currentHandValue = getCurrentHandValue();
//			System.out.println("Hand value: " + currentHandValue);
//		}
	
	public int getCardValue(String card) {
	
		int cardValue = 0;
		
		switch (card.charAt(0)) {
		  case '2':
			  cardValue = 2;
		    break;
		  case '3':
			  cardValue = 3;
		    break;
		  case '4':
			  cardValue = 4;
		    break;
		  case '5':
			  cardValue = 5;
		    break;
		  case '6':
			  cardValue = 6;
		    break;
		  case '7':
			  cardValue = 7;
		    break;
		  case '8':
			  cardValue = 8;
		    break;
		  case '9':
			  cardValue = 9;
		    break;
		  case '1':
			  cardValue = 10;
		    break;
		  case 'J':
			  cardValue = 10;
		    break;
		  case 'Q':
			  cardValue = 10;
		    break;
		  case 'K':
			  cardValue = 10;
		    break;
		  case 'A':
			  cardValue = 11;
		    break;
		}
		return cardValue;
	}
	
	public void setDealtHandValue() {
		String cardOne = getCurrentHand().get(0);
		String cardTwo = getCurrentHand().get(1);
		int cardOneValue = getCardValue(cardOne);
		int cardTwoValue = getCardValue(cardTwo);
		this.currentHandValue = cardOneValue + cardTwoValue;
	}
	
	public void setTwistHandValue() {
		
		int totalAces = 0;
		setCurrentHandValue(0);
		
		ListIterator<String> itr = this.currentHand.listIterator();
		while(itr.hasNext()) {
			String card = itr.next();
			int cardValue = getCardValue(card);
			this.currentHandValue+= cardValue;
			if(cardValue == 11) {
				totalAces++;
			}
		}
		
		while(this.currentHandValue > 21 && totalAces > 0) {
			this.currentHandValue-= 10;
			totalAces--;
		}
		
		if(this.currentHandValue > 21) {
			setBust(true);
		}
	}
	
	// Getters and setters
	public ArrayList<String> getCurrentHand() {
		return currentHand;
	}
	public void setCurrentHand(ArrayList currentHand) {
		this.currentHand = currentHand;
	}
	public int getCurrentHandValue() {
		return currentHandValue;
	}
	public void setCurrentHandValue(int currentHandValue) {
		this.currentHandValue = currentHandValue;
	}
	public boolean isBust() {
		return bust;
	}
	public void setBust(boolean bust) {
		this.bust = bust;
	}
	public int getFivePound() {
		return fivePound;
	}
	public void setFivePound(int fivePound) {
		this.fivePound = fivePound;
	}
	public int getTotalBank() {
		return totalBank;
	}
	public void setTotalBank(int totalBank) {
		this.totalBank = totalBank;
	}
	
}
