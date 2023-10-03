package com.webservicesproject.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesproject.project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
