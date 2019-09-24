package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GrafischeOberflaeche1.fxml")); //-----FXML File inportieren in diese Klasse. getClass() sagt this.Class. Der / beim Pfad ist um nach resources zu kommen
			Scene scene = new Scene(loader.load()); //----- Erstellen einer neuen Scene welche der Inport als Parameter erhält.
			primaryStage.setScene(scene); //----- Die Scene auf die Stage bringen und bereit legen.
			primaryStage.show(); // ------------- Die Stage zeigen und somit alles was drauf ist.

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
