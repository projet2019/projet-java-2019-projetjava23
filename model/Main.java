package model;

import java.time.LocalDateTime;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Game g = new Game(0, LocalDateTime.now());

		Player p1 = new Player(0, "joel");
		Player p2 = new Player(1, "nadia");
		Player p3 = new Player(2, "adele");
		Player p4 = new Player(3, "joacyn");

		Main.buildDeck(g);
		g.getPlayers().add(p1);
		g.getPlayers().add(p2);
		g.getPlayers().add(p3);
		g.getPlayers().add(p4);
		Main.distrbute(g);
		g.builLink();
		/*
		 * Main.print(p1.toString()); Main.print(p2.toString());
		 * Main.print(p3.toString()); Main.print(g.getDeck().get(0).toString() + " ");
		 */

		p1.playCard(g);
		p2.playCard(g);
		p2.pickTotem();
		p3.playCard(g);
		p3.pickTotem();
		p4.playCard(g);
		p4.pickTotem();

		p1.playCard(g);
		p1.pickTotem();
		p2.playCard(g);
		p2.pickTotem();
		p3.playCard(g);
		p3.pickTotem();
		p4.playCard(g);
		p4.pickTotem();

		p1.playCard(g);
		p1.pickTotem();
		p2.playCard(g);
		p2.pickTotem();
		p3.playCard(g);
		p3.pickTotem();
		p4.playCard(g);
		p4.pickTotem();

		p1.playCard(g);
		p1.pickTotem();
		p2.playCard(g);
		p2.pickTotem();
		p3.playCard(g);
		p3.pickTotem();
		p4.playCard(g);
		p4.pickTotem();
	}

	/**
	 * <u><b>Méthode utilitaire</u></b>
	 * <hr>
	 * <i>Facilite l'utilisation de l'output de la console</i>
	 * <hr>
	 * <br>
	 * 
	 * @param text
	 */
	public static void print(String text) {
		System.out.println(text);
	}

	/**
	 * <u><b>Méthode d'initialisation</u></b>
	 * <hr>
	 * 
	 * <i>Permet de distribuer les cartes créees entre les joueurs.</i>
	 * <hr>
	 * <br>
	 * 
	 * @param g
	 */
	public static void distrbute(Game g) {

		int cardNumber = 80 / g.getPlayers().size();

		for (int i = 0; i < g.getPlayers().size(); i++) {

			while (g.getPlayers().get(i).getCardslnHand().size() < cardNumber) {
				Random r = new Random();
				int select = r.nextInt(g.getDeck().size());
				Card c = g.getDeck().get(select);
				g.getPlayers().get(i).getCardslnHand().add(c);
				g.getDeck().remove(select);
			}
		}

	}

	/**
	 * <u><b>Méthode d'initialisation</u></b>
	 * <hr>
	 * 
	 * <i>Appelée lorsque le jeu est lancé, elle permet de créer les cartes</i>
	 * <hr>
	 * <br>
	 * 
	 * @param g <i> Partie où les cartes seront ajoutées</i>
	 */
	public static void buildDeck(Game g) {

		// cr�er les 72 cartes normales

		for (int i = 0; i < Color.getColorList().size(); i++) {

			for (int y = 0; y < Symbol.getSymbolList().size(); y++) {
				Card c = new NormalCard(g.getDeck().size(), Symbol.getSymbolList().get(y), Color.getColorList().get(i));

				g.getDeck().add(c);

			}
		}

		for (int i = 0; i < 2; i++) {
			Card c = new SpecialCard(g.getDeck().size(), "MULTI_COLOR", "Multi couleur", Image.image1);
			g.getDeck().add(c);
		}
		for (int i = 0; i < 3; i++) {
			Card c = new SpecialCard(g.getDeck().size(), "INTERIOR", "Fl�ches int�rieures", Image.image1);
			g.getDeck().add(c);
		}
		for (int i = 0; i < 3; i++) {
			Card c = new SpecialCard(g.getDeck().size(), "EXTERIOR", "Fl�ches ext�rieures", Image.image1);
			g.getDeck().add(c);
		}

	}
}
