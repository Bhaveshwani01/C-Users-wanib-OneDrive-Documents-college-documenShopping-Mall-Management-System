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

import com.example.demo.Service.*;
import com.example.demo.Entity.OrderDetails;

@RestController
public class OrderDetailsController {
	@Autowired
	private OrderDetailsService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/orderDetails")
	public List<OrderDetails> list() {
		return service.listAll();
	}

	@GetMapping("/orderDetails/{id}")
	public ResponseEntity<OrderDetails> get(@PathVariable Integer id)

	{
		try {
			OrderDetails orderDetails = service.get(id);
			return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/orderDetails")
	public void add(@RequestBody OrderDetails orderDetails) {
		service.save(orderDetails);
	}

	// RESTful API method for Update operation
	@PutMapping("/orderDetails/{id}")
	public ResponseEntity<?> update(@RequestBody OrderDetails orderDetails, @PathVariable Integer id) {
		try {
			OrderDetails existOrderDetails = service.get(id);
			if (existOrderDetails!=null)
			{
				service.save(orderDetails);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/orderDetails/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			OrderDetails existOrderDetails = service.get(id);
			if (existOrderDetails!=null)
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
