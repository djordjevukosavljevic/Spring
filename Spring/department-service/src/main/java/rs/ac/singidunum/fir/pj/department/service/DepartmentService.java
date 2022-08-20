package rs.ac.singidunum.fir.pj.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import rs.ac.singidunum.fir.pj.department.entity.Department;
import rs.ac.singidunum.fir.pj.department.repository.DepartmentRepository;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Unutar saveDepartment u DepartmentService delu.");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		log.info("Unutar findDepartmentById u DepartmentService delu.");
		return departmentRepository.findByDepartmentId(departmentId);
	}
	
	public List<Department> findAll(){
		log.info("Unutar getAll u DepartmentService delu.");
		return departmentRepository.findAll();
	}

	/*
	public Department update(Department department) {
		return departmentRepository.update(department);
	} */
}
