package model;

/**
 * 
 * A class representing an Apartment property that extends the Property class.
 */
public class Apartment extends Property {

	private int apartmentNumber;

	/**
	 * 
	 * Creates a new Apartment object with the given parameters.
	 * 
	 * @param streetName      the street name of the apartment
	 * @param city            the city of the apartment
	 * @param postalCode      the postal code of the apartment
	 * @param province        the province of the apartment
	 * @param country         the country of the apartment
	 * @param noOfBedrooms    the number of bedrooms in the apartment
	 * @param noOfBathrooms   the number of bathrooms in the apartment
	 * @param squareFootage   the square footage of the apartment
	 * @param apartmentNumber the house number of the apartment
	 */
	public Apartment(String streetName, String city, String postalCode, String province, String country,
			int noOfBedrooms, int noOfBathrooms, int squareFootage, int apartmentNumber) {
		super(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms, squareFootage);
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * 
	 * Returns the apartment number of the apartment.
	 * 
	 * @return the apartment number of the apartment
	 */
	public int getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * 
	 * Sets the apartment number to the apartment.
	 * 
	 * @param apartmentNumber the apartment number to be set
	 */
	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * 
	 * Returns the type of the property as "Apartment".
	 * 
	 * @return the type of the property as "Apartment"
	 */
	@Override
	public String getPropertyType() {
		return "Apartment";
	}

	/**
	 * 
	 * Returns a string representation of the Apartment object.
	 * 
	 * @return a string representation of the Apartment object
	 */
	@Override
	public String toString() {
		return super.getPropertyId() + ". " + this.getPropertyType() + " #" + this.getApartmentNumber() + ", "
				+ super.getStreetName() + ", " + super.getCity() + ", " + super.getProvince() + ", "
				+ super.getCountry() + ", " + super.getPostalCode();
	}

	/**
	 * 
	 * Returns the full address of the Apartment object.
	 * 
	 * @return the full address of the Apartment object
	 */
	@Override
	public String getFullAddress() {
		return this.getPropertyType() + " " + this.getApartmentNumber() + ", " + super.getStreetName() + ", " 
				+ super.getCity() + ", " + super.getProvince() + ", " + super.getCountry() + ", " + super.getPostalCode();
	}
}
