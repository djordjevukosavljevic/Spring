package rs.ac.singidunum.fir.pj;

import org.springframework.stereotype.Component;

@Component
public class Telefon {
	
	
	public void pozovi(String broj, boolean status) throws Exception{
		System.out.println("Pozivamo broj..." + broj);
		if(!status) throw new Exception("Nije moguce napraviti poziv.");
		System.out.println("Poziv uspesan");
	}
	
	
	public void posaljiPoruku() {
		System.out.println("Poruka poslata.");
	}
}
