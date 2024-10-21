package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.ShopOwner;
import com.example.demo.Repository.ShopOwnerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopOwnerService {
	@Autowired
	private ShopOwnerRepository repo;

	public List<ShopOwner> listAll() {
		return repo.findAll();
	}

	public void save(ShopOwner shopOwner) {
		repo.save(shopOwner);
	}

	public ShopOwner get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
