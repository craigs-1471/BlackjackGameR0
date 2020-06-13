package bjgGameMechanics;

import bjgObjects.Dealer;
import bjgObjects.Deck;
import bjgObjects.MultipleDecks;
import bjgObjects.Player;

public class Game {
	
	// Game fields
	private MultipleDecks decks;
	private Player player;
	private Dealer dealer;
	
	// Constructor
	public Game() {
		decks = new MultipleDecks();
		player = new Player();
		dealer = new Dealer();
	}
	
	// Methods 
	public void deal() {
		String card1 = getDecks().pickRandomCard();
		String card2 = getDecks().pickRandomCard();
		
		String card3 = getDecks().pickRandomCard();
		String card4 = getDecks().pickRandomCard();
		
		getPlayer().placeSingleBet();
		
		getPlayer().addCard(card1, card2);
		getPlayer().setDealtHandValue();
		
		getDealer().addCard(card3, card4);
		getDealer().setDealtHandValue();
	}
	
	public String playerTwist() {
		String card = getDecks().pickRandomCard();
		getPlayer().addCard(card);
		getPlayer().setTwistHandValue();
		return card;
	}
	
	public void resetGame() {
		getPlayer().resetValues();
		getDealer().resetValues();
	}
	
	public void dealerTwist() {
		String card = getDecks().pickRandomCard();
		getDealer().addCard(card);
		getDealer().setTwistHandValue();
	}
	
	public void dealerGo() {
		
		while(getDealer().getCurrentHandValue() <= 16) {
			String card = getDecks().pickRandomCard();
			getDealer().addCard(card);
			getDealer().setTwistHandValue();
		}
		
		if(getDealer().isBust() && getPlayer().isBust()) {
			System.out.println("Draw");
		}
		else if(getDealer().isBust() && !getPlayer().isBust()) {
			getPlayer().winSingleBet();
			System.out.println("Player wins");
		}
		else if(!getDealer().isBust() && getPlayer().isBust()) {
			getPlayer().loseSingleBet();
			System.out.println("House wins");
		}
		else if(!getDealer().isBust() && !getPlayer().isBust() && getDealer().getCurrentHandValue() > getPlayer().getCurrentHandValue()) {
			getPlayer().winSingleBet();
			System.out.println("House wins");
		} else if(!getDealer().isBust() && !getPlayer().isBust() && getDealer().getCurrentHandValue() < getPlayer().getCurrentHandValue()) {
			getPlayer().winSingleBet();
			System.out.println("Player wins wins");
		}
		else {
			System.out.println("Draw");
		}
		
	}
	
//		public String getCurrentHands() {
//			String output;
//			output = getPlayer().currentPlayerHandToString() + "\n";
//			//output += getDealer().currentDealerHandToString();
//			return output;
//		}
//	
//		public void playRound() {
//			
//			int userChoice = 0;
//			String output;
//			
//			deal();
//			System.out.println(getPlayer().isBust());
//			do {
//				output = getCurrentHands();
//				output += "\nWould you like to twist?";
//				userChoice = JOptionPane.showConfirmDialog(null, output, "Black Jack!", JOptionPane.YES_NO_OPTION);
//				System.out.println(userChoice);
//				if(userChoice == 0) {
//					playerTwist();
//					System.out.println(getPlayer().isBust());
//					if(getPlayer().isBust()) {
//						output = getPlayer().currentPlayerHandToString() + " Game over.";
//					}
//				}
//			} while(userChoice == 0);
//			
//		}
	
	// Generate getters and setters
	
	public Player getPlayer() {
		return player;
	}
	public MultipleDecks getDecks() {
		return decks;
	}

	public void setDecks(MultipleDecks decks) {
		this.decks = decks;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
}
