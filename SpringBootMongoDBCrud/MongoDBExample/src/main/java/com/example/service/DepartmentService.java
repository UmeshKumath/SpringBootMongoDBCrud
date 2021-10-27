package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public List findAll() {
		return departmentRepository.findAll();
	}
	
	public Department save(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department update(Department department) {
		return departmentRepository.save(department);
	}
	
	public List findDepartmentByName(String deptName) {
		return departmentRepository.findDepartmentByName(deptName);
	}
	
	public void deleteById(String deptId) {
		departmentRepository.deleteById(deptId);
	}
}
