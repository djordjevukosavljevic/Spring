package rs.ac.singidunum.fir.pj.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserDAOService service;
	
	// za dohvatanje svih korisnika
	@GetMapping(path="/users")
	public List<User> getAll(){
		return service.findAll();
	}
	
	// GET /users/id
	@GetMapping(path="/users/{id}")
	public User getOne(@PathVariable int id) {
		return service.findOne(id);
	}
	
	// POST /users
	@PostMapping(path="/users")
	public User createOne(@RequestBody User user) {
		return service.save(user);
	}
}
