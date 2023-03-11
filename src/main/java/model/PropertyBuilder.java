package model;

/**
 * The PropertyBuilder class is a builder for creating different types of
 * properties.
 */
public class PropertyBuilder {

	private String streetName;
	private String city;
	private String postalCode;
	private String province;
	private String country;
	private int noOfBedrooms;
	private int noOfBathrooms;
	private int squareFootage;
	private int apartmentNumber;
	private int unitNumber;
	private int houseNumber;
	private int streetNumber;

	/**
	 * Sets the street name of the property.
	 * 
	 * @param streetName The street name to set.
	 * @return This PropertyBuilder instance.
	 */
	public PropertyBuilder withStreetName(String streetName) {
		this.streetName = streetName;
		return this;
	}

	/**
	 * Sets the city of the property.
	 * 
	 * @param city The city to set.
	 * @return This PropertyBuilder instance.
	 */
	public PropertyBuilder withCity(String city) {
		this.city = city;
		return this;
	}

	/**
	 * Sets the postal code of the property.
	 * 
	 * @param postalCode The postal code to set.
	 * @return This PropertyBuilder instance.
	 */
	public PropertyBuilder withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * Sets the province of the property.
	 * 
	 * @param province The province to set.
	 * @return This PropertyBuilder instance.
	 */
	public PropertyBuilder withProvince(String province) {
		this.province = province;
		return this;
	}

	/**
	 * Sets the country of the property.
	 * 
	 * @param country The country to set.
	 * @return This PropertyBuilder instance.
	 */
	public PropertyBuilder withCountry(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Sets the number of bedrooms in the property.
	 * 
	 * @param numBedrooms The number of bedrooms to set.
	 * @return This PropertyBuilder instance.
	 */
	public PropertyBuilder withNumBedrooms(int numBedrooms) {
		this.noOfBedrooms = numBedrooms;
		return this;
	}

	/**
	 * Sets the number of bathrooms in the property.
	 * 
	 * @param numBathrooms The number of bathrooms to set.
	 * @return This PropertyBuilder instance.
	 */
	public PropertyBuilder withNumBathrooms(int numBathrooms) {
		this.noOfBathrooms = numBathrooms;
		return this;
	}

	/**
	 * Sets the square footage of the property.
	 * 
	 * @param squareFootage The square footage to set.
	 * @return This PropertyBuilder
	 */

	public PropertyBuilder withSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
		return this;
	}

	/**
	 * This method sets the apartment number of the property being built.
	 * 
	 * @param apartmentNumber the apartment number to be set
	 * @return the PropertyBuilder object with the updated apartment number
	 */
	public PropertyBuilder withApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
		return this;
	}

	/**
	 * 
	 * Sets the unit number of the property.
	 * 
	 * @param unitNumber the unit number to set
	 * @return this PropertyBuilder instance
	 */
	public PropertyBuilder withUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
		return this;
	}

	/**
	 * Sets the house number of the property.
	 * 
	 * @param houseNumber the house number to be set
	 * @return the PropertyBuilder object with the updated house number
	 */
	public PropertyBuilder withHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}

	/**
	 * Sets the street number of the property.
	 * 
	 * @param streetNumber the street number to be set
	 * @return the PropertyBuilder object with the updated street number
	 */
	public PropertyBuilder withStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
		return this;
	}

	/**
	 * Builds an Apartment object with the current property attributes.
	 * 
	 * @return a new Apartment object with the current property attributes
	 */
	public Apartment buildApartment() {
		return new Apartment(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms,
				squareFootage, apartmentNumber);
	}

	/**
	 * Builds a Condo object with the current property attributes.
	 * 
	 * @return a new Condo object with the current property attributes
	 */
	public Condo buildCondo() {
		return new Condo(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms, squareFootage,
				unitNumber, streetNumber);
	}

	/**
	 * Builds a House object with the current property attributes.
	 * 
	 * @return a new House object with the current property attributes
	 */
	public House buildHouse() {
		return new House(streetName, city, postalCode, province, country, noOfBedrooms, noOfBathrooms, squareFootage,
				houseNumber, streetNumber);
	}

}
