package rs.ac.university.fir.pj.profesori.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="predmeti")
public class Predmet{

	@Id
	private int id;
	private String name;
	private String code;
	private int ESPB;
	
	@ManyToMany(mappedBy = "predmeti")
	private Set<Profesor> profesori;

	public Predmet() {
		
	}
	public Predmet(int id, String name, String code, int eSPB) {
		this.id = id;
		this.name = name;
		this.code = code;
		ESPB = eSPB;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getESPB() {
		return ESPB;
	}
	public void setESPB(int eSPB) {
		ESPB = eSPB;
	}
}
