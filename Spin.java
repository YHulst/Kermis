package kermisPackage;

class Spin extends RisicoRijkAttractie implements GokAttractie{
	String naam = "spin";
	double prijs = 2.25;
	int oppervlakte;
	int draaiLimiet = 5;
	boolean gekeurd;
	
	@Override public double kansSpelBelastingBetalen() {
		double belasting = 0.3 * omzetAttractie;
		omzetAttractie -= belasting;
		return belasting;
	}
	
	@Override int getDraaiLimiet() {
		return draaiLimiet;
	}	
	
	@Override boolean opstellingsKeuring() {
		gekeurd = true;
		return gekeurd;
	}
	
	@Override boolean getGekeurd() {
		return gekeurd;
	}
	
	@Override String getNaam() {
		return naam;
	}
	
	@Override double getPrijs() {
		return prijs;
	}
	
	@Override void setOmzetAttractie() {
		omzetAttractie += prijs;
	}
	
	@Override double getOmzetAttractie() {
		return omzetAttractie;
	}
	
	@Override void setKaartverkoopAttractie() {
		kaartverkoopAttractie++;
	}
	
	@Override int getKaartverkoopAttractie() {
		return kaartverkoopAttractie;
	}
	
	@Override void draaien() {
		System.out.println("De attractie " + naam + " draait.");
	}
}
