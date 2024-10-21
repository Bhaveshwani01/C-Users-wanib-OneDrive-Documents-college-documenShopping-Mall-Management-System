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
import com.example.demo.Entity.ShopOwner;

@RestController
public class ShopOwnerController {
	@Autowired
	private ShopOwnerService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/shopOwner")
	public List<ShopOwner> list() {
		return service.listAll();
	}

	@GetMapping("/shopOwner/{id}")
	public ResponseEntity<ShopOwner> get(@PathVariable Integer id)

	{
		try {
			ShopOwner shopOwner = service.get(id);
			return new ResponseEntity<ShopOwner>(shopOwner, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/shopOwner")
	public void add(@RequestBody ShopOwner shopOwner) {
		service.save(shopOwner);
	}

	// RESTful API method for Update operation
	@PutMapping("/shopOwner/{id}")
	public ResponseEntity<?> update(@RequestBody ShopOwner shopOwner, @PathVariable Integer id) {
		try {
			ShopOwner existShopOwner = service.get(id);
			if (existShopOwner!=null)
			{
				service.save(shopOwner);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/shopOwner/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			ShopOwner existShopOwner = service.get(id);
			if (existShopOwner!=null)
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
