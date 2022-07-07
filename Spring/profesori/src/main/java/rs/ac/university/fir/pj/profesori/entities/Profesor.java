package rs.ac.university.fir.pj.profesori.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="profesori")
public class Profesor {
	
	@Id
	private int id;
	
	private String name;
	private String lastname;
	private String email;
	private String faculty;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "profesoripredmeti",
	joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "predmet_id", referencedColumnName = "id"))
	private Set<Predmet> predmeti;

	public Profesor(int id, String name, String lastname, String email, String faculty) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.faculty = faculty;
	}
	
	public Profesor() {
		
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", faculty="
				+ faculty + "]";
	}

}
