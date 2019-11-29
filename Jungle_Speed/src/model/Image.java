package model;

public class Image {
	
	private int idImage;
	private String location;
	private  String type;
	private String name;
	
	public Image(int idImage, String location,String name) {
		super();
		this.idImage = idImage;
		this.location = location;
		this.type = type;
		this.name = name;
	}

	public int getIdImage() {
		
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static final Image image1 = new Image(0,"","symbol");
	public static final Image image2 = new Image(1,"","symbol");
	public static final Image image3 = new Image(2,"","symbol");
	public static final Image image4 = new Image(3,"","symbol");
	public static final Image image5 = new Image(4,"","symbol");
	public static final Image image6 = new Image(5,"","symbol");
	public static final Image image7 = new Image(6,"","symbol");
	public static final Image image8 = new Image(7,"","symbol");
	public static final Image image9 = new Image(8,"","symbol");
	public static final Image image10 = new Image(9,"","symbol");
	public static final Image image11 = new Image(10,"","symbol");
	public static final Image image12 = new Image(11,"","symbol");
	public static final Image image13= new Image(12,"","symbol" );
	public static final Image image14 = new Image(13,"","symbol" );
	public static final Image image15 = new Image(14,"","symbol" );
	public static final Image image16= new Image(15,"","symbol" );
	public static final Image image17 = new Image(16,"","symbol" );
	public static final Image image18 = new Image(17,"","symbol" );
	
	
}
