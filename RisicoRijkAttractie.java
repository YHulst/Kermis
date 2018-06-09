package kermisPackage;

abstract class RisicoRijkAttractie extends Attractie {
	int draaiLimiet;
	boolean gekeurd;
	int keerGedraaid;
	
	abstract int getDraaiLimiet();
	
	abstract boolean opstellingsKeuring();
	
	abstract boolean getGekeurd();
}
