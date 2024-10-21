package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.MallAdmin;
import com.example.demo.Repository.MallAdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MallAdminService {
	@Autowired
	private MallAdminRepository repo;

	public List<MallAdmin> listAll() {
		return repo.findAll();
	}

	public void save(MallAdmin mallAdmin) {
		repo.save(mallAdmin);
	}

	public MallAdmin get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
