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
import com.example.demo.Entity.Item;

@RestController
public class ItemController {
	@Autowired
	private ItemService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/item")
	public List<Item> list() {
		return service.listAll();
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<Item> get(@PathVariable Integer id)

	{
		try {
			Item item = service.get(id);
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/item")
	public void add(@RequestBody Item item) {
		service.save(item);
	}

	// RESTful API method for Update operation
	@PutMapping("/item/{id}")
	public ResponseEntity<?> update(@RequestBody Item item, @PathVariable Integer id) {
		try {
			Item existItem = service.get(id);
			if (existItem!=null)
			{
				service.save(item);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/item/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			Item existItem = service.get(id);
			if (existItem!=null)
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
