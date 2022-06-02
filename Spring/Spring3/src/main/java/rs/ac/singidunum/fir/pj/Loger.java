package rs.ac.singidunum.fir.pj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Loger {
	
	@Autowired
	private KonzolniPisac konzolniPisac;
	@Autowired
	private FajlPisac fajlPisac;
	
	public void pisiUFajl(String tekst) {
		fajlPisac.pisiLiniju(tekst);
	}
	
	public void pisiNaKonzolu(String tekst) {
		konzolniPisac.pisiLiniju(tekst);
	}
	
}
