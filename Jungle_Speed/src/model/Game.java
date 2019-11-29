package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {

	private int idGame;
	private ArrayList<Player> players = new ArrayList<Player>();

	private LocalDateTime startedAt;
	private LocalDateTime endAt;

	private Player winnerPlayer;
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> trash = new ArrayList<Card>();
	private ArrayList<LinkBetweenPlayer> listLink = new ArrayList<LinkBetweenPlayer>();
	private LinkBetweenPlayer linkActive;

	private boolean modeColor = false;
	private boolean modeArrowInt = false;
	private boolean modeArrowExt = false;

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
	 * @return the trash
	 */
	public ArrayList<Card> getTrash() {
		return trash;
	}

	/**
	 * @param trash the trash to set
	 */
	public void setTrash(ArrayList<Card> trash) {
		this.trash = trash;
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
	 * @return the linkActive
	 */
	public LinkBetweenPlayer getLinkActive() {
		return linkActive;
	}

	/**
	 * @param linkActive the linkActive to set
	 */
	public void setLinkActive(LinkBetweenPlayer linkActive) {
		this.linkActive = linkActive;
	}

	/**
	 * @return the modeArrowInt
	 */
	public boolean isModeArrowInt() {
		return modeArrowInt;
	}

	/**
	 * @param modeArrowInt the modeArrowInt to set
	 */
	public void setModeArrowInt(boolean modeArrowInt) {
		this.modeArrowInt = modeArrowInt;
	}

	/**
	 * @return the modeArrowExt
	 */
	public boolean isModeArrowExt() {
		return modeArrowExt;
	}

	/**
	 * @param modeArrowExt the modeArrowExt to set
	 */
	public void setModeArrowExt(boolean modeArrowExt) {
		this.modeArrowExt = modeArrowExt;
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

		for (int i = 0; i < this.getPlayers().size(); i++) {
			this.getPlayers().get(i).setPickTotem(false);
		}

		this.setLinkActive(null);// permet de reset le lien actif à chaque fois que la methode est appellé

		for (int i = 0; i < this.getListLink().size(); i++) {

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
						this.setLinkActive(this.getListLink().get(i));
						// Main.print("Lien activé symbole entre
						// "+this.getListLink().get(i).getPlayer1().getName()+" et
						// "+this.getListLink().get(i).getPlayer2().getName());
					}
				}
			} else if (this.listLink.get(i).getPlayer1().getCardslnFront().size() > 0
					&& this.listLink.get(i).getPlayer2().getCardslnFront().size() > 0) {
				int index = this.listLink.get(i).getPlayer1().getCardslnFront().size() - 1;
				int index2 = this.listLink.get(i).getPlayer2().getCardslnFront().size() - 1;

				if (this.listLink.get(i).getPlayer1().getCardslnFront().get(index).getClass().equals(NormalCard.class)
						&& this.listLink.get(i).getPlayer2().getCardslnFront().get(index2).getClass()
								.equals(NormalCard.class)) {

					if (((NormalCard) this.listLink.get(i).getPlayer1().getCardslnFront().get(index)).getColor()
							.equals(((NormalCard) this.listLink.get(i).getPlayer2().getCardslnFront().get(index2))
									.getColor())) {
						this.getListLink().get(i).getPlayer1().setPickTotem(true);
						this.getListLink().get(i).getPlayer2().setPickTotem(true);
						this.setLinkActive(this.getListLink().get(i));
						// Main.print("Lien activé couleur entre
						// "+this.getListLink().get(i).getPlayer1().getName()+" et
						// "+this.getListLink().get(i).getPlayer2().getName());
					}
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

	public void resolveDuel(Player winner, Player loser) {

		loser.getCardslnHand().addAll(winner.getCardslnFront());
		loser.getCardslnFront().addAll(this.getTrash());
		this.getTrash().clear();

		winner.getCardslnFront().clear();
		if (this.modeColor == true) {
			this.setModeColor(false);
			Main.print("le jeu n'est plus en mode couleur");
		}
		if (this.modeArrowInt == true) {
			this.setModeArrowInt(false);
			Main.print("le jeu n'est plus en mode intérieur");
		}
	}

	public Player end() {
		for (int i = 0; i < this.getPlayers().size(); i++) {
			if (this.getPlayers().get(i).getCardslnHand().isEmpty() == true
					&& this.getPlayers().get(i).getCardslnFront().isEmpty() == true) {
				Main.print("la partie est terminée et le joueur " + this.getPlayers().get(i).getName() + " a gagné");
				Main.timer.stop();
				return this.getPlayers().get(i);

			}
		}

		return null;
	}

	public void end(Player gagnant) {
		Main.print("la partie est terminée et le joueur " + gagnant.getName() + " a gagné");
		Main.timer.setStarted(false);

	}
}
