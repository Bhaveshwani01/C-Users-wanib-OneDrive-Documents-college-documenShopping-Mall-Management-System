package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.OrderDetails;
import com.example.demo.Repository.OrderDetailsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderDetailsService {
	@Autowired
	private OrderDetailsRepository repo;

	public List<OrderDetails> listAll() {
		return repo.findAll();
	}

	public void save(OrderDetails orderDetails) {
		repo.save(orderDetails);
	}

	public OrderDetails get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
