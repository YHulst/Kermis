package kermisPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Kermis {
	ArrayList <Attractie> attracties;
	
	
	
	Kermis(){
		attracties = new ArrayList();
		attracties.add(new Botsautos());
		attracties.add(new Spin());
		attracties.add(new Spiegelpaleis());
		attracties.add(new Spookhuis());
		attracties.add(new Hawaii());
		attracties.add(new Ladderklimmen());		
	}

	void bezoeken(Kermis kermis){
		kermis.toonMenu();
		int antwoord;		
		do {
			System.out.println("Type het nummer van de attractie waar je in wilt:");
			antwoord = kermis.invoeren();
		}
		while (antwoord != 1 && antwoord != 2 && antwoord != 3 && antwoord != 4 && antwoord != 5 && antwoord != 6); 
		for (Attractie attractie : attracties) {
			if (antwoord == attracties.indexOf(attractie) + 1) {
				attractie.draaien();
			}
		}
				
	}
	
	
	
	void toonMenu() {
		System.out.println("Welkom op de kermis! Wij hebben de volgende attracties:");
		System.out.println("1 botsauto's");
		System.out.println("2 spin");
		System.out.println("3 spiegelpaleis");
		System.out.println("4 spookhuis");
		System.out.println("5 hawaii");
		System.out.println("6 ladderklimmen");		
	//	attracties.get(1).draaien();		
	}
	
	int invoeren() {
		 Scanner sc = new Scanner(System.in);
	     int i = sc.nextInt();
	     return i;
	}
	
	
}

