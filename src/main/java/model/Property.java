package model;

import java.util.ArrayList;

/**
 * A class representing a property.
 */
public abstract class Property {
	private static int nextPropertyId = 1;
	private int propertyId;
	private String streetName;
	private String city;
	private String postalCode;
	private String province;
	private String country;
	private int noOfBedrooms;
	private int noOfBathrooms;
	private double squareFootage;

	// A list of interested tenants for the Property instance.
	ArrayList<Tenant> interestedTenants;

	/**
	 * Creates a new Property object with the given parameters.
	 *
	 * @param streetName    the street name of the Property instance.
	 * @param city          the city of the Property instance.
	 * @param postalCode    the postal code of the Property instance.
	 * @param province      the province of the Property instance.
	 * @param country       the country of the Property instance.
	 * @param noOfBedrooms  the number of bedrooms of the Property instance.
	 * @param noOfBathrooms the number of bathrooms of the Property instance.
	 * @param squareFootage the square footage of the Property instance.
	 */
	public Property(String streetName, String city, String postalCode, String province, String country,
			int noOfBedrooms, int noOfBathrooms, double squareFootage) {
		this.propertyId = Property.nextPropertyId++;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.province = province;
		this.country = country;
		this.noOfBedrooms = noOfBedrooms;
		this.noOfBathrooms = noOfBathrooms;
		this.squareFootage = squareFootage;
		this.interestedTenants = new ArrayList<Tenant>();
	}

	/**
	 * Returns the unique ID of the Property instance.
	 *
	 * @return The unique ID of the Property instance.
	 */
	public int getPropertyId() {
		return propertyId;
	}

	/**
	 * Returns the street name of the Property instance.
	 *
	 * @return The street name of the Property instance.
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the street name of the Property instance to the given value.
	 *
	 * @param streetName The new street name of the Property instance.
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Returns the city of the Property instance.
	 *
	 * @return The city of the Property instance.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * Sets the city of the property.
	 * 
	 * @param city a String representing the city of the property
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * Returns the postal code of the property.
	 * 
	 * @return a String representing the postal code of the property
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * 
	 * Sets the postal code of the property.
	 * 
	 * @param postalCode a String representing the postal code of the property
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * 
	 * Returns the province of the property.
	 * 
	 * @return a String representing the province of the property
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 
	 * Sets the province of the property.
	 * 
	 * @param province a String representing the province of the property
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 
	 * Returns the country of the property.
	 * 
	 * @return a String representing the country of the property
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * Sets the country of the property.
	 * 
	 * @param country a String representing the country of the property
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * Returns the number of bedrooms of the property.
	 * 
	 * @return an int representing the number of bedrooms of the property
	 */
	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}

	/**
	 * 
	 * Sets the number of bedrooms of the property.
	 * 
	 * @param noOfBedrooms an int representing the number of bedrooms of the
	 *                     property
	 */
	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}

	/**
	 * 
	 * Returns the number of bathrooms of the property.
	 * 
	 * @return an int representing the number of bathrooms of the property
	 */
	public int getNoOfBathrooms() {
		return noOfBathrooms;
	}

	/**
	 * 
	 * Sets the number of bathrooms of the property.
	 * 
	 * @param noOfBathrooms an int representing the number of bathrooms of the
	 *                      property
	 */
	public void setNoOfBathrooms(int noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}

	/**
	 * 
	 * Returns the square footage of the property.
	 * 
	 * @return a double representing the square footage of the property
	 */
	public double getSquareFootage() {
		return squareFootage;
	}

	/**
	 * 
	 * Sets the square footage of the property.
	 * 
	 * @param squareFootage a double representing the square footage of the property
	 */
	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	/**
	 * 
	 * Returns the full address of the property.
	 * 
	 * @return a String representing the full address of the property
	 */
	public abstract String getFullAddress();

	/**
	 * 
	 * Returns the property type of the property.
	 * 
	 * @return a String representing the property type of the property
	 */
	public abstract String getPropertyType();

	/**
	 * 
	 * Returns an ArrayList of all tenants who have expressed interest in the
	 * property.
	 * 
	 * @return an ArrayList of all tenants who have expressed interest in the
	 *         property
	 */
	public ArrayList<Tenant> getAllInterestedTenants() {
		return interestedTenants;
	}

	/**
	 * 
	 * Adds a tenant to the list of interested tenants for the property.
	 * 
	 * @param tenant the tenant to add to the list of interested tenants for the
	 *               property
	 */
	public void addInterestedTenants(Tenant tenant) {
		interestedTenants.add(tenant);
	}

	/**
	 * 
	 * Removes a tenant to the list of interested tenants for the property.
	 * 
	 * @param tenant the tenant to remove to the list of interested tenants for the
	 *               property
	 */
	public void removeInterestedTenants(Tenant tenant) {
		interestedTenants.add(tenant);
	}

}
