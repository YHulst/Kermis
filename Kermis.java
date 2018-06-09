package kermisPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Kermis {
	ArrayList <Attractie> attracties;
	Kassa kassa;	
	BelastingInspecteur inspecteur;
	
	Kermis(){
		attracties = new ArrayList();
		attracties.add(new Botsautos());
		attracties.add(new Spin());
		attracties.add(new Spiegelpaleis());
		attracties.add(new Spookhuis());
		attracties.add(new Hawaii());
		attracties.add(new Ladderklimmen());	
		kassa = new Kassa();
		inspecteur = new BelastingInspecteur();
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
	
	void inAttractiegaan(Kermis kermis) {	
		Attractie attractie = kermis.attractieKiezen(kermis);
		boolean draait = true;
		if (attractie instanceof RisicoRijkAttractie) {					
			kermis.checkKeuringGehad(attractie, kermis);			
			draait = kermis.checkDraailimiet(attractie);
		}
		
		if (draait) {
			attractie.draaien();
			kassa.kasBijhouden(attractie);	
			int randomNum = ThreadLocalRandom.current().nextInt(1, 16);
			if (randomNum == 1) {
				inspecteur.langskomen(kermis);
			}
		}			
		kermis.bezoeken(kermis);		
	}	
	
	Attractie attractieKiezen(Kermis kermis) {
		System.out.println("Wij hebben de volgende attracties:");	
		for (int t = 0 ; t < attracties.size() ; t++) {	
			System.out.println(t+1 + " " + attracties.get(t).getNaam());				
		}		
		int antwoord;		
		do {
			System.out.println("Type het nummer van de attractie waar je in wilt:");
			antwoord = kermis.intInvoeren();
		}
		while (antwoord != 1 && antwoord != 2 && antwoord != 3 && antwoord != 4 && antwoord != 5 && antwoord != 6); 
		return attracties.get(antwoord - 1);				
	}
	
	void checkKeuringGehad(Attractie attractie, Kermis kermis) {	
		if (((RisicoRijkAttractie) attractie).getGekeurd()) {
			return;
		} else if (((RisicoRijkAttractie) attractie).getGekeurd() == false) {
			String antwoord;
			do {
				System.out.println("Dit attractie moet eerst gekeurd worden. Type 'k' als de keuring klaar is.");
				antwoord = kermis.stringInvoeren();
			}while (!antwoord.equals("k"));
			((RisicoRijkAttractie) attractie).opstellingsKeuring();			}
	}
	
	boolean checkDraailimiet(Attractie attractie) {
		if (((RisicoRijkAttractie) attractie).getKeerGedraaid() >= ((RisicoRijkAttractie) attractie).getDraaiLimiet()) {
			System.out.println("De draailimiet van de " + attractie.getNaam() + " is overschreden.");			
			return false;
		}else {
			((RisicoRijkAttractie) attractie).setKeerGedraaid();
			System.out.println("keer gedraaid: " + ((RisicoRijkAttractie) attractie).getKeerGedraaid());
			System.out.println("draailimiet: " + ((RisicoRijkAttractie) attractie).getDraaiLimiet());
			return true;
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
			kermis.kassa.geefInfoKaartverkoop(kermis);
		} else if (antwoord.equals("o")) {
			kermis.kassa.geefInfoOmzet(kermis);
		}		
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