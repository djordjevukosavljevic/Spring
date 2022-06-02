package rs.ac.singidunum.fir.pj;

import org.springframework.stereotype.Component;

@Component("konzola")
public class KonzolniPisac implements LogPisac{

	public void pisiLiniju(String tekst) {
		System.out.println("Ispis na konzolu: " + tekst);
	
	}
	
}
