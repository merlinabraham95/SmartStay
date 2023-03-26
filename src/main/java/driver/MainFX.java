package driver;

import controller.RentalController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.RentalViewFX;

public class MainFX extends Application {
	
	@Override
    public void start(Stage stage) {
      
        RentalController rentalController = new RentalController();
        RentalViewFX rentalViewFX = new RentalViewFX(rentalController);
        
        Label l = new Label("Hello, JavaFX ");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
