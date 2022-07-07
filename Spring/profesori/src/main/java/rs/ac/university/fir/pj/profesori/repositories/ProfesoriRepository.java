package rs.ac.university.fir.pj.profesori.repositories;
 	
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import rs.ac.university.fir.pj.profesori.entities.Predmet;
import rs.ac.university.fir.pj.profesori.entities.Profesor;

public interface ProfesoriRepository extends CrudRepository<Profesor, Integer> {

	List<Profesor> findAllProfesorsByPredmeti (Predmet predmet);
}
