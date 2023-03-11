package driver;

import controller.RentalController;
import view.RentalView;

/**
 * Main class which is the entry point of the SmartStay application.
 */
public class Main {

	public static void main(String[] args) {

		RentalController rc = new RentalController();
		RentalView rv = new RentalView(rc);
		rv.run();
	}
}
