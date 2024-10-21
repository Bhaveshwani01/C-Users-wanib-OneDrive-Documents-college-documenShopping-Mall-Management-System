package com.example.demo.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import com.example.demo.Entity.Employee;
import com.example.demo.Entity.*;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public List<Employee> listAll() {
		return repo.findAll();
	}

	public void save(Employee employee) {
		repo.save(employee);
	}

	public Employee get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
