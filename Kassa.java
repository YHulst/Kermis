package kermisPackage;

import java.text.NumberFormat;
import java.util.Locale;

class Kassa {
	int totaleKaartverkoop;
	double totaleOmzet;
	int aantalBezoekenInspecteur;
	double totaalIngehoudenBelasting;
	
	void kasBijhouden(Attractie attractie) {	
		attractie.setKaartverkoopAttractie();		
		totaleKaartverkoop ++;
		attractie.setOmzetAttractie();			
		totaleOmzet += attractie.getPrijs();
	}
	
	void geefInfoKaartverkoop(Kermis kermis) {
		System.out.print("Totale kaartverkoop: " + kermis.kassa.totaleKaartverkoop);
		if (kermis.kassa.totaleKaartverkoop == 1) { 
			System.out.println(" kaart.");
		} else {
			System.out.println(" kaarten.");
		}
		System.out.println("Kaartverkoop per attractie: ");
		for (int t = 0 ; t < kermis.attracties.size() ; t++) {
			System.out.print("- " + kermis.attracties.get(t).getNaam());
			System.out.print(": " + kermis.attracties.get(t).getKaartverkoopAttractie());
			if (kermis.attracties.get(t).getKaartverkoopAttractie() == 1) {
				System.out.println(" kaart.");
			} else {
				System.out.println(" kaarten.");	
			}
		}
	}	
	
	void geefInfoOmzet(Kermis kermis) {
		NumberFormat naarEuro = NumberFormat.getCurrencyInstance(Locale.getDefault());
		System.out.print("Totale omzet: " + naarEuro.format(kermis.kassa.totaleOmzet) + ". ");
		System.out.println("Omzet per attractie: ");
		for (int t = 0 ; t < kermis.attracties.size() ; t++) {
			System.out.print("- " + kermis.attracties.get(t).getNaam());			
			double omzet = kermis.attracties.get(t).getOmzetAttractie();		
			System.out.println(": " + naarEuro.format(omzet) + ".");
		}
		System.out.println("Aantal bezoeken belastinginspecteur: " + kermis.kassa.aantalBezoekenInspecteur + ".");
		System.out.println("Totaal ingehouden belasting: " + naarEuro.format(kermis.kassa.totaalIngehoudenBelasting) + ".");
	}	
}
