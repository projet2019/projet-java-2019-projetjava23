package view;

import java.util.Observable;
import java.util.Observer;

import controller.Controller;
import model.Player;

public class View implements Observer {

	private Player model;
	protected Controller controller;

	public View(Player model, Controller controller) {
		
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
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
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}
