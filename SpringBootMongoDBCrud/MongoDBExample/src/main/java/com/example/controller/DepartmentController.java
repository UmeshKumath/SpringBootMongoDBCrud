package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping(value="/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.save(department);
	}
	
	@GetMapping
	public List allDepartment() {
		return departmentService.findAll();
	}
	
	@GetMapping(value="/{deptName}")
	public List findDeptbyName(@PathVariable String deptName) {
		return departmentService.findDepartmentByName(deptName);
	}
	
	@PutMapping("/{deptId}")
	public Department updatePartment(@RequestBody Department department, @PathVariable String deptId) {
		department.setId(deptId);
		return departmentService.save(department);
	}
	
	@DeleteMapping("/{deptId}")
	public String deleteDepartment(@PathVariable String deptId) {
		departmentService.deleteById(deptId);
		return deptId;
	}
}
