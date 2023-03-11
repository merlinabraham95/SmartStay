package model;

/**
 * 
 * A class representing a Condo property that extends the Property class.
 */
public class Condo extends Property {

	private int unitNumber;
	private int streetNumber;

	/**
	 * 
	 * Creates a new Condo object with the given parameters.
	 * 
	 * @param streetName    the street name of the condo
	 * @param city          the city of the condo
	 * @param postalCode    the postal code of the condo
	 * @param province      the province of the condo
	 * @param country       the country of the condo
	 * @param noOfBedrooms  the number of bedrooms in the condo
	 * @param noOfBathrooms the number of bathrooms in the condo
	 * @param squareFootage the square footage of the condo
	 * @param unitNumber    the unit number of the condo
	 * @param streetNumber  the street number of the condo
	 */
	public Condo(String streetName, String city, String postalCode, String province, String country, int noOfBedrooms,
			int noOfBathrooms, int squareFootage, int unitNumber, int streetNumber) {
		super(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms, squareFootage);
		this.unitNumber = unitNumber;
		this.streetNumber = streetNumber;
	}

	/**
	 * 
	 * Returns the unit number of the condo.
	 * 
	 * @return the unit number of the condo
	 */
	public int getUnitNumber() {
		return unitNumber;
	}

	/**
	 * 
	 * Sets the unit number of the condo.
	 * 
	 * @param unitNumber the unit number to be set
	 */
	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}

	/**
	 * 
	 * Returns the street number of the condo.
	 * 
	 * @return the street number of the condo
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * 
	 * Sets the street number of the condo.
	 * 
	 * @param streetNumber the street number to be set
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * 
	 * Returns the type of the property as "Condo".
	 * 
	 * @return the type of the property as "Condo"
	 */
	@Override
	public String getPropertyType() {
		return "Condo";
	}

	/**
	 * 
	 * Returns a string representation of the Condo object.
	 * 
	 * @return a string representation of the Condo object
	 */
	@Override
	public String toString() {
		return super.getPropertyId() + ". " + this.getPropertyType() + " #" + this.getUnitNumber() + ", " + this.getStreetNumber()
				+ ", " + super.getStreetName() + ", " + super.getCity() + ", " + super.getProvince() + ", "
				+ super.getCountry() + ", " + super.getPostalCode();
	}

	/**
	 * 
	 * Returns the full address of the Condo object.
	 * 
	 * @return the full address of the Condo object
	 */
	@Override
	public String getFullAddress() {
		return this.getPropertyType() + " " + this.getUnitNumber() + ", " + this.getStreetNumber() + ", " + super.getStreetName() + ", " + super.getCity() + ", "
				+ super.getProvince() + ", " + super.getCountry() + ", " + super.getPostalCode();
	}
}
