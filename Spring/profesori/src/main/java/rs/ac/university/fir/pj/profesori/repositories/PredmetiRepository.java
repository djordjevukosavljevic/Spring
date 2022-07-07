package rs.ac.university.fir.pj.profesori.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import rs.ac.university.fir.pj.profesori.entities.Predmet;
import rs.ac.university.fir.pj.profesori.entities.Profesor;

public interface PredmetiRepository extends CrudRepository<Predmet, Integer>{
	
	Predmet findByCode (String code);
	
	Predmet findByCodeIgnoreCase (String code);
	
	List<Predmet> findAllPredmetiByProfesori (Profesor profesor);
}
