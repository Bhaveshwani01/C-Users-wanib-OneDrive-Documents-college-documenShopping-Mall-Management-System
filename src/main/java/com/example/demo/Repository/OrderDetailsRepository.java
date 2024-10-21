package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
