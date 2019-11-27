package model;

public class Turn {
	
	private int idTurn;
	private Player player;
	private TurnAction turnAction;
	

	public Turn(int idTurn, Player player, TurnAction turnAction) {
		super();
		this.idTurn = idTurn;
		this.player = player;
		this.turnAction = turnAction;
	}


	public int getIdTurn() {
		return idTurn;
	}


	public void setIdTurn(int idTurn) {
		this.idTurn = idTurn;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public TurnAction getTurnAction() {
		return turnAction;
	}


	public void setTurnAction(TurnAction turnAction) {
		this.turnAction = turnAction;
	}


	public Turn() {
		// TODO Auto-generated constructor stub
	}

}
