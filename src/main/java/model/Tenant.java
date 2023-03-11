package model;

/**
 * A class representing a tenant.
 */
public class Tenant {

	private static int nextTenantID = 1; // static variable to generate unique tenant IDs
	private int tenantID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	/**
	 * A constructor to create a tenant with the following details:
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 */
	public Tenant(String firstName, String lastName, String email, String phoneNumber) {
		this.tenantID = nextTenantID++; // generate a unique tenant ID
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	
	/**
	 * Returns the id of the tenant
	 * @return tenantID
	 */
	public int getTenantID() {
		return tenantID;
	}

	/**
	 * Returns the first name of the tenant
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the last name of the tenant
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Returns the email of the tenant
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the phone number of the tenant
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Returns a string representation of the Tenant object
	 */
	@Override
	public String toString() {
		return this.getTenantID() + ". " + this.getFirstName() + " " + this.getLastName() + "\n\tEmail: " + this.getEmail() + "\n\tPhone Number: " 
				+ this.getPhoneNumber();
	}
	
	
}
