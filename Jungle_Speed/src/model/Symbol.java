package model;

import java.util.ArrayList;

public class Symbol {
	private int idSymbol;
	private String label;
	private Image image;

	private static ArrayList<Symbol> symbolList = new ArrayList<Symbol>();

	public Symbol(int idSymbol, String label, Image image) {
		super();
		this.idSymbol = idSymbol;
		this.label = label;
		this.image = image;

		Symbol.symbolList.add(this);
	}

	public int getIdSymbol() {
		return idSymbol;
	}

	public void setIdSymbol(int idSymbol) {
		this.idSymbol = idSymbol;
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

	public static ArrayList<Symbol> getSymbolList() {
		return symbolList;
	}

	public static void setSymbolList(ArrayList<Symbol> symbolList) {
		Symbol.symbolList = symbolList;
	}

	public static final Symbol symbol1 = new Symbol(0, "Serpent 1", Image.image1);
	public static final Symbol symbol2 = new Symbol(1, "Serpent 2", Image.image2);
	public static final Symbol symbol3 = new Symbol(2, "Serpent 3", Image.image3);
	public static final Symbol symbol4 = new Symbol(3, "Serpent 4", Image.image4);
	public static final Symbol symbol5 = new Symbol(4, "Rond 1", Image.image5);
	public static final Symbol symbol6 = new Symbol(5, "Rond 2", Image.image6);
	public static final Symbol symbol7 = new Symbol(6, "Rond 3", Image.image7);
	public static final Symbol symbol8 = new Symbol(7, "Rond 4", Image.image8);
	public static final Symbol symbol9 = new Symbol(8, "Rosace 1", Image.image9);
	public static final Symbol symbol10 = new Symbol(9, "Rosace 2", Image.image10);
	public static final Symbol symbol11 = new Symbol(10, "Rosace 3", Image.image11);
	public static final Symbol symbol12 = new Symbol(11, "Rosace 4", Image.image12);
	public static final Symbol symbol13 = new Symbol(12, "Forme 1", Image.image13);
	public static final Symbol symbol14 = new Symbol(13, "Forme 2", Image.image14);
	public static final Symbol symbol15 = new Symbol(14, "Forme 3", Image.image15);
	public static final Symbol symbol16 = new Symbol(15, "Forme 4", Image.image16);
	public static final Symbol symbol17 = new Symbol(16, "Pois 1", Image.image17);
	public static final Symbol symbol18 = new Symbol(17, "Pois 2", Image.image18);

}
