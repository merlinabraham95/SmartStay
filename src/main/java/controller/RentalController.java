package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import model.DatabaseUtility;
import model.Lease;
import model.Payment;
import model.Property;
import model.Tenant;

/**
 * The RentalController class represents the controller of the SmartStay (rental management
 * system). It handles the business logic for properties, tenants, and leases. 
 * It interacts with the model and the view.
 */
public class RentalController {

	private ArrayList<Property> properties;
	private ArrayList<Tenant> tenants;
	private ArrayList<Lease> leases;

	
	/**
	 * A constructor that gets the instances of tenants, properties and leases from the DatabaseUtility singleton class
	 */
	public RentalController() {
		DatabaseUtility databaseUtility = DatabaseUtility.getInstance();
		this.tenants = databaseUtility.getTenants();
		this.properties = databaseUtility.getProperties();
		this.leases = databaseUtility.getLeases();
	}

	/**
	 * Adds a property to the list of properties
	 * @param property
	 */
	public void addProperty(Property property) {
		properties.add(property);
	}

	/**
	 * Adds a tenant to the list of tenants
	 * @param tenant
	 */
	public void addTenant(Tenant tenant) {
		tenants.add(tenant);
	}
	
	/**
	 * Adds a lease to the leases
	 * @param lease
	 */
	public void addLease(Lease lease) {
		leases.add(lease);
	}

	/**
	 * Returns all the properties in the list
	 * @return properties
	 */
	public ArrayList<Property> getAllProperties() {
		return properties;
	}

	/**
	 * Returns all the tenants in the list
	 * @return tenants
	 */
	public ArrayList<Tenant> getAllTenants() {
		return tenants;
	}

	/**
	 * Returns all the leases in the list
	 * @return leases
	 */
	public ArrayList<Lease> getAllLeases() {
		return leases;
	}

	/**
	 * This method rents a unit based on the availability of the property. 
	 * If the property is available, a lease is created between the tenant and the property, otherwise a message is displayed stating that property is not available.
	 * @param property
	 * @param tenant
	 * @param startDate
	 * @param endDate
	 * @param rentAmount
	 */
	public void rentUnit(Property property, Tenant tenant, LocalDate startDate, LocalDate endDate, double rentAmount) {
		// Check if property is available
		boolean propertyAvailable = true;
		for (Lease lease : leases) {
			if (lease.getProperty() == property && !lease.isExpired()) {
				propertyAvailable = false;
				break;
			}
		}
		
		if (propertyAvailable) {
			Lease lease = new Lease(tenant, property, startDate, endDate, rentAmount);
			leases.add(lease);
		} else {
			// Property is already rented
			System.out.println("Sorry, the property is not available for rent.");
		}
	}

	/**
	 * This method returns the rented units
	 * @return rentedUnits
	 */
	public ArrayList<Lease> getRentedUnits() {
		ArrayList<Lease> rentedUnits = new ArrayList<>();
		for (Lease lease : leases) {
			if (!lease.isExpired()) {
				rentedUnits.add(lease);
			}
		}
		return rentedUnits;
	}

	/**
	 * This method returns the units that are available
	 * @return
	 */
	public ArrayList<Property> getVacantUnits() {
		ArrayList<Property> vacantUnits = new ArrayList<>();
		for (Property property : properties) {
			boolean propertyAvailable = true;
			for (Lease lease : leases) {
				if (lease.getProperty() == property && !lease.isExpired()) {
					propertyAvailable = false;
					break;
				}
			}
			if (propertyAvailable) {
				vacantUnits.add(property);
			}
		}
		return vacantUnits;
	}

	/**
	 * This method returns the tenant based on the tenant ID
	 * @param tenantID
	 * @return
	 */
	public Tenant getTenant(int tenantID) {
		for (Tenant tenant : tenants) {
			if (tenant.getTenantID() == tenantID) {
				return tenant;
			}
		}
		return null;
	}

	/**
	 * This method returns a hashmap containing the property and its interested tenants when the property becomes available
	 * @return propertyAndInterestedTenants
	 */
	public HashMap<String, ArrayList<String>> notifyInterestedTenants() {
		HashMap<String, ArrayList<String>> propertyAndInterestedTenants  = new HashMap<String, ArrayList<String>>();
		for(Lease lease : leases) {
			if(lease.isExpired()) {
				Property property = lease.getProperty();
				ArrayList<Tenant> interestedTenants = property.getAllInterestedTenants();
				if(!interestedTenants.isEmpty()) {
					ArrayList<String> interestedTenantNames = new ArrayList<String>();
					for (Tenant tenant : interestedTenants) {
						interestedTenantNames.add(tenant.getFirstName() + " " + tenant.getLastName());
					}
					propertyAndInterestedTenants.put(property.getFullAddress(), interestedTenantNames);
				}
			}
		}
		return propertyAndInterestedTenants;
	}

	/**
	 * This method returns whether rent payment was successful or not
	 * @param leaseID
	 * @param amountPaid
	 * @return true or false
	 */
	public boolean makeRentPayment(int leaseID, double amountPaid) {
		for(Lease lease : leases) {
			if(lease.getLeaseID() == leaseID) {
				Payment payment = new Payment(amountPaid, LocalDate.now());
				if(lease.getRentDue() - amountPaid < 0)
					lease.setRentDue(0);
				else lease.setRentDue(lease.getRentDue() - amountPaid);
				lease.addPayment(payment);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method returns the tenants who paid the rent and who did not
	 * @return paidOrNotPaidAndTenants
	 */
	public HashMap<String, ArrayList<String>> displayRentPaymentSummary() {
		ArrayList<String> paidTenants = new ArrayList<String>();
		ArrayList<String> unpaidTenants = new ArrayList<String>();
		for(Lease lease : leases) {
			if(lease.getRentDue() > 0) 
				unpaidTenants.add(lease.getTenant().getFirstName() + " " + lease.getTenant().getLastName() + ": " + lease.getProperty().getFullAddress());
			else paidTenants.add(lease.getTenant().getFirstName() + " " + lease.getTenant().getLastName() + ": " + lease.getProperty().getFullAddress());
		}

		HashMap<String, ArrayList<String>> paidOrNotPaidAndTenants = new HashMap<String, ArrayList<String>>();
		if(!paidTenants.isEmpty())
			paidOrNotPaidAndTenants.put("PAID", paidTenants);
		if(!unpaidTenants.isEmpty())
			paidOrNotPaidAndTenants.put("UNPAID", unpaidTenants);
		return paidOrNotPaidAndTenants;
	}
	
	public Lease getLeaseByPropertyAndDates(Property property, LocalDate startDate, LocalDate endDate) {
	    ArrayList<Lease> leases = getAllLeases();

	    for (Lease lease : leases) {
	        if (lease.getProperty().getPropertyId() == property.getPropertyId() && lease.getEndDate().isAfter(startDate) && lease.getStartDate().isBefore(endDate)) {
	            return lease;
	        }
	    }

	    return null;
	}
}
