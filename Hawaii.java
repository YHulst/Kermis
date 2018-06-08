package kermisPackage;

class Hawaii extends Attractie{
	String naam = "hawaii";
	double prijs = 3.9;
	int oppervlakte;
	
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
