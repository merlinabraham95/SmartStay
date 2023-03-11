package model;

import java.util.ArrayList;

public class DatabaseUtility {

	private static DatabaseUtility instance;
	private ArrayList<Property> properties;
	private ArrayList<Tenant> tenants;
	private ArrayList<Lease> leases;
	private ArrayList<Lease> expiredLeases;
	
    private DatabaseUtility() {
    	this.properties = new ArrayList<>();
		this.tenants = new ArrayList<>();
		this.leases = new ArrayList<>();
		this.expiredLeases = new ArrayList<>();
    }

    public static DatabaseUtility getInstance() {
        if (instance == null) {
            instance = new DatabaseUtility();
        }
        return instance;
    }
    
	public ArrayList<Property> getProperties() {
		return properties;
	}

	public ArrayList<Tenant> getTenants() {
		return tenants;
	}

	public ArrayList<Lease> getLeases() {
		return leases;
	}
	
	public ArrayList<Lease> getExpiredLeases() {
		return expiredLeases;
	}

}
