package controller;

import model.Main;
import model.Player;
import view.View;

public class Controller {

	private Player model;
	private View vue;

	public Controller(Player model, View vue) {

		this.model = model;
	}

	@Deprecated
	public Controller(Player model) {
		this.model = model;
	}

	/**
	 * @return the model
	 */
	public Player getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Player model) {
		this.model = model;
	}

	/**
	 * @return the vue
	 */
	public View getVue() {
		return vue;
	}

	/**
	 * @param vue the vue to set
	 */
	public void setVue(View vue) {
		this.vue = vue;
	}

	public void addView(View vue) {
		this.vue = vue;
	}

	public void pickup() {
		
		//Main.print("Commande p executée");
		model.pickTotem(Main.g);
	}
	
	public void me() {
		Main.print("Contrôle de la console par "+model.getName());
	}
	
	public void stop() {
		Main.g.end(model);
	}
}
