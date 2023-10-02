package com.webservicesproject.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesproject.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
