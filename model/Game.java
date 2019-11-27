package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {

	private int idGame;
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Turn> turns = new ArrayList<Turn>();

	private LocalDateTime startedAt;
	private LocalDateTime endAt;
	private Player winnerPlayer;
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<LinkBetweenPlayer> listLink = new ArrayList<LinkBetweenPlayer>();
	private boolean modeColor = false;

	/**
	 * <b><u>Constructeur</u></b>
	 * 
	 * <hr>
	 * <i>Constructeur de la partie.</i>
	 * <hr>
	 * <br>
	 * 
	 * @param idGame    <i>Identifiant de la partie 0 > inf </i>
	 * @param startedAt <i>LocalDateTime au moment du lancement</i>
	 */
	public Game(int idGame, LocalDateTime startedAt) {
		super();
		this.idGame = idGame;
		this.startedAt = startedAt;

	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Turn> getTurns() {
		return turns;
	}

	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getEndAt() {
		return endAt;
	}

	public void setEndAt(LocalDateTime endAt) {
		this.endAt = endAt;
	}

	public Player getWinnerPlayer() {
		return winnerPlayer;
	}

	public void setWinnerPlayer(Player winnerPlayer) {
		this.winnerPlayer = winnerPlayer;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	/**
	 * @return the listLink
	 */
	public ArrayList<LinkBetweenPlayer> getListLink() {
		return listLink;
	}

	/**
	 * @param listLink the listLink to set
	 */
	public void setListLink(ArrayList<LinkBetweenPlayer> listLink) {
		this.listLink = listLink;
	}

	/**
	 * @return the modeColor
	 */
	public boolean isModeColor() {
		return modeColor;
	}

	/**
	 * @param modeColor the modeColor to set
	 */
	public void setModeColor(boolean modeColor) {
		this.modeColor = modeColor;
	}

	/**
	 * <b><u>Méthode d'observation</u></b>
	 * <hr>
	 * 
	 * <i>Appelée à chaque fois qu'un joueur joue une carte. </i>
	 * <hr>
	 * 
	 * 
	 */
	public void verifyGame() {

		for (int i = 0; i < this.getListLink().size(); i++) {

			this.getListLink().get(i).getPlayer1().setPickTotem(false);
			this.getListLink().get(i).getPlayer2().setPickTotem(false);

			if (this.modeColor == false && this.listLink.get(i).getPlayer1().getCardslnFront().size() > 0
					&& this.listLink.get(i).getPlayer2().getCardslnFront().size() > 0) {
				int index = this.listLink.get(i).getPlayer1().getCardslnFront().size() - 1;
				int index2 = this.listLink.get(i).getPlayer2().getCardslnFront().size() - 1;

				if (this.listLink.get(i).getPlayer1().getCardslnFront().get(index).getClass().equals(NormalCard.class)
						&& this.listLink.get(i).getPlayer2().getCardslnFront().get(index2).getClass()
								.equals(NormalCard.class)) {

					if (((NormalCard) this.listLink.get(i).getPlayer1().getCardslnFront().get(index)).getSymbol()
							.equals(((NormalCard) this.listLink.get(i).getPlayer2().getCardslnFront().get(index2))
									.getSymbol())) {
						this.getListLink().get(i).getPlayer1().setPickTotem(true);
						this.getListLink().get(i).getPlayer2().setPickTotem(true);
					}
				}
			} else if (this.listLink.get(i).getPlayer1().getCardslnFront().size() > 0
					&& this.listLink.get(i).getPlayer2().getCardslnFront().size() > 0) {
				int index = this.listLink.get(i).getPlayer1().getCardslnFront().size() - 1;
				int index2 = this.listLink.get(i).getPlayer2().getCardslnFront().size() - 1;
				if (((NormalCard) this.listLink.get(i).getPlayer1().getCardslnFront().get(index)).getColor().equals(
						((NormalCard) this.listLink.get(i).getPlayer2().getCardslnFront().get(index2)).getColor())) {
					this.getListLink().get(i).getPlayer1().setPickTotem(true);
					this.getListLink().get(i).getPlayer2().setPickTotem(true);
				}

			}
		}

	}

	/**
	 * <b><u>Méthode d'initialisation</b></u>
	 * <hr>
	 * 
	 * <i>Appelée lorsqu'une partie est créée. Elle permet de construire tout <br>
	 * les chemins existants entre chaque joueur. </i>
	 * <hr>
	 * 
	 * 
	 */
	public void builLink() {

		for (int i = 0; i < this.getPlayers().size(); i++) {

			for (int j = 0; j < this.getPlayers().size(); j++) {
				if (!this.getPlayers().get(i).equals(this.getPlayers().get(j))) {
					LinkBetweenPlayer link = new LinkBetweenPlayer(this.getPlayers().get(i), this.getPlayers().get(j));
					this.listLink.add(link);

				}
			}
		}
	}
}
