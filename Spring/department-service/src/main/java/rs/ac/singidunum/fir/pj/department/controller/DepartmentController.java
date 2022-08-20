package rs.ac.singidunum.fir.pj.department.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import rs.ac.singidunum.fir.pj.department.entity.Department;
import rs.ac.singidunum.fir.pj.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/")
	public List<Department> getAll(){
		return (List<Department>)departmentService.findAll();
	}
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Unutar saveDepartment u DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	/*
	@PutMapping("/{id}")
	public Department update(@RequestBody Department department){
		return departmentService.update(department);
	}
	*/
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Unutar findDepartmentById u DepartmentController");
		return departmentService.findDepartmentById(departmentId);
	}
	
}
