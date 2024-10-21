package com.example.demo.Controller;

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

import com.example.demo.Entity.Customer;
import com.example.demo.Service.*;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/customer")
	public List<Customer> list() {
		return service.listAll();
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> get(@PathVariable Integer id)

	{
		try {
			Customer customer = service.get(id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/customer")
	public void add(@RequestBody Customer customer) {
		service.save(customer);
	}

	// RESTful API method for Update operation
	@PutMapping("/customer/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) {
		try {
			Customer existCustomer = service.get(id);
			if (existCustomer!=null)
			{
				service.save(customer);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			Customer existCustomer = service.get(id);
			if (existCustomer!=null)
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
