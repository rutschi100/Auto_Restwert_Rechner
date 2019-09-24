package application;

import java.util.Calendar;

public class Rechnen {

	
	static int alterAuto(int JahrgangAuto, int JahrAktuell) {
		int erg = JahrAktuell-JahrgangAuto;
		return erg;
	}
	
	static double wertVerlustNachZeit(int alter, int neuwert) {
		double erg = neuwert;
		for (int i=0; i < alter; i++) {
			erg= (erg * 0.9);
		}
		return erg;
	}
	
	static double wertVerlustNachKM(int kmAngabe, int neuwert) {
		double erg = neuwert;
		int kmGerundet = (kmAngabe / 10000);
		double wertverlustAkm = ((neuwert / 100.0) * 2.0);
		erg= wertverlustAkm*kmGerundet;
		return erg;
	}
	
	static double totalWertRechnung(double wertNachZeit, double wertNachKM) {
		
		double erg = wertNachZeit - wertNachKM;
		
		return erg;
	}
	
	static int getAktuellesJahr() {
		Calendar cal = Calendar.getInstance();
		int jahr = cal.get(Calendar.YEAR);
		return jahr;
	}
	
	static double durchschnittKmImJahr(int km, int alter) {
		double erg = (km/alter);
		return erg;
	}
	
	static double vorhersage(int km, int jahrDerVorhersage, int alter, int neuwert) { //int km, int jahrDerVorhersage, int alter, int neuwert
		int vorhersageAlter = alter + jahrDerVorhersage;
		double derWert;
		double verlustZeit = wertVerlustNachZeit(vorhersageAlter, neuwert);
		double durchschnittKilometer = durchschnittKmImJahr(km, alter);
		int kmNachVorhersage  = (int)(durchschnittKilometer * vorhersageAlter); 
		double verlustKM = wertVerlustNachKM(kmNachVorhersage, neuwert);
		derWert = totalWertRechnung(verlustZeit, verlustKM);
//		derWert = (((neuwert-wertaktuell)/alter)*vorhersageAlter);
		
		
		return derWert;
	}
	
	
}
