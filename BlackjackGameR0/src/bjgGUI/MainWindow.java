package bjgGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import bjgGameMechanics.DealersGoTimer;
import bjgGameMechanics.Game;
import bjgGameMechanics.InitialDealTimer;
import bjgObjects.Card;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class MainWindow {

	private JFrame frame;
	private Game game;
	private static JLayeredPane lpnPlayerCards;
	private static JLayeredPane lpnDealerCards;
	private static int cardWidth = 100; // pixels 
	private static int cardHeight = 152;
	private static int cardOverlap = 30;
	private JButton btnStick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		game = new Game();
		
		JButton btnDeal = new JButton("Deal");
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(game.getPlayer().getCurrentHand().size() == 0) {
					InitialDealTimer dealer = new InitialDealTimer(game);
					Timer timer = new Timer(true);
					timer.schedule(dealer, 0, 300);
				}
			}
		});
		btnDeal.setBounds(119, 425, 89, 23);
		frame.getContentPane().add(btnDeal);
		
		lpnPlayerCards = new JLayeredPane();
		lpnPlayerCards.setBounds(109, 262, 400, 152);
		frame.getContentPane().add(lpnPlayerCards);
		
		lpnDealerCards = new JLayeredPane();
		lpnDealerCards.setBounds(109, 33, 400, 152);
		frame.getContentPane().add(lpnDealerCards);
		
		JButton btnTwist = new JButton("Twist");
		btnTwist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!game.getPlayer().isBust() && game != null) {
					Card card = new Card(game.playerTwist());
					int playerCardNumber = lpnPlayerCards.getComponentCount();
					card.setBounds(playerCardNumber * 30, 0, cardWidth, cardHeight);
					lpnPlayerCards.add(card, Integer.valueOf(playerCardNumber));
				}
				
			}
		});
		btnTwist.setBounds(519, 262, 89, 23);
		frame.getContentPane().add(btnTwist);
		
		btnStick = new JButton("Stick");
		btnStick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lpnDealerCards.remove(0);
				DealersGoTimer dealer = new DealersGoTimer(game);
				Timer timer = new Timer(true);
				timer.schedule(dealer, 0, 300);
			}
		});
		btnStick.setBounds(519, 296, 89, 23);
		frame.getContentPane().add(btnStick);
		
		JButton btnSplit = new JButton("Split");
		btnSplit.setBounds(519, 363, 89, 23);
		frame.getContentPane().add(btnSplit);
		
		JButton btnSurrender = new JButton("Surrender");
		btnSurrender.setBounds(519, 397, 89, 23);
		frame.getContentPane().add(btnSurrender);
		
		JButton btnDouble = new JButton("Double");
		btnDouble.setBounds(519, 329, 89, 23);
		frame.getContentPane().add(btnDouble);
	}
	
	public static void initialDeal(Card card, int cardDealtCount) {
		
		if(cardDealtCount % 2 == 0) {
			int playerCardNumber = lpnPlayerCards.getComponentCount();
			card.setBounds(playerCardNumber * cardOverlap, 0, cardWidth, cardHeight);
			lpnPlayerCards.add(card, Integer.valueOf(playerCardNumber));
		}
		else {
			int dealerCardNumber = lpnDealerCards.getComponentCount();
			card.setBounds(dealerCardNumber * cardOverlap, 0, cardWidth, cardHeight);
			lpnDealerCards.add(card, Integer.valueOf(dealerCardNumber));
		}
	}
	
	public static void dealersGo(Card card) {
		int dealerCardNumber = lpnDealerCards.getComponentCount();
		card.setBounds(dealerCardNumber * cardOverlap, 0, cardWidth, cardHeight);
		lpnDealerCards.add(card, Integer.valueOf(dealerCardNumber));
	}
}
