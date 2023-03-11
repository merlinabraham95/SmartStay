package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controller.RentalController;
import model.Apartment;
import model.Condo;
import model.House;
import model.Lease;
import model.Property;
import model.PropertyBuilder;
import model.Tenant;

/**
 * The RentalView class represents the view of the SmartStay (rental management
 * system). It handles user input and displays information related to
 * properties, tenants, and rental units. It interacts with the RentalController
 * to perform operations on the model.
 */
public class RentalView {

	private RentalController controller;

	/**
	 * Creates a new RentalView with the given controller.
	 *
	 * @param controller the controller for the view to interact with
	 */
	public RentalView(RentalController controller) {
		this.controller = controller;
	}

	/**
	 * Displays the menu options for the rental management system.
	 */
	public void displayMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\t1. Add a property");
		System.out.println("\t2. Add a tenant");
		System.out.println("\t3. Rent a unit");
		System.out.println("\t4. Display properties");
		System.out.println("\t5. Display tenants");
		System.out.println("\t6. Display rented units");
		System.out.println("\t7. Display vacant units");
		System.out.println("\t8. Display all leases");
		System.out.println("\t9. Rent Payment Summary");
		System.out.println("\t10. Notify potential tenants");
		System.out.println("\t0. Exit");
	}

	/**
	 * Runs the rental management system. Handles user input and performs operations
	 * based on the input.
	 */
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		System.out.println("****SMART STAY RENTAL MANAGEMENT SYSTEM****\n");
		while (choice != 0) {
			displayMenu();
			System.out.print("\nEnter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addProperty(scanner);
				break;
			case 2:
				addTenant(scanner);
				break;
			case 3:
				rentUnit(scanner);
				break;
			case 4:
				displayProperties();
				break;
			case 5:
				displayTenants();
				break;
			case 6:
				displayRentedUnits();
				break;
			case 7:
				displayVacantUnits();
				break;
			case 8:
				displayAllLeases();
				break;
			case 9:
				displayRentSummary();
				break;
			case 10:
				notification();
				break;
			case 0:
				System.out.println("The application is now closed!");
				break;
			default:
				System.out.println("Invalid choice.\n");
			}
		}
	}

	/**
	 * Prompts the user to select a property type and adds the property to the
	 * model.
	 *
	 * @param scanner the scanner to read user input
	 */
	public void addProperty(Scanner scanner) {
		System.out.println("\nSelect property type: ");
		System.out.println("\t1. Apartment");
		System.out.println("\t2. Condo");
		System.out.println("\t3. House");
		System.out.print("\nEnter your choice: ");
		int propertyType = scanner.nextInt();
		scanner.nextLine();

		switch (propertyType) {
		case 1:
			addApartment(scanner);
			break;
		case 2:
			addCondo(scanner);
			break;
		case 3:
			addHouse(scanner);
			break;
		default:
			System.out.println("Invalid property type.\n");
		}
	}

	/**
	 * Prompts the user to enter details about an apartment and adds it to the
	 * model.
	 *
	 * @param scanner the scanner to read user input
	 */
	public void addApartment(Scanner scanner) {
		System.out.println("\nAPARTMENT DETAILS:");
		System.out.println("Enter the apartment number: ");
		int apartmentNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the street name: ");
		String streetName = scanner.nextLine();
		System.out.println("Enter the city: ");
		String city = scanner.nextLine();
		System.out.println("Enter the province: ");
		String province = scanner.nextLine();
		System.out.println("Enter the country: ");
		String country = scanner.nextLine();
		System.out.println("Enter the postal code: ");
		String postalCode = scanner.nextLine();
		System.out.println("Enter the number of bedrooms: ");
		int numBedrooms = scanner.nextInt();
		System.out.println("Enter the number of bathrooms: ");
		int numBathrooms = scanner.nextInt();
		System.out.println("Enter the square footage: ");
		int squareFootage = scanner.nextInt();
		Apartment apartment = new PropertyBuilder().withStreetName(streetName).withCity(city).withProvince(province)
				.withCountry(country).withPostalCode(postalCode).withApartmentNumber(apartmentNumber)
				.withNumBedrooms(numBedrooms).withNumBathrooms(numBathrooms).withSquareFootage(squareFootage)
				.buildApartment();
		controller.addProperty(apartment);
		System.out.println("Apartment added successfully to Smart Stay properties.\n");
	}

	/**
	 * Prompts the user to input details of a new Condo and adds it to the
	 * Controller's list of properties.
	 * 
	 * @param scanner a Scanner object used to receive input from the user
	 */
	public void addCondo(Scanner scanner) {
		System.out.println("\nCONDO DETAILS:");
		System.out.println("Enter the unit number: ");
		int unitNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the street name: ");
		String streetName = scanner.nextLine();
		System.out.println("Enter the city: ");
		String city = scanner.nextLine();
		System.out.println("Enter the province: ");
		String province = scanner.nextLine();
		System.out.println("Enter the country: ");
		String country = scanner.nextLine();
		System.out.println("Enter the postal code: ");
		String postalCode = scanner.nextLine();
		System.out.println("Enter the street number: ");
		int streetNumber = scanner.nextInt();
		scanner.nextLine(); // consume the new line character
		System.out.println("Enter the number of bedrooms: ");
		int numBedrooms = scanner.nextInt();
		System.out.println("Enter the number of bathrooms: ");
		int numBathrooms = scanner.nextInt();
		System.out.println("Enter the square footage: ");
		int squareFootage = scanner.nextInt();
		Condo condo = new PropertyBuilder().withStreetName(streetName).withCity(city).withProvince(province)
				.withCountry(country).withPostalCode(postalCode).withUnitNumber(unitNumber)
				.withStreetNumber(streetNumber).withNumBedrooms(numBedrooms).withNumBathrooms(numBathrooms)
				.withSquareFootage(squareFootage).buildCondo();
		controller.addProperty(condo);
		System.out.println("Condo added successfully to Smart Stay properties.\n");
	}

	/**
	 * Prompts the user to input details of a new House and adds it to the
	 * Controller's list of properties.
	 * 
	 * @param scanner a Scanner object used to receive input from the user
	 */
	public void addHouse(Scanner scanner) {
		System.out.println("\nHOUSE DETAILS:");
		System.out.println("Enter the house number: ");
		int houseNo = scanner.nextInt();
		System.out.println("Enter the street number: ");
		int streetNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the street name: ");
		String streetName = scanner.nextLine();
		System.out.println("Enter the city: ");
		String city = scanner.nextLine();
		System.out.println("Enter the province: ");
		String province = scanner.nextLine();
		System.out.println("Enter the country: ");
		String country = scanner.nextLine();
		System.out.println("Enter the postal code: ");
		String postalCode = scanner.nextLine();
		System.out.println("Enter the number of bedrooms: ");
		int numBedrooms = scanner.nextInt();
		System.out.println("Enter the number of bathrooms: ");
		int numBathrooms = scanner.nextInt();
		System.out.println("Enter the square footage: ");
		int squareFootage = scanner.nextInt();
		House house = new PropertyBuilder().withStreetNumber(streetNumber).withStreetName(streetName).withCity(city)
				.withProvince(province).withCountry(country).withPostalCode(postalCode).withHouseNumber(houseNo)
				.withNumBedrooms(numBedrooms).withNumBathrooms(numBathrooms).withSquareFootage(squareFootage)
				.buildHouse();
		controller.addProperty(house);
		System.out.println("House added successfully to Smart Stay properties.\n");
	}

	/**
	 * Prompts the user to input details of a new Tenant and adds it to the
	 * Controller's list of tenants.
	 * 
	 * @param scanner a Scanner object used to receive input from the user
	 */
	public void addTenant(Scanner scanner) {
		System.out.println("\nTENANT DETAILS:");
		System.out.print("Enter the first name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter the last name: ");
		String lastName = scanner.nextLine();

		System.out.print("Enter the phone number: ");
		String phoneNumber = scanner.nextLine();

		System.out.print("Enter the email: ");
		String email = scanner.nextLine();

		Tenant tenant = new Tenant(firstName, lastName, phoneNumber, email);
		controller.addTenant(tenant);
		System.out.println(
				"Hi " + tenant.getFirstName() + ",\nWelcome to SmartStay! Your rental ID is: " + tenant.getTenantID()
				+ ". You are successfully registered with us. "
				+ "Please remember to keep this ID for any future communication with our rental system.\n");
	}

	/**
	 * Prompts the user to select a Tenant and a Property, then adds a new Lease to
	 * the Controller's list of leases.
	 * 
	 * @param scanner a Scanner object used to receive input from the user
	 */
	public void rentUnit(Scanner scanner) {

		// drop down for tenant selection
		System.out.print("Enter the tenant ID: ");
		int tenantID = scanner.nextInt();
		scanner.nextLine();

		Tenant tenant = controller.getTenant(tenantID);
		if (tenant == null) {
			System.out.println("Invalid tenant ID.\n");
			return;
		}

		ArrayList<Property> properties = controller.getAllProperties();
		System.out.println("\nSelect a property to rent:");
		for (int i = 0; i < properties.size(); i++) {
			Property property = properties.get(i);
			System.out.println("\t" + property);
		}

		System.out.print("\nEnter your choice: ");
		int propertyChoice = scanner.nextInt();
		scanner.nextLine();

		if (propertyChoice < 1 || propertyChoice > properties.size()) {
			System.out.println("Invalid property selection.\n");
			return;
		}

		Property property = properties.get(propertyChoice - 1);

		System.out.print("Enter the lease start date (yyyy-MM-dd): ");
		String startDateStr = scanner.nextLine();
		LocalDate startDate = LocalDate.parse(startDateStr);

		System.out.print("Enter the lease end date (yyyy-MM-dd): ");
		String endDateStr = scanner.nextLine();
		LocalDate endDate = LocalDate.parse(endDateStr);


		ArrayList<Property> vacantProperties = controller.getVacantUnits();

		boolean isVacant = false;
		for (Property vacantProperty : vacantProperties) {
			if (vacantProperty.getPropertyId() == property.getPropertyId()) {
				isVacant = true;
				break;
			}
		}

		Lease coincidingLease = controller.getLeaseByPropertyAndDates(property, startDate, endDate);

		if (isVacant || coincidingLease != null) {

			// Check if there is an existing lease during the specified dates
			if (coincidingLease != null) {
				// Ask user if they want to change the lease data or exit
				System.out.println("\nThere is an existing lease for this property during the specified dates."
						+ "\nDates of coinciding lease : "+coincidingLease.getStartDate() + " to "+ coincidingLease.getEndDate());
				System.out.print("\n\nDo you want to change the lease data? (Y/N): ");
			
				String response = scanner.nextLine();
				if (response.equalsIgnoreCase("Y")) {

					System.out.print("Enter the new start date (yyyy-MM-dd): ");
					startDateStr = scanner.nextLine();
					startDate = LocalDate.parse(startDateStr);

					System.out.print("Enter the new end date (yyyy-MM-dd): ");
					endDateStr = scanner.nextLine();
					endDate = LocalDate.parse(endDateStr);
				}
				else {
					property.addInterestedTenants(tenant);
					System.out.println("Sorry this unit is rented out for the specified time line. \nThe tenant will be notified once the unit is available.\n");
					return;
				}
			}
			// Allow user to enter new lease data
			System.out.print("Enter the rent amount: ");
			double rentAmount = scanner.nextDouble();
			scanner.nextLine();
			Lease lease = new Lease(tenant, property, startDate, endDate, rentAmount);
			controller.addLease(lease);
			System.out.println("The tenant " + tenant.getFirstName() + " " + tenant.getLastName() + " has been successfully rented the unit at " 
					+ property.getFullAddress() + ".\n");
		} else {
			property.addInterestedTenants(tenant);
			System.out.println("Sorry this unit is rented out. The tenants will be notified once the unit is available.\n");
		}
	}

	/**
	 * Displays all properties by retrieving the list of properties from the
	 * controller and printing them to the console.
	 */
	public void displayProperties() {
		ArrayList<Property> properties = controller.getAllProperties();
		System.out.println("Here are all the Smart Stay properties:");
		for (Property property : properties) {
			System.out.println("\t" + property);
		}
		System.out.println();
	}

	/**
	 * Displays all tenants by retrieving the list of tenants from the controller
	 * and printing them to the console.
	 */
	public void displayTenants() {
		ArrayList<Tenant> tenants = controller.getAllTenants();
		System.out.println("Here are the tenants registered with Smart Stay:");
		for (Tenant tenant : tenants) {
			System.out.println("\t" + tenant);
		}
		System.out.println();
	}

	/**
	 * Displays all rented units by retrieving the list of leases from the
	 * controller and printing them to the console if the lease is still active.
	 */
	private void displayRentedUnits() {
		ArrayList<Lease> leases = controller.getAllLeases();
		System.out.println("Here are the rented units of Smart Stay:");
		int i = 1;
		for (Lease lease : leases) {
			if (!lease.isExpired()) {
				System.out.println("\t" + i + ". " + lease);
				i++;
			}
		}
	}

	/**
	 * Displays all vacant units by retrieving the list of properties from the
	 * controller that are currently vacant and printing them to the console.
	 */
	public void displayVacantUnits() {
		ArrayList<Property> properties = controller.getVacantUnits();
		System.out.println("Here are all the vacant properties of Smart Stay:");
		for (Property property : properties) {
			System.out.println("\t" + property);
		}
		System.out.println();
	}

	/**
	 * Displays all leases by retrieving the list of leases from the controller
	 * and printing them to the console.
	 */
	public void displayAllLeases() {
		ArrayList<Lease> leases = controller.getAllLeases();
		System.out.println("Here are all the leases give by Smart Stay:");
		for (Lease lease : leases) {
			System.out.println("\t" + lease);
		}
	}

	/**
	 * Sends notifications to all potential tenants of a property through the controller.
	 */
	public void notification() {
		HashMap<String, ArrayList<String>> propertyAndInterestedTenants = controller.notifyInterestedTenants();
		if (propertyAndInterestedTenants.isEmpty()) {
			System.out.println("No interested tenants were notified.\n");
		} else {
			for (Map.Entry<String, ArrayList<String>> entry : propertyAndInterestedTenants.entrySet()) {
				String propertyAddress = entry.getKey();
				ArrayList<String> interestedTenantNames = entry.getValue();
				System.out.println("Property: " + propertyAddress);
				int i = 1;
				for (String name : interestedTenantNames) {
					System.out.println("\t" + i + "." + name + " has been notified.");
				}
				System.out.println();
			}
		}
	}

	/**
	 * Displays the summary of all the paid and unpaid rents.
	 */
	public void displayRentSummary() {
		HashMap<String, ArrayList<String>> paidOrNotPaidAndTenants = controller.displayRentPaymentSummary();
		if (paidOrNotPaidAndTenants.isEmpty()) {
			System.out.println("No tenants found.\n");
		} 
		else {
			ArrayList<String> paidTenants = paidOrNotPaidAndTenants.get("PAID");
			ArrayList<String> unpaidTenants = paidOrNotPaidAndTenants.get("UNPAID");
			if(paidTenants == null)
				System.out.println("No tenants found who have paid the rent.");
			else {
				System.out.println("Tenants who paid the rent are: ");
				for(String tenant : paidTenants) {
					System.out.println("\t" + tenant);
				}
				System.out.println();
			}
			if(unpaidTenants == null)
				System.out.println("No tenants found who have not paid the rent.");
			else {
				System.out.println("Tenants who did not pay the rent are: ");
				for(String tenant : unpaidTenants) {
					System.out.println("\t" + tenant);
				}
				System.out.println();
			}
		}
	}
}