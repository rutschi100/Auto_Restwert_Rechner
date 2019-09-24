package application;



import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ElementControll {

	@FXML
	private TextField jetztigesJahr;
	
	@FXML
	private TextField jahrgangAuto;
	
	@FXML
	private TextField neuwertAuto;
	
	@FXML
	private TextField kilometerStand;
	
	@FXML
	Label antwortFeld;
	
	@FXML
	Label antwortFeld1;
	
	@FXML
	Label lblAktuell;
	
	@FXML
	Label lblVorhersage1;
	
	@FXML
	Label lblVorhersage2;
	
	@FXML
	Label lblVorhersage3;
	
	@FXML
	public void klickOnTheButton1() {
		// Alter Auto -------------------------
		
		int alterAuto = Rechnen.alterAuto(Integer.parseInt(jahrgangAuto.getText()), Integer.parseInt(jetztigesJahr.getText()));
		double wertVerlustNachZeit = Rechnen.wertVerlustNachZeit(alterAuto , Integer.parseInt(neuwertAuto.getText()));
		double kmWert = Rechnen.wertVerlustNachKM(Integer.parseInt(kilometerStand.getText()), Integer.parseInt(neuwertAuto.getText()));
		Double totalWert = Rechnen.totalWertRechnung(wertVerlustNachZeit, kmWert);
		DecimalFormat formatierer = new DecimalFormat("###,##0.00");
		String formatierterTotalWert = formatierer.format(new Double(totalWert));
		
		double vorhersagewert1Jahr = Rechnen.vorhersage(Integer.parseInt(kilometerStand.getText()), 1, Rechnen.alterAuto(Integer.parseInt(jahrgangAuto.getText()), Integer.parseInt(jetztigesJahr.getText())), Integer.parseInt(neuwertAuto.getText()));
		double vorhersagewert2Jahr = Rechnen.vorhersage(Integer.parseInt(kilometerStand.getText()), 2, Rechnen.alterAuto(Integer.parseInt(jahrgangAuto.getText()), Integer.parseInt(jetztigesJahr.getText())), Integer.parseInt(neuwertAuto.getText()));
		double vorhersagewert3Jahr = Rechnen.vorhersage(Integer.parseInt(kilometerStand.getText()), 3, Rechnen.alterAuto(Integer.parseInt(jahrgangAuto.getText()), Integer.parseInt(jetztigesJahr.getText())), Integer.parseInt(neuwertAuto.getText()));
		//auf Lbl setzen
		lblAktuell.setText(formatierterTotalWert+".-");
		String vorhersageString1 = formatierer.format(new Double(vorhersagewert1Jahr));
		String vorhersageString2 = formatierer.format(new Double(vorhersagewert2Jahr));
		String vorhersageString3 = formatierer.format(new Double(vorhersagewert3Jahr));
		lblVorhersage1.setText(vorhersageString1+".-");
		lblVorhersage2.setText(vorhersageString2+".-");
		lblVorhersage3.setText(vorhersageString3+".-");
		
//		wertAnzeigen(formatierterTotalWert);
	}
		
		
	@FXML
	private void initialize() {
		jetztigesJahr.setText(Integer.toString(Rechnen.getAktuellesJahr()));
	}
	
	public void wertAnzeigen(String derWert) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
//		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("Dein Motorfahrzeug hat den Wert von: "+derWert+".-");
		alert.showAndWait();
	}

	@FXML
	public void getInformation() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information zum Programm");
//		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("Dieser Motorfahrzeug Rechner beinhaltet die Rechnungsweise, die Versicherungen verwenden"
				+ " um auszurechnen wie viel Ihr Fahrzeug noch an Wert hat, im Falle  eines Totalschaden. \n \n"
				+ "Pro Jahr wird 10 Prozent vom aktuellen Wert abgezogen. Pro 10'000km werden 2 Prozent vom Neukaufpreis abgezogen. \n \n"
				+ "Die Voraussagung wurde erechnet anhand vom durchschnitts Kilometer, dass pro Jahr bisher gefahren wurde.");
		alert.showAndWait();
	}
	
	@FXML
	public void klickOnAbbrechen() {
		System.exit(0);;
	}
	
	@FXML
	public void klickOnClear() {
		jetztigesJahr.setText("");
		jahrgangAuto.setText("");
		neuwertAuto.setText("");
		kilometerStand.setText("");
//		antwortFeld1.setText("");
		lblVorhersage1.setText("");
		lblVorhersage2.setText("");
		lblVorhersage3.setText("");
		lblAktuell.setText("");
	}
	
	
	
	
}
