package model;

public class SpecialCard extends Card {

	private String type;
	private String label;
	private Image image;

	public SpecialCard(int idCard, String type, String label, Image image) {
		super(idCard);
		this.type = type;
		this.label = label;
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * <i><b>Méthode toString</i></b>
	 * <hr>
	 * 
	 */
	public String toString() {

		String s = "";
		s += "" + this.getLabel();
		return s;
	}

}
