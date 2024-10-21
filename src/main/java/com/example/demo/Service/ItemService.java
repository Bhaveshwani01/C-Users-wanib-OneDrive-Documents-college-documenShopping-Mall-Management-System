package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Item;
import com.example.demo.Repository.ItemRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {
	@Autowired
	private ItemRepository repo;

	public List<Item> listAll() {
		return repo.findAll();
	}

	public void save(Item item) {
		repo.save(item);
	}

	public Item get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
