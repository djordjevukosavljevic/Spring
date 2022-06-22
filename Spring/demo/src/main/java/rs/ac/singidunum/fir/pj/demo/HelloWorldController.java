package rs.ac.singidunum.fir.pj.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//http://localhost:8080/hello-world -> get -> hello world
	@RequestMapping(method=RequestMethod.GET, path ="/hello-world")
	public String helloWorld() {
		return "Moj prvi GET request!";
	}
	
}
