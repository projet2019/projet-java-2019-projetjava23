package model;

import java.util.ArrayList;

public class Player {

	private int idPlayer;
	private String name;
	private ArrayList<Card> cardslnHand = new ArrayList<Card>();
	private ArrayList<Card> cardslnFront = new ArrayList<Card>();
	private boolean pickTotem = false;

	public Player(int idPlayer, String name, ArrayList<Card> cardslnHand, ArrayList<Card> cardslnFront) {
		super();
		this.idPlayer = idPlayer;
		this.name = name;
		this.cardslnHand = cardslnHand;
		this.cardslnFront = cardslnFront;
	}

	public Player(int idPlayer, String name, Card[] cardslnHand, Card[] cardslnFront) {
		super();
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
		super();
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
		Card c = this.getCardslnHand().get(0);
		this.getCardslnHand().remove(0);
		this.getCardslnFront().add(c);
		g.verifyGame();
		Main.print("\n" + this.getName() + " a joué la carte " + c.toString());
	}

	/**
	 * <u><b>Méthode utilisateur pour recuperer un totem</u></b>
	 * 
	 * @return
	 */
	public boolean pickTotem() {
		if (this.pickTotem == true) {
			Main.print("\n" + this.name + " a pris le totem");
			return true;
		}
		Main.print("\n" + this.name + " ne peut pas prendre le totem");
		return false;

	}
}
