package rs.ac.university.fir.pj.profesori.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.university.fir.pj.profesori.entities.Predmet;
import rs.ac.university.fir.pj.profesori.entities.Profesor;
import rs.ac.university.fir.pj.profesori.repositories.ProfesoriRepository;

@RestController
public class ProfesoriController {
	@Autowired
	private ProfesoriRepository repository;
	
	//Get localhost:8080/profesors
	@GetMapping("/profesors")
	public List<Profesor> getAll(){
		return (List<Profesor>)repository.findAll();
	}
	
	@GetMapping(path="/profesors/{id}")
	public Profesor getOne(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	// Post localhost:8080/profesors
	@PostMapping("/profesors")
	public Profesor create(@RequestBody Profesor profesor) {
		return repository.save(profesor);
	}	
	
	//Put localhost:8080/profesors/{id}
	@PutMapping("/profesors/{id}")
	public Profesor update(@PathVariable int id,@RequestBody Profesor profesor) {
		return repository.save(profesor);
	}
	
	// DELETE localhost:8080/profesors/{id}
	@DeleteMapping("/profesors/{id}")
	public void deleteOne(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	// Get localhost:8080/profesors/count
	@GetMapping("/profesors/count")
	public long countProfesors() {
		return repository.count();
	}
	
	// dovhatanje svih profesora koji drze neki predmet
	@GetMapping("/profesors/subject")
	public List<Profesor> dohvatiProfesoraPoPredmetu(@RequestBody Predmet predmet){
		return repository.findAllProfesorsByPredmeti(predmet);
	}
}