package model;

public abstract class Card {
	private int idCard;

	public Card(int idCard) {
		super();
		this.idCard = idCard;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	
}
