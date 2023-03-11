package model;

/**
 * 
 * A class representing a House property that extends the Property class.
 */
public class House extends Property {

	private int streetNumber;
	private int houseNumber;

	/**
	 * 
	 * Creates a new House object with the given parameters.
	 *                      
	 * @param streetName    the street name of the house
	 * @param city          the city of the house
	 * @param postalCode    the postal code of the house
	 * @param province      the province of the house
	 * @param country       the country of the house
	 * @param noOfBedrooms  the number of bedrooms in the house
	 * @param noOfBathrooms the number of bathrooms in the house
	 * @param squareFootage the square footage of the house
	 * @param houseNumber   the house number of the house
	 * @param streetNumber  the street number of the house
	 */
	public House(String streetName, String city, String postalCode, String province, String country, int noOfBedrooms,
			int noOfBathrooms, int squareFootage, int houseNumber, int streetNumber) {
		super(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms, squareFootage);
		this.houseNumber = houseNumber;
		this.streetNumber = streetNumber;
	}

	/**
	 * 
	 * Returns the street number of the house
	 * 
	 * @return the street number of the house
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * 
	 * Sets the street number of the house.
	 * 
	 * @param streetNumber the street number to be set
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * 
	 * Returns the house number of the house.
	 * 
	 * @return the house number of the house
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * 
	 * Sets the house number to the house.
	 * 
	 * @param houseNumber the house number to be set
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	/**
	 * 
	 * Returns the type of the property as "House".
	 * 
	 * @return the type of the property as "House"
	 */
	@Override
	public String getPropertyType() {
		return "House";
	}
	
	/**
	 * 
	 * Returns a string representation of the House object.
	 * 
	 * @return a string representation of the House object
	 */
	@Override
	public String toString() {
		return super.getPropertyId() + ". " + this.getPropertyType() + " #" +  this.getHouseNumber() + ", "
				+ this.getStreetNumber() + ", " + super.getStreetName() + ", " + super.getCity() + ", " + super.getProvince()
				+ ", " + super.getCountry() + ", " + super.getPostalCode();
	}
	
	/**
	 * 
	 * Returns the full address of the House object.
	 * 
	 * @return the full address of the House object
	 */
	@Override
	public String getFullAddress() {
		return this.getPropertyType() + " " + this.getHouseNumber() + ", " + this.getStreetNumber() + ", " + super.getStreetName() + ", " 
				+ super.getCity() + ", " + super.getProvince() + ", " + super.getCountry() + ", " + super.getPostalCode();
	}

}
