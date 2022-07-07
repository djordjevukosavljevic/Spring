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
import rs.ac.university.fir.pj.profesori.repositories.PredmetiRepository;

@RestController
public class PredmetiController {
	
	@Autowired
	private PredmetiRepository repository;
	
	
	// Get localhost:8080/subjects
	@GetMapping("/subjects")
	public List<Predmet> getAll(){
		return (List<Predmet>)repository.findAll();
	}
	
	// Get localhost:8080/subject/id
	@GetMapping("/subjects/{id}")
	public Predmet getOne(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	// Post localhost:8080/subjects
	@PostMapping("/subjects")
	public Predmet create(@RequestBody Predmet predmet) {
		return repository.save(predmet);
	}
	
	// Delete localhost:8080/subjects/id
	@DeleteMapping("/subjects/{id}")
	public void obrisi(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	// Put
	@PutMapping("/subjects/{id}")
	public Predmet azurirajPredmet(@PathVariable int id, @RequestBody Predmet predmet) {
		return repository.save(predmet);
	}
	
	//Get localhost:8080/subjects/search/{code}
	@GetMapping("/subjects/search/{code}")
	public Predmet nadjiPredmetPremaOznaci(@PathVariable String code) {
		return repository.findByCode(code);
	} 
	
	//dohvatanje svih predmeta koje drzi neki profesor
	@GetMapping("/subjects/profesor")
	public List<Predmet> nadjiPredmetPoProfesoru(@RequestBody Profesor profesor){
		return repository.findAllPredmetiByProfesori(profesor);
	}
	
}
