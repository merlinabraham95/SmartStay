package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import controller.RentalController;
import model.Apartment;
import model.Condo;
import model.House;
import model.Lease;
import model.Property;
import model.PropertyBuilder;
import model.Tenant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.StringConverter;

//import java.util.Scanner;

/**
 * The RentalView class represents the view of the SmartStay (rental management
 * system). It handles user input and displays information related to
 * properties, tenants, and rental units. It interacts with the RentalController
 * to perform operations on the model.
 */
public class RentalView extends Application {

	private RentalController controller;
	private Stage stage;

	public RentalView() {
		this.controller = new RentalController();
	}

	Image bannerImage = new Image("https://i.ibb.co/bbWLfbR/logo.jpg");
	ImageView bannerImageView = new ImageView(bannerImage);

	/**
	 * This method is an entry point for the JAVAFX application. It is the welcome
	 * screen which displays the menu in the form of action buttons.
	 */
	@Override
	public void start(Stage stage) {
		stage.setTitle("Welcome To SmartStay");
		this.stage = stage;

		bannerImageView.setFitWidth(400);
		bannerImageView.setPreserveRatio(true);
		Label label = new Label("What would you like to do?");
		label.setFont(Font.font("System", FontWeight.BOLD, 14));
		String[] buttonLabels = { "Add a property", "Add a tenant", "Rent a unit", "Display properties",
				"Display tenants", "Display rented units", "Display vacant units", "Display all leases",
				"Make Rent Payment", "Rent Payment Summary", "Notify potential tenants", "Exit" };

		List<Button> buttons = new ArrayList<>();
		for (String labels : buttonLabels) {
			Button button = new Button(labels);
			button.setPrefWidth(200);
			buttons.add(button);
		}

		buttons.get(0).setOnAction(e -> addProperty());
		buttons.get(1).setOnAction(e -> addTenant());
		buttons.get(2).setOnAction(e -> rentUnit());
		// buttons.get(3).setOnAction(e -> displayProperties());
		// buttons.get(4).setOnAction(e -> displayTenants());
		// buttons.get(5).setOnAction(e -> displayRentedUnits());
		// buttons.get(6).setOnAction(e -> displayVacantUnits());
		// buttons.get(7).setOnAction(e -> displayAllLeases());
		buttons.get(8).setOnAction(e -> payRent());
		// buttons.get(9).setOnAction(e -> displayRentSummary());
		// buttons.get(10).setOnAction(e -> notification());
		buttons.get(11).setOnAction(e -> stage.close());

		VBox vbox = new VBox(10, bannerImageView, label, buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3),
				buttons.get(4), buttons.get(5), buttons.get(6), buttons.get(7), buttons.get(8), buttons.get(9),
				buttons.get(10), buttons.get(11));
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #FFFFFF;");

		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Prompts the user to select a property type and adds the property
	 * (Apartment/Condo/House) to the model.
	 */
	public void addProperty() {
		stage.setTitle("Add Property");
		bannerImageView.setFitWidth(400);
		bannerImageView.setPreserveRatio(true);

		Label label1 = new Label("Select property type:");
		label1.setFont(Font.font("System", FontWeight.BOLD, 14));
		Button button1 = new Button("Apartment");
		button1.setPrefWidth(100);
		Button button2 = new Button("Condo");
		button2.setPrefWidth(100);
		Button button3 = new Button("House");
		button3.setPrefWidth(100);
		Button button4 = new Button("Back to Main Menu");
		button4.setPrefWidth(200);

		button1.setOnAction(e -> addApartment());
		button2.setOnAction(e -> addCondo());
		button3.setOnAction(e -> addHouse());
		button4.setOnAction(e -> start(stage));

		HBox hbox = new HBox(10, button1, button2, button3);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));

		HBox hbox2 = new HBox(button4);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setPadding(new Insets(10));

		VBox vbox = new VBox(10, bannerImageView, label1, hbox, hbox2);

		Label titleLabel = new Label("Customer Review:");
		titleLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

		Label reviewLabel1 = new Label(
				"\"I stay at a property which was listed on SmartStay and I couldn't be happier with my experience. The booking agents were quick and responsive, the property was exactly as described by the agent. The property was clean, comfortable, and had all the amenities I needed to get started. I highly recommend SmartStay to anyone looking for a hassle-free property rental.\"");
		reviewLabel1.setFont(Font.font("System", FontPosture.ITALIC, 14));
		reviewLabel1.setWrapText(true);

		Label reviewLabel2 = new Label("-Sam Smith");
		reviewLabel2.setFont(Font.font("System", FontWeight.NORMAL, 14));

		VBox reviewBox = new VBox(titleLabel, reviewLabel1, reviewLabel2);
		reviewBox.setAlignment(Pos.CENTER);
		reviewBox.setSpacing(5);

		reviewBox.setStyle(
				"-fx-background-color: #F5F5F5; -fx-padding: 10px; -fx-border-color: #A9A9A9; -fx-border-width: 1px;");

		vbox.getChildren().add(reviewBox);

		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #FFFFFF;");

		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);

	}

	/**
	 * Prompts the user to enter details about an apartment in the text fields and
	 * submit button to add apartment to the property.
	 */
	public void addApartment() {
		stage.setTitle("Add Apartment");
		bannerImageView.setFitWidth(400);
		bannerImageView.setPreserveRatio(true);
		Label label = new Label("\nAPARTMENT");
		label.setFont(Font.font("System", FontWeight.BOLD, 14));

		Label apartmentNumberLabel = new Label("Apartment Number:");
		TextField apartmentNumberField = new TextField();

		Label streetNameLabel = new Label("Street Name:");
		TextField streetNameField = new TextField();

		Label cityLabel = new Label("City:");
		TextField cityField = new TextField();

		Label provinceLabel = new Label("Province:");
		TextField provinceField = new TextField();

		Label countryLabel = new Label("Country:");
		TextField countryField = new TextField();

		Label postalCodeLabel = new Label("Postal Code:");
		TextField postalCodeField = new TextField();

		Label numBedroomsLabel = new Label("Number of Bedrooms:");
		TextField numBedroomsField = new TextField();

		Label numBathroomsLabel = new Label("Number of Bathrooms:");
		TextField numBathroomsField = new TextField();

		Label squareFootageLabel = new Label("Square Footage:");
		TextField squareFootageField = new TextField();

		Button submitButton = new Button("Submit");
		submitButton.setPrefWidth(150);
		submitButton.setOnAction(e -> {
			try {
				int apartmentNumber = Integer.parseInt(apartmentNumberField.getText());
				String streetName = streetNameField.getText();
				String city = cityField.getText();
				String province = provinceField.getText();
				String country = countryField.getText();
				String postalCode = postalCodeField.getText();
				int numBedrooms = Integer.parseInt(numBedroomsField.getText());
				int numBathrooms = Integer.parseInt(numBathroomsField.getText());
				int squareFootage = Integer.parseInt(squareFootageField.getText());

				if (apartmentNumberField.getText().isEmpty() || streetName.isEmpty() || city.isEmpty()
						|| province.isEmpty() || country.isEmpty() || postalCode.isEmpty()
						|| numBedroomsField.getText().isEmpty() || numBathroomsField.getText().isEmpty()
						|| squareFootageField.getText().isEmpty()) {
					throw new IllegalArgumentException("Please fill in all required fields.");
				}

				Apartment apartment = new PropertyBuilder().withStreetName(streetName).withCity(city)
						.withProvince(province).withCountry(country).withPostalCode(postalCode)
						.withApartmentNumber(apartmentNumber).withNumBedrooms(numBedrooms)
						.withNumBathrooms(numBathrooms).withSquareFootage(squareFootage).buildApartment();
				controller.addProperty(apartment);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Apartment details have been successfully added.");

				ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
				alert.getButtonTypes().setAll(okButton);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == okButton) {
					addProperty();
				}

			} catch (NumberFormatException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Please fill in all required fields with valid inputs.");
				alert.showAndWait();
			} catch (IllegalArgumentException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		});
		Button button = new Button("Back to Property");
		button.setOnAction(e -> addProperty());
		button.setPrefWidth(150);
		HBox hbox = new HBox(10, submitButton, button);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.addRow(1, apartmentNumberLabel, apartmentNumberField);
		gridPane.addRow(2, streetNameLabel, streetNameField);
		gridPane.addRow(3, cityLabel, cityField);
		gridPane.addRow(4, provinceLabel, provinceField);
		gridPane.addRow(5, countryLabel, countryField);
		gridPane.addRow(6, postalCodeLabel, postalCodeField);
		gridPane.addRow(7, numBedroomsLabel, numBedroomsField);
		gridPane.addRow(8, numBathroomsLabel, numBathroomsField);
		gridPane.addRow(9, squareFootageLabel, squareFootageField);
		gridPane.add(hbox, 0, 11, 2, 1);
		gridPane.setAlignment(Pos.CENTER);

		VBox vbox = new VBox();
		vbox.getChildren().addAll(bannerImageView, label, gridPane);

		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #FFFFFF;");

		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);
	}

	/**
	 * Prompts the user to enter details about a condo in the text fields and submit
	 * button to add condo to the property.
	 */
	public void addCondo() {
		stage.setTitle("Add Condo");
		bannerImageView.setFitWidth(400);
		bannerImageView.setPreserveRatio(true);
		Label label = new Label("\nCONDO");
		label.setFont(Font.font("System", FontWeight.BOLD, 14));

		Label unitNumberLabel = new Label("Unit Number:");
		TextField unitNumberField = new TextField();

		Label streetNameLabel = new Label("Street Name:");
		TextField streetNameField = new TextField();

		Label streetNumberLabel = new Label("Street Number:");
		TextField streetNumberField = new TextField();

		Label cityLabel = new Label("City:");
		TextField cityField = new TextField();

		Label provinceLabel = new Label("Province:");
		TextField provinceField = new TextField();

		Label countryLabel = new Label("Country:");
		TextField countryField = new TextField();

		Label postalCodeLabel = new Label("Postal Code:");
		TextField postalCodeField = new TextField();

		Label numBedroomsLabel = new Label("Number of Bedrooms:");
		TextField numBedroomsField = new TextField();

		Label numBathroomsLabel = new Label("Number of Bathrooms:");
		TextField numBathroomsField = new TextField();

		Label squareFootageLabel = new Label("Square Footage:");
		TextField squareFootageField = new TextField();

		Button submitButton = new Button("Submit");
		submitButton.setPrefWidth(150);
		submitButton.setOnAction(e -> {
			try {
				int unitNumber = Integer.parseInt(unitNumberField.getText());
				String streetName = streetNameField.getText();
				int streetNumber = Integer.parseInt(streetNumberField.getText());
				String city = cityField.getText();
				String province = provinceField.getText();
				String country = countryField.getText();
				String postalCode = postalCodeField.getText();
				int numBedrooms = Integer.parseInt(numBedroomsField.getText());
				int numBathrooms = Integer.parseInt(numBathroomsField.getText());
				int squareFootage = Integer.parseInt(squareFootageField.getText());

				if (unitNumberField.getText().isEmpty() || streetName.isEmpty() || city.isEmpty()
						|| streetNumberField.getText().isEmpty() || province.isEmpty() || country.isEmpty()
						|| postalCode.isEmpty() || numBedroomsField.getText().isEmpty()
						|| numBathroomsField.getText().isEmpty() || squareFootageField.getText().isEmpty()) {
					throw new IllegalArgumentException("Please fill in all required fields.");
				}

				Condo condo = new PropertyBuilder().withStreetName(streetName).withCity(city)
						.withStreetNumber(streetNumber).withProvince(province).withCountry(country)
						.withPostalCode(postalCode).withUnitNumber(unitNumber).withNumBedrooms(numBedrooms)
						.withNumBathrooms(numBathrooms).withSquareFootage(squareFootage).buildCondo();
				controller.addProperty(condo);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Condo details have been successfully added.");

				ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
				alert.getButtonTypes().setAll(okButton);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == okButton) {
					addProperty();
				}

			} catch (NumberFormatException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Please fill in all required fields with valid inputs.");
				alert.showAndWait();
			} catch (IllegalArgumentException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		});
		Button button = new Button("Back to Property");
		button.setOnAction(e -> addProperty());
		button.setPrefWidth(150);
		HBox hbox = new HBox(10, submitButton, button);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.addRow(1, unitNumberLabel, unitNumberField);
		gridPane.addRow(2, streetNumberLabel, streetNumberField);
		gridPane.addRow(3, streetNameLabel, streetNameField);
		gridPane.addRow(4, cityLabel, cityField);
		gridPane.addRow(5, provinceLabel, provinceField);
		gridPane.addRow(6, countryLabel, countryField);
		gridPane.addRow(7, postalCodeLabel, postalCodeField);
		gridPane.addRow(8, numBedroomsLabel, numBedroomsField);
		gridPane.addRow(9, numBathroomsLabel, numBathroomsField);
		gridPane.addRow(10, squareFootageLabel, squareFootageField);
		gridPane.add(hbox, 0, 12, 2, 1);
		gridPane.setAlignment(Pos.CENTER);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(bannerImageView, label, gridPane);

		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #FFFFFF;");

		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);
	}

	/**
	 * Prompts the user to enter details about a house in the text fields and submit
	 * button to add house to the property.
	 */
	public void addHouse() {
		stage.setTitle("Add House");
		bannerImageView.setFitWidth(400);
		bannerImageView.setPreserveRatio(true);

		Label label = new Label("\nHOUSE");
		label.setFont(Font.font("System", FontWeight.BOLD, 14));

		Label houseNumberLabel = new Label("House Number:");
		TextField houseNumberField = new TextField();

		Label streetNameLabel = new Label("Street Name:");
		TextField streetNameField = new TextField();

		Label streetNumberLabel = new Label("Street Number:");
		TextField streetNumberField = new TextField();

		Label cityLabel = new Label("City:");
		TextField cityField = new TextField();

		Label provinceLabel = new Label("Province:");
		TextField provinceField = new TextField();

		Label countryLabel = new Label("Country:");
		TextField countryField = new TextField();

		Label postalCodeLabel = new Label("Postal Code:");
		TextField postalCodeField = new TextField();

		Label numBedroomsLabel = new Label("Number of Bedrooms:");
		TextField numBedroomsField = new TextField();

		Label numBathroomsLabel = new Label("Number of Bathrooms:");
		TextField numBathroomsField = new TextField();

		Label squareFootageLabel = new Label("Square Footage:");
		TextField squareFootageField = new TextField();

		Button submitButton = new Button("Submit");
		submitButton.setPrefWidth(150);
		submitButton.setOnAction(e -> {
			try {
				int houseNumber = Integer.parseInt(houseNumberField.getText());
				String streetName = streetNameField.getText();
				int streetNumber = Integer.parseInt(streetNumberField.getText());
				String city = cityField.getText();
				String province = provinceField.getText();
				String country = countryField.getText();
				String postalCode = postalCodeField.getText();
				int numBedrooms = Integer.parseInt(numBedroomsField.getText());
				int numBathrooms = Integer.parseInt(numBathroomsField.getText());
				int squareFootage = Integer.parseInt(squareFootageField.getText());

				if (houseNumberField.getText().isEmpty() || streetName.isEmpty() || city.isEmpty()
						|| streetNumberField.getText().isEmpty() || province.isEmpty() || country.isEmpty()
						|| postalCode.isEmpty() || numBedroomsField.getText().isEmpty()
						|| numBathroomsField.getText().isEmpty() || squareFootageField.getText().isEmpty()) {
					throw new IllegalArgumentException("Please fill in all required fields.");
				}

				House house = new PropertyBuilder().withStreetName(streetName).withCity(city)
						.withStreetNumber(streetNumber).withProvince(province).withCountry(country)
						.withPostalCode(postalCode).withHouseNumber(houseNumber).withNumBedrooms(numBedrooms)
						.withNumBathrooms(numBathrooms).withSquareFootage(squareFootage).buildHouse();
				controller.addProperty(house);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("House details have been successfully added.");

				ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
				alert.getButtonTypes().setAll(okButton);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == okButton) {
					addProperty();
				}

			} catch (NumberFormatException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Please fill in all required fields with valid inputs.");
				alert.showAndWait();
			} catch (IllegalArgumentException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		});
		Button button = new Button("Back to Property");
		button.setOnAction(e -> addProperty());
		button.setPrefWidth(150);
		HBox hbox = new HBox(10, submitButton, button);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.addRow(1, houseNumberLabel, houseNumberField);
		gridPane.addRow(2, streetNumberLabel, streetNumberField);
		gridPane.addRow(3, streetNameLabel, streetNameField);
		gridPane.addRow(4, cityLabel, cityField);
		gridPane.addRow(5, provinceLabel, provinceField);
		gridPane.addRow(6, countryLabel, countryField);
		gridPane.addRow(7, postalCodeLabel, postalCodeField);
		gridPane.addRow(8, numBedroomsLabel, numBedroomsField);
		gridPane.addRow(9, numBathroomsLabel, numBathroomsField);
		gridPane.addRow(10, squareFootageLabel, squareFootageField);
		gridPane.add(hbox, 0, 12, 2, 1);
		gridPane.setAlignment(Pos.CENTER);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(bannerImageView, label, gridPane);

		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #FFFFFF;");

		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);
	}
	
	/**
	 * Prompts the user to enter details for a tenant and register the tenant to the system.
	 */
	public void addTenant() {
		stage.setTitle("Add Tenant");
		bannerImageView.setFitWidth(400);
		bannerImageView.setPreserveRatio(true);

		Label label = new Label("\nTENANT DETAILS");
		label.setFont(Font.font("System", FontWeight.BOLD, 14));

		Label firstNameLabel = new Label("First Name:");
		TextField firstNameField = new TextField();

		Label lastNameLabel = new Label("Last Name:");
		TextField lastNameField = new TextField();

		Label phoneNumberLabel = new Label("Phone Number:");
		TextField phoneNumberField = new TextField();

		Label emailLabel = new Label("Email:");
		TextField emailField = new TextField();

		Button submitButton = new Button("Submit");
		submitButton.setPrefWidth(150);
		submitButton.setOnAction(e -> {
			try {
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String phoneNumber = phoneNumberField.getText();
				String email = emailField.getText();

				if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
					throw new IllegalArgumentException("Please fill in all required fields.");
				}
				
				Tenant tenant = new Tenant(firstName, lastName, phoneNumber, email);
				controller.addTenant(tenant);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Hi " + tenant.getFirstName() + ",\nWelcome to SmartStay! Your rental ID is: "
						+ tenant.getTenantID() + ".\nYou are successfully registered with us. "
						+ "Please remember to keep this ID for any future communication.");

				ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
				alert.getButtonTypes().setAll(okButton);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == okButton) {
					start(stage);
				}

			} catch (IllegalArgumentException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		});
		Button button = new Button("Back to Main Menu");
		button.setOnAction(e -> start(stage));
		button.setPrefWidth(150);
		HBox hbox = new HBox(10, submitButton, button);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.addRow(1, firstNameLabel, firstNameField);
		gridPane.addRow(2, lastNameLabel, lastNameField);
		gridPane.addRow(3, phoneNumberLabel, phoneNumberField);
		gridPane.addRow(4, emailLabel, emailField);
		gridPane.add(hbox, 0, 7, 2, 1);
		gridPane.setAlignment(Pos.CENTER);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(bannerImageView, label, gridPane);

		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #FFFFFF;");

		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);
	}

	public void rentUnit() {
		stage.setTitle("Unit Rental");
		bannerImageView.setFitWidth(400);
		bannerImageView.setPreserveRatio(true);

		Label label = new Label("RENT A UNIT\n");
		label.setFont(Font.font("System", FontWeight.BOLD, 14));

		Label tenantLabel = new Label("Tenant ID:");
		TextField tenantTextField = new TextField();

		Label propertyLabel = new Label("Select a property:");
		ChoiceBox<String> propertyChoiceBox = new ChoiceBox<>();
		ArrayList<Property> properties = controller.getAllProperties();
		for (int i = 0; i < properties.size(); i++) {
			Property property = properties.get(i);
			propertyChoiceBox.getItems().add(property.toString());
		}

		Label startDateLabel = new Label("Lease start date:");
		DatePicker startDatePicker = new DatePicker();
		startDatePicker.setConverter(new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			@Override
			public String toString(LocalDate date) {
				return date != null ? dateFormatter.format(date) : "";
			}

			@Override
			public LocalDate fromString(String string) {
				return string != null && !string.isEmpty() ? LocalDate.parse(string, dateFormatter) : null;
			}
		});

		Label endDateLabel = new Label("Lease end date:");
		DatePicker endDatePicker = new DatePicker();
		endDatePicker.setConverter(new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			@Override
			public String toString(LocalDate date) {
				return date != null ? dateFormatter.format(date) : "";
			}

			@Override
			public LocalDate fromString(String string) {
				return string != null && !string.isEmpty() ? LocalDate.parse(string, dateFormatter) : null;
			}
		});

		Label rentAmountLabel = new Label("Rental amount (CAD):");
		TextField rentAmountTextField = new TextField();

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);

		Button submitButton = new Button("Submit");
		submitButton.setPrefWidth(150);
		Button button = new Button("Back to Main Menu");
		button.setOnAction(e -> start(stage));
		button.setPrefWidth(150);
		HBox hbox = new HBox(10, submitButton, button);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.addRow(1, tenantLabel, tenantTextField);
		gridPane.addRow(2, propertyLabel, propertyChoiceBox);
		gridPane.addRow(3, startDateLabel, startDatePicker);
		gridPane.addRow(4, endDateLabel, endDatePicker);
		gridPane.addRow(5, rentAmountLabel, rentAmountTextField);
		gridPane.add(hbox, 0, 7, 2, 1);
		gridPane.setAlignment(Pos.CENTER);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(bannerImageView, label, gridPane);

		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #FFFFFF;");

		Scene scene = new Scene(vbox, 500, 700);
		stage.setScene(scene);

	}
	
	/**
	 * Prompts the user to enter details for rent payment and pay the rent.
	 */
	public void payRent() {
		
		ArrayList<Lease> leases = controller.getAllLeases();
		if(leases.isEmpty()) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("No lease records found for which payment can be made.");

			ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
			alert.getButtonTypes().setAll(okButton);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == okButton) {
				start(stage);
			}
		}
		
		else {
			stage.setTitle("Pay Rent");
			bannerImageView.setFitWidth(400);
			bannerImageView.setPreserveRatio(true);
	
			Label label = new Label("\nRENT PAYMENT");
			label.setFont(Font.font("System", FontWeight.BOLD, 14));
	
			Label leaseIDLabel = new Label("Lease ID:");
			TextField leaseIDField = new TextField();
	
			Label amountLabel = new Label("Amount:");
			TextField amountField = new TextField();
	
			Button submitButton = new Button("Submit");
			submitButton.setPrefWidth(150);
			submitButton.setOnAction(e -> {
				try {				
					if (leaseIDField.getText().isEmpty() || amountField.getText().isEmpty()) {
						throw new IllegalArgumentException("Please fill in all required fields.");
					}
					
					int leaseID = Integer.parseInt(leaseIDField.getText());
					double amount = Double.parseDouble(amountField.getText());
					
					boolean rentPaid = controller.makeRentPayment(leaseID, amount);
					
					if(rentPaid) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation");
						alert.setHeaderText("Rent payment is successful!");
	
						ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
						alert.getButtonTypes().setAll(okButton);
	
						Optional<ButtonType> result = alert.showAndWait();
						if (result.isPresent() && result.get() == okButton) {
							start(stage);
						}
					}
					else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("No active lease found.");
	
						ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
						alert.getButtonTypes().setAll(okButton);
	
						Optional<ButtonType> result = alert.showAndWait();
						if (result.isPresent() && result.get() == okButton) {
							start(stage);
						}
					}
					
				} catch (NumberFormatException ex) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("Please fill in all required fields with valid inputs.");
					alert.showAndWait();
				} catch (IllegalArgumentException ex) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText(ex.getMessage());
					alert.showAndWait();
				}
			});
			Button button = new Button("Back to Main Menu");
			button.setOnAction(e -> start(stage));
			button.setPrefWidth(150);
			HBox hbox = new HBox(10, submitButton, button);
			hbox.setAlignment(Pos.CENTER);
			hbox.setPadding(new Insets(10));
			GridPane gridPane = new GridPane();
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.addRow(1, leaseIDLabel, leaseIDField);
			gridPane.addRow(2, amountLabel, amountField);
			gridPane.add(hbox, 0, 5, 2, 1);
			gridPane.setAlignment(Pos.CENTER);
			VBox vbox = new VBox();
			vbox.getChildren().addAll(bannerImageView, label, gridPane);
	
			vbox.setPadding(new Insets(10));
			vbox.setAlignment(Pos.CENTER);
			vbox.setStyle("-fx-background-color: #FFFFFF;");
	
			Scene scene = new Scene(vbox, 500, 700);
			stage.setScene(scene);
		}
	}
}

