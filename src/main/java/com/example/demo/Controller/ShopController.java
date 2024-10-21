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

import com.example.demo.Entity.Shop;
import com.example.demo.Service.shopService;

@RestController
public class ShopController {
	@Autowired
	private shopService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/shop")
	public List<Shop> list() {
		return service.listAll();
	}

	@GetMapping("/shop/{id}")
	public ResponseEntity<Shop> get(@PathVariable Integer id)

	{
		try {
			Shop shop = service.get(id);
			return new ResponseEntity<Shop>(shop, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/shop")
	public void add(@RequestBody Shop shop) {
		service.save(shop);
	}

	// RESTful API method for Update operation
	@PutMapping("/shop/{id}")
	public ResponseEntity<?> update(@RequestBody Shop shop, @PathVariable Integer id) {
		try {
			Shop existShop = service.get(id);
			if (existShop!=null)
			{
				service.save(shop);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/shop/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			Shop existShop = service.get(id);
			if (existShop!=null)
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
