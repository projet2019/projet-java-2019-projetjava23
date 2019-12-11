package model;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;

import sockets.ListenClient;

@SuppressWarnings("deprecation")
public class Player  extends Observable{

	private int idPlayer;
	private String name;
	
	private ArrayList<Card> cardslnHand = new ArrayList<Card>();
	private ArrayList<Card> cardslnFront = new ArrayList<Card>();
	
	private boolean pickTotem = false;
	
	private ListenClient scanner;
	private Socket socket;

	public Player(int idPlayer, String name, ArrayList<Card> cardslnHand, ArrayList<Card> cardslnFront) {
		
		this.idPlayer = idPlayer;
		this.name = name;
		this.cardslnHand = cardslnHand;
		this.cardslnFront = cardslnFront;
	}

	public Player(int idPlayer, String name, Card[] cardslnHand, Card[] cardslnFront) {
		
		this.idPlayer = idPlayer;
		this.name = name;

		for (int i = 0; i < cardslnHand.length; i++) {
			this.cardslnHand.add(cardslnHand[i]);
		}
		for (int i = 0; i < cardslnFront.length; i++) {
			this.cardslnFront.add(cardslnFront[i]);
		}
	}

	public Player(int idPlayer, String name) {
	
		this.idPlayer = idPlayer;
		this.name = name;

	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getCardslnHand() {
		return cardslnHand;
	}

	public void setCardslnHand(ArrayList<Card> cardslnHand) {
		this.cardslnHand = cardslnHand;
	}

	public ArrayList<Card> getCardslnFront() {
		return cardslnFront;
	}

	public void setCardslnFront(ArrayList<Card> cardslnFront) {
		this.cardslnFront = cardslnFront;
	}

	/**
	 * @return the pickTotem
	 */
	public boolean isPickTotem() {
		return pickTotem;
	}

	/**
	 * @param pickTotem the pickTotem to set
	 */
	public void setPickTotem(boolean pickTotem) {
		this.pickTotem = pickTotem;
	}
	

	/**
	 * @return the scanner
	 */
	public ListenClient getScanner() {
		return scanner;
	}

	/**
	 * @param scanner the scanner to set
	 */
	public void setScanner(ListenClient scanner) {
		this.scanner = scanner;
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * <u><b>Méthode toString</u></b>
	 * 
	 * 
	 */
	public String toString() {

		String s = "";
		s += "\n" + this.getName();
		s += "\n";
		for (int i = 0; i < this.cardslnHand.size(); i++) {

			if (this.getCardslnHand().get(i).getClass().equals(NormalCard.class)) {
				s += "\n " + i + "> " + ((NormalCard) this.cardslnHand.get(i)).getSymbol().getLabel() + " "
						+ ((NormalCard) this.cardslnHand.get(i)).getColor().getLabel();
			} else if (this.getCardslnHand().get(i).getClass().equals(SpecialCard.class)) {
				s += "\n " + i + "> " + ((SpecialCard) this.cardslnHand.get(i)).getLabel();
			}

		}
		return s;
	}

	/**
	 * <u><b>Méthode utilisateur</u></b>
	 * <hr>
	 * 
	 * <i>Elle permet de jouer une carte.</i>
	 * <hr>
	 * <br>
	 * 
	 * @param g <i> Partie en cours
	 */
	public void playCard(Game g) {
		this.getScanner().send(""+this.getIdPlayer(), "playCard");
		Card c = this.getCardslnHand().get(0);
		this.getCardslnHand().remove(0);
		this.getCardslnFront().add(c);
		Main.print("\n"+Main.now()+"" + this.getName() + " a joué la carte " + c.toString());
		
		if (c.getClass().equals(SpecialCard.class)) {
			if (((SpecialCard) c).getType().equalsIgnoreCase("MULTI_COLOR")) {
				g.setModeColor(true);
				Main.print("le jeu est en mode couleur");
			}
			if (((SpecialCard) c).getType().equalsIgnoreCase("INTERIOR")) {
				for(int i=0 ; i<g.getPlayers().size(); i++) {
					g.getPlayers().get(i).setPickTotem(true);
					g.setModeArrowInt(true);
					
				}
				
				Main.print("Activation du duel entre tous les joueurs");

			}
		}
		g.verifyGame();
	}

	/**
	 * <u><b>Méthode utilisateur pour recuperer un totem</u></b>
	 * 
	 * @return
	 */
	public boolean pickTotem(Game game) {
		this.getScanner().send(""+this.getIdPlayer(), "pickTotem");
		if (game.isModeArrowInt() == true) {
			
			game.getTrash().addAll(this.getCardslnFront());
			this.getCardslnFront().clear();
			
			Main.print("\n" + this.name + " a gagné le duel");
			Main.print("" + this.name + " place sa défausse au centre de la table");
			
			if (game.isModeArrowInt() == true) {
				game.setModeArrowInt(false);
				Main.print("le jeu n'est plus en mode intérieur");
			}
			if (game.isModeColor() == true) {
				game.setModeColor(false);
				Main.print("le jeu n'est plus en mode couleur");
			}
		}
		else {
			try {
	
				if (game.getLinkActive().getPlayer1().equals(this) || game.getLinkActive().getPlayer2().equals(this)) {
	
					Player loser;
					if (game.getLinkActive().getPlayer1().equals(this)) {
						loser = game.getLinkActive().getPlayer2();
					}
					else {
						loser = game.getLinkActive().getPlayer1();
					}
					
				//	Main.print(game.getLinkActive().getPlayer1().name+" "+game.getLinkActive().getPlayer1().isPickTotem());
				//	Main.print(game.getLinkActive().getPlayer2().name+" "+game.getLinkActive().getPlayer2().isPickTotem());
					
					if (this.pickTotem == true) {
						Main.print("\n "+Main.now()+"" + this.name + " a pris le totem");
	
						game.resolveDuel(this, loser);
						return true;
					}
					else {
						//Main.print("\n"+this.name+" n'a pas le droit de prendre le totem");
					}
	
				}
			} catch (NullPointerException e) {
			//	Main.print("Exception lors de la prise de totem du joueur "+this.name);
			}
		}
		
		
		return false;

	}
}
