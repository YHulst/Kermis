package kermisPackage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Kermis {
	ArrayList <Attractie> attracties;
	Kassa kassa;		
	
	Kermis(){
		attracties = new ArrayList();
		attracties.add(new Botsautos());
		attracties.add(new Spin());
		attracties.add(new Spiegelpaleis());
		attracties.add(new Spookhuis());
		attracties.add(new Hawaii());
		attracties.add(new Ladderklimmen());	
		kassa = new Kassa();
		System.out.print("Welkom op de kermis!");
	}

	void bezoeken(Kermis kermis){
		System.out.println("\n");
		System.out.println("Maak een keuze:");
		System.out.println("1 Ik wil in een attractie.");
		System.out.println("2 Ik wil informatie.");
		int antwoord = kermis.intInvoeren();
		while (antwoord !=1 && antwoord != 2) {
			System.out.println("Type 1 of 2: ");
			antwoord = kermis.intInvoeren();
		}
		if (antwoord == 1) {
			kermis.inAttractiegaan(kermis);
		} else if (antwoord == 2) {
			kermis.informatieGeven(kermis);
		}			
	}
	
	void informatieGeven(Kermis kermis) {
		String antwoord;
		do {
			System.out.println("Wat wil je weten?");
			System.out.println("- Voor informatie over de kaartverkoop: type 'k'.");
			System.out.println("- Voor informatie over de omzet: type 'o'. " );			
			antwoord = kermis.stringInvoeren();			
		} while(!(antwoord.equals("k")) && !(antwoord.equals("o")));	
		if (antwoord.equals("k")) {
			kermis.geefInfoKaartverkoop(kermis);
		} else if (antwoord.equals("o")) {
			kermis.geefInfoOmzet(kermis);
		}		
		kermis.bezoeken(kermis);
	}
	
	void geefInfoKaartverkoop(Kermis kermis) {
		System.out.print("Totale kaartverkoop: " + kermis.kassa.totaleKaartverkoop);
		if (kermis.kassa.totaleKaartverkoop == 1) { 
			System.out.println(" kaart.");
		} else {
			System.out.println(" kaarten.");
		}
		System.out.println("Kaartverkoop per attractie: ");
		int teller = -1;
		for (Attractie attractie : attracties) {
			teller++;
			System.out.print("- " + attracties.get(teller).getNaam());
			System.out.print(": " + attracties.get(teller).getKaartverkoopAttractie());
			if (attracties.get(teller).getKaartverkoopAttractie() == 1) {
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
		int teller = -1;
		for (Attractie attractie : attracties) {
			teller++;
			System.out.print("- " + attracties.get(teller).getNaam());			
			double omzet = attracties.get(teller).getOmzetAttractie();		
			System.out.println(": " + naarEuro.format(omzet) + ".");
		}
	}
	
	void inAttractiegaan(Kermis kermis) {
		System.out.println("Wij hebben de volgende attracties:");
		int teller = 0;
		for (Attractie attractie : attracties) {
			teller++;
			System.out.println(teller + " " + attracties.get(teller-1).getNaam());				
		}		
		int antwoord;		
		do {
			System.out.println("Type het nummer van de attractie waar je in wilt:");
			antwoord = kermis.intInvoeren();
		}
		while (antwoord != 1 && antwoord != 2 && antwoord != 3 && antwoord != 4 && antwoord != 5 && antwoord != 6); 		
		attracties.get(antwoord - 1).draaien();
		kassa.kasBijhouden(kermis, antwoord);		
		kermis.bezoeken(kermis);
	}			
	
	int intInvoeren() {
		 Scanner sc = new Scanner(System.in); 
	     return sc.nextInt();
	}
	
	String stringInvoeren() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}	
}