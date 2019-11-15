package model;

/**
 * Class allowing the representation of an image
 *
 * @author joel yepgang
 */

	public class Image {

		private int id;
		private String location;
		private String type;
		private String name;
		
		/**
		 * constructor 
		 * @param id  the id of card image
		 * @param location the location of an image 
		 * @param type the type 
		 * @param name the name of an image
		 */

	public Image(int id, String location, String type, String name) {

		this.id = id;
		this.location = location;
		this.type = type;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method compares the value of two instances.
	 * @param obj
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/**
	 * 
	 * this method makes it possible to obtain a set of information on an image
	 * corresponding to a map on a carpet
	 */
	public String toString() {
		return "Image information : " + " " + id + " " + location + " " + type + " " + name;
	}

}
