package rs.ac.singidunum.fir.pj;

import org.springframework.stereotype.Component;

@Component
public class Kamera {
	
	public void napraviFotografiju() {
		System.out.println("Skljoc");
	}
	
	public void napraviFotografiju(int ekspozicija) {
		System.out.println("Skljoc " + " ekspozicija = " + ekspozicija);
	}
	
	public String napraviFotografiju(String imeFotografije) {
		System.out.println("Skljoc" + " ime = " + imeFotografije);
		return imeFotografije;	
	}
}
