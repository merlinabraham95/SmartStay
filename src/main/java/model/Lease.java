package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * A class representing a lease between a tenant and a property.
 */
public class Lease {

	private static int nextLeaseID = 1;
	private int leaseID;
	private Tenant tenant;
	private Property property;
	private LocalDate startDate;
	private LocalDate endDate;
	private double rentAmount;
	private double rentDue;
	private ArrayList<Payment> allPayments;
	
	/**
	 * A constructor that creates a lease between a tenant and a property
	 * @param tenant
	 * @param property
	 * @param startDate
	 * @param endDate
	 * @param rentAmount
	 */
	public Lease(Tenant tenant, Property property, LocalDate startDate, LocalDate endDate, double rentAmount) {
		leaseID = Lease.nextLeaseID++;
		this.tenant = tenant;
		this.property = property;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentAmount = rentAmount;
		this.rentDue = rentAmount / Period.between(startDate, endDate).toTotalMonths();
		this.allPayments = new ArrayList<Payment>();
	}

	/**
	 * Returns the tenant associated with the lease
	 * @return tenant
	 */
	public Tenant getTenant() {
		return tenant;
	}

	/**
	 * Associates a tenant with a lease
	 * @param tenant
	 */
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	/**
	 * Returns the start date of the lease
	 * @return startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date of the lease
	 * @param startDate
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date of the lease
	 * @return endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date of the lease
	 * @param endDate
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the total rent amount for the lease period
	 * @return rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Sets the total rent amount for the lease period
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Returns the property associated with the lease
	 * @return property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * Associates the property with the lease
	 * @param property
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
	
	/**
	 * Returns the id of the lease
	 * @return leaseID
	 */
	public int getLeaseID() {
		return leaseID;
	}

	/**
	 * Returns the monthly rent due for the lease period
	 * @return rentDue
	 */
	public double getRentDue() {
		return Math.round(rentDue * 100.0) / 100.0;
	}

	/**
	 * Sets the monthly rent due for the lease period
	 * @param rentDue
	 */
	public void setRentDue(double rentDue) {
		this.rentDue = rentDue;
	}

	/**
	 * Returns all the payments made by the tenant towards the lease period
	 * @return allPayments
	 */
	public ArrayList<Payment> getAllPayments() {
		return allPayments;
	}

	/**
	 * Adds payment to all the payments made by the tenant towards the lease period
	 * @param payment
	 */
	public void addPayment(Payment payment) {
		allPayments.add(payment);
	}

	/**
	 * Checks if the lease is expired
	 * @return true or false
	 */
	public boolean isExpired() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.isAfter(endDate);
	}

	/**
	 * A string representation of the lease object.
	 */
	@Override
	public String toString() {
		return "Lease #" + this.getLeaseID() + "\n\tTenant: " + this.getTenant().getFirstName() + " " + this.getTenant().getLastName()
				+ "\n\tProperty: " + this.getProperty().getFullAddress() + "\n\tStart Date: " + this.getStartDate() + "\n\tEnd Date: "
				+ this.getEndDate() + "\n\tRent Amount: " + this.getRentAmount() + "\n\tRent Due: " + this.getRentDue() + "\n";
	}
}
