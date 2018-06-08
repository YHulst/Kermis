package kermisPackage;

class Kassa {
	int totaleKaartverkoop;
	double totaleOmzet;
	
	void kasBijhouden(Kermis kermis, int antwoord) {	
		kermis.attracties.get(antwoord - 1).setKaartverkoopAttractie();	
	//	int kaartverkoopAttractie = kermis.attracties.get(antwoord - 1).getKaartverkoopAttractie();
		totaleKaartverkoop ++;
		kermis.attracties.get(antwoord - 1).setOmzetAttractie();		
	//	double omzetAttractie = kermis.attracties.get(antwoord - 1).getOmzetAttractie();
		totaleOmzet += kermis.attracties.get(antwoord - 1).getPrijs();
	}
	
	
}
