package rs.ac.singidunum.fir.pj;

import org.springframework.stereotype.Component;

// domenski objekat, koji sluzi da prihvati jedan unos u bazi podataka
@Component
public class Oglas {
	private int id;
	private String ime;
	private String email;
	private String tekst;

	public Oglas() {
		
	}
	
	public Oglas(int id, String ime, String email, String tekst) {
		this.id = id;
		this.ime = ime;
		this.email = email;
		this.tekst = tekst;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "Oglas [id=" + id + ", ime=" + ime + ", email=" + email + ", tekst=" + tekst + "]";
	}

	
	
	
}
