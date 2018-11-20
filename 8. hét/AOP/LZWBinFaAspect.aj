package com.mycompany.mavenbinfa;

public aspect LZWBinFaAspect {
	int egyes = 0;
	int nullas = 0;

        /* az egyBitFeldolg metódus char paraméterrel való meghívását figyeli */
	pointcut bitszamol(char a): call(* LZWBinFa.egyBitFeldolg(char)) && args(a);

        /* a getSzoras meghívását figyeli */
	pointcut kiiratas(): call(* LZWBinFa.getSzoras());
	
	before(char a): bitszamol(a) {		
            if (a == '0')
                nullas++;
            else 
		if (a == '1')
                    egyes++;
	}

	after(): kiiratas() {
		System.out.println("Nullások száma: " + nullas);
		System.out.println("Egyesek száma: " + egyes);
	}

}