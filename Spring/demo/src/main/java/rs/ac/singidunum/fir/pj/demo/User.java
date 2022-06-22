package rs.ac.singidunum.fir.pj.demo;

import java.util.Date;

public class User {
	private Integer id;
	private String ime;
	private Date birthDate;

	public User(Integer id, String ime, Date birthDate) {
		this.id = id;
		this.ime = ime;
		this.birthDate = birthDate;
	}
	
	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ime=" + ime + ", birthDate=" + birthDate + "]";
	}
	
	
}
