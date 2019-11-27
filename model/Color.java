package model;

import java.util.ArrayList;

public class Color {
	private int idImage;
	private String label;
	private String hexacode;
	private static ArrayList<Color> colorList = new ArrayList<Color>();

	public Color(int idImage, String label, String hexacode) {
		super();
		this.idImage = idImage;
		this.label = label;
		this.hexacode = hexacode;

		Color.colorList.add(this);
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getHexacode() {
		return hexacode;
	}

	public void setHexacode(String hexacode) {
		this.hexacode = hexacode;
	}

	public static ArrayList<Color> getColorList() {
		return colorList;
	}

	public static void setColorList(ArrayList<Color> colorList) {
		Color.colorList = colorList;
	}

	public static final Color JAUNE = new Color(0, "Jaune", "#FFFF00");
	public static final Color NOIR = new Color(0, "Noir", "#000000");
	public static final Color VERT = new Color(0, "Vert", "#00FF00");
	public static final Color ROUGE = new Color(0, "Rouge", "#FF0000");

}
