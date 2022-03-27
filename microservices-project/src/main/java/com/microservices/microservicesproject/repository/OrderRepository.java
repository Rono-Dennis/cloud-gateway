package com.microservices.microservicesproject.repository;

import com.microservices.microservicesproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
}
