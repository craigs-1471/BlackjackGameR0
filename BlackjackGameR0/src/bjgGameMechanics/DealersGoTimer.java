package bjgGameMechanics;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import bjgGUI.MainWindow;
import bjgObjects.Card;

public class DealersGoTimer extends TimerTask {
	
	private Game game;
	private List<String> dealersHand;
	private int dealtCardCount;
	
	public DealersGoTimer(Game game) {
		setGame(game);
		game.dealerGo();
		setDealersHand(game.getDealer().getCurrentHand());
		setDealtCardCount(1);
	}
	
	@Override
	public void run() {

		MainWindow.dealersGo(new Card(dealersHand.get(dealtCardCount)));
		dealtCardCount++;
		if(dealtCardCount >= dealersHand.size()) {
			super.cancel();
		}
		
	}

	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public List<String> getDealersHand() {
		return dealersHand;
	}
	public void setDealersHand(List<String> dealersHand) {
		this.dealersHand = dealersHand;
	}
	public int getDealtCardCount() {
		return dealtCardCount;
	}
	public void setDealtCardCount(int dealtCardCount) {
		this.dealtCardCount = dealtCardCount;
	}
}
