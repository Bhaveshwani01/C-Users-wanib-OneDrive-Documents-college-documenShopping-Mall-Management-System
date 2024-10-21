package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Mall;
import com.example.demo.Repository.MallRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MallService {
	@Autowired
	private MallRepository repo;

	public List<Mall> listAll() {
		return repo.findAll();
	}

	public void save(Mall mall) {
		repo.save(mall);
	}

	public Mall get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
