package bjgObjects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel {
	
	ImageIcon cardImage;
	String card;
	
	// This is the computer value 0-9
	int cardValue;
	
	public Card() {}
	
	public Card(String card) {
		//lblShowImage.setIcon(new ImageIcon(MainApp.class.getResource("/bsResources/220px-USS_Deyo;0598917.jpg")));
		
		String imageFilePath = "./imgCards/" + card + ".jpg";
		cardImage = new ImageIcon(this.getClass().getResource(imageFilePath));
		setIcon(cardImage);
		setCard(card);
	}
	
	public Card(String card, int cardValue) {
		//lblShowImage.setIcon(new ImageIcon(MainApp.class.getResource("/bsResources/220px-USS_Deyo;0598917.jpg")));
		
		String imageFilePath = "/imgCards/" + card + ".jpg";
		cardImage = new ImageIcon(this.getClass().getResource(imageFilePath));
		setIcon(cardImage);
		setCard(card);
		
		// See field comment 
		setCardValue(cardValue);
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
}
