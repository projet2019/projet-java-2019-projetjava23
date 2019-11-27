package model;

public class TurnAction {

	private int idTurnAction;
	private Player player;
	private String actionType;
	
	
	public TurnAction(int idTurnAction, Player player, String actionType) {
		super();
		this.idTurnAction = idTurnAction;
		this.player = player;
		this.actionType = actionType;
	}


	public int getIdTurnAction() {
		return idTurnAction;
	}


	public void setIdTurnAction(int idTurnAction) {
		this.idTurnAction = idTurnAction;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public String getActionType() {
		return actionType;
	}


	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


}
