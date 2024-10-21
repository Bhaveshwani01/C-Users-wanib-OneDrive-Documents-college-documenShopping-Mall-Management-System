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
import com.example.demo.Entity.MallAdmin;

@RestController
public class MallAdminController {
	@Autowired
	private MallAdminService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/mallAdmin")
	public List<MallAdmin> list() {
		return service.listAll();
	}

	@GetMapping("/mallAdmin/{id}")
	public ResponseEntity<MallAdmin> get(@PathVariable Integer id)

	{
		try {
			MallAdmin mallAdmin = service.get(id);
			return new ResponseEntity<MallAdmin>(mallAdmin, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<MallAdmin>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/mallAdmin")
	public void add(@RequestBody MallAdmin mallAdmin) {
		service.save(mallAdmin);
	}

	// RESTful API method for Update operation
	@PutMapping("/mallAdmin/{id}")
	public ResponseEntity<?> update(@RequestBody MallAdmin mallAdmin, @PathVariable Integer id) {
		try {
			MallAdmin existMallAdmin = service.get(id);
			if (existMallAdmin!=null)
			{
				service.save(mallAdmin);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/mallAdmin/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			MallAdmin existMallAdmin = service.get(id);
			if (existMallAdmin!=null)
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
