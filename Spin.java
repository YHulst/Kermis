package kermisPackage;

class Spin extends Attractie{
	String naam = "spin";
	int prijs;
	int oppervlakte;
	
	void draaien() {
		System.out.println("De attractie " + naam + " draait.");
	}

}
