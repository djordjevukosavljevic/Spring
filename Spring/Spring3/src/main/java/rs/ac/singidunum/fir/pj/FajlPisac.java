package rs.ac.singidunum.fir.pj;

import org.springframework.stereotype.Component;

@Component
public class FajlPisac implements LogPisac{

	public void pisiLiniju(String tekst) {
		// dummy implementacija, inace treba da ide upis jedne linije teksta u fajl
		
		System.out.println("Upis u fajl: " + tekst);
	}

}
