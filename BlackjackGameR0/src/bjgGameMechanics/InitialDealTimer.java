package bjgGameMechanics;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import bjgGUI.MainWindow;
import bjgObjects.Card;

public class InitialDealTimer extends TimerTask {
	
	private Game game;
	private List<Card> initialDeal;
	private int cardDealtCount;
	
	public InitialDealTimer(Game game) {
		setGame(game);
		initialDeal = new ArrayList<Card>();
		game.deal();
		initialDeal.add(new Card(game.getPlayer().getCurrentHand().get(0)));
		initialDeal.add(new Card(game.getDealer().getCurrentHand().get(0)));
		initialDeal.add(new Card(game.getPlayer().getCurrentHand().get(1)));
		initialDeal.add(new Card("back"));
		setCardDealtCount(0);
	}
	
	@Override
	public void run() {
		
		MainWindow.initialDeal(initialDeal.get(cardDealtCount), cardDealtCount);
		cardDealtCount++;
		if(cardDealtCount >= initialDeal.size()) {
			super.cancel();
		}
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public List<Card> getInitialDeal() {
		return initialDeal;
	}
	public void setInitialDeal(List<Card> initialDeal) {
		this.initialDeal = initialDeal;
	}
	public int getCardDealtCount() {
		return cardDealtCount;
	}
	public void setCardDealtCount(int cardDealtCount) {
		this.cardDealtCount = cardDealtCount;
	}
}
