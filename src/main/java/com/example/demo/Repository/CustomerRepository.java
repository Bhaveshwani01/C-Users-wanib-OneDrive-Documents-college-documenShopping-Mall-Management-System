package com.example.demo.Repository;
import com.example.demo.Entity.*;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