//	/**
//	 * Prompts the user to select a Tenant and a Property, then adds a new Lease to
//	 * the Controller's list of leases.
//	 * 
//	 * @param scanner a Scanner object used to receive input from the user
//	 */

//
//	/**
//	 * Displays all rented units by retrieving the list of leases from the
//	 * controller and printing them to the console if the lease is still active.
//	 */
//	private void displayRentedUnits() {
//		ArrayList<Lease> leases = controller.getAllLeases();
//		if (leases.isEmpty()) {
//			System.out.println("No rented unit records to display");
//		} else {
//			System.out.println("List of rented units: ");
//			int i = 1;
//			for (Lease lease : leases) {
//				if (!lease.isExpired()) {
//					System.out.println("\t" + i + ". " + lease);
//					i++;
//				}
//			}
//		}
//	}
//
//	/**
//	 * Displays all vacant units by retrieving the list of properties from the
//	 * controller that are currently vacant and printing them to the console.
//	 */
//	public void displayVacantUnits() {
//		ArrayList<Property> properties = controller.getVacantUnits();
//		if (properties.isEmpty()) {
//			System.out.println("No vacant unit records to display.");
//		} else {
//			System.out.println("List of vacant properties: ");
//			for (Property property : properties) {
//				System.out.println("\t" + property);
//			}
//		}
//		System.out.println();
//	}
//
//	/**
//	 * Displays all leases by retrieving the list of leases from the controller and
//	 * printing them to the console.
//	 */
//	public void displayAllLeases() {
//		ArrayList<Lease> leases = controller.getAllLeases();
//		if (leases.isEmpty()) {
//			System.out.println("No active lease records to display.");
//		} else {
//			System.out.println("List of leases:");
//			for (Lease lease : leases) {
//				System.out.println("\t" + lease);
//			}
//		}
//	}
//
//	/**
//	 * Sends notifications to all potential tenants of a property through the
//	 * controller.
//	 */
//	public void notification() {
//		HashMap<String, ArrayList<String>> propertyAndInterestedTenants = controller.notifyInterestedTenants();
//		if (propertyAndInterestedTenants.isEmpty()) {
//			System.out.println("No potential tenant records found.\n");
//		} else {
//			for (Map.Entry<String, ArrayList<String>> entry : propertyAndInterestedTenants.entrySet()) {
//				String propertyAddress = entry.getKey();
//				ArrayList<String> interestedTenantNames = entry.getValue();
//				System.out.println("Property: " + propertyAddress);
//				int i = 1;
//				for (String name : interestedTenantNames) {
//					System.out.println("\t" + i + "." + name + " has been notified.");
//				}
//				System.out.println();
//			}
//		}
//	}
