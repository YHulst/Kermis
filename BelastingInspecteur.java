package kermisPackage;

class BelastingInspecteur {
	
	void langskomen(Kermis kermis) {
		for (Attractie attractie : kermis.attracties) {
			if (attractie instanceof GokAttractie) {				
				double belasting = ((GokAttractie) attractie).kansSpelBelastingBetalen();
				kermis.kassa.totaleOmzet -= belasting;
				kermis.kassa.totaalIngehoudenBelasting += belasting;								
			}
		}
		kermis.kassa.aantalBezoekenInspecteur++;
	}

}
