package kermisPackage;

class Ladderklimmen extends Attractie implements GokAttractie {
	String naam = "ladderklimmen";
	double prijs = 5.0;
	int oppervlakte;
	
	@Override public double kansSpelBelastingBetalen() {
		double belasting = 0.3 * omzetAttractie;
		omzetAttractie -= belasting;
		return belasting;
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
