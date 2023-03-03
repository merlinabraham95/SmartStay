class RentalView {


	private RentalController controller;

	public RentalView(RentalController controller) {
		this.controller = controller;
	}

	public void displayMenu() {
		System.out.println("1. Add a property");
		System.out.println("2. Add a tenant");
		System.out.println("3. Rent a unit");
		System.out.println("4. Display properties");
		System.out.println("5. Display tenants");
		System.out.println("6. Display rented units");
		System.out.println("7. Display vacant units");
		System.out.println("0. Exit");
	}

}


