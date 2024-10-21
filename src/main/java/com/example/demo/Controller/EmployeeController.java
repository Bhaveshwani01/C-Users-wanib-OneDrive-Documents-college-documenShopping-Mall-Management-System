package com.example.demo.Controller;

import java.util.Collection;
import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.*;
import com.example.demo.Service.*;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/employee")
	public List<Employee> list() {
		return service.listAll();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id)

	{
		try {
			Employee employee = service.get(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/employee")
	public void add(@RequestBody Employee employee) {
		service.save(employee);
	}

	// RESTful API method for Update operation
	@PutMapping("/employee/{id}")
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) {
		try {
			Employee existEmployee = service.get(id);
			if (existEmployee!=null)
			{
				service.save(employee);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			Employee existEmployee = service.get(id);
			if (existEmployee!=null)
			{
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
