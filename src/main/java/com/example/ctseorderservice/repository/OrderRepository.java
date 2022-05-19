package com.example.ctseorderservice.repository;

import com.example.ctseorderservice.VO.Product;
import com.example.ctseorderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository <Order, Long> {
    Order findOrderById(Long id);

    @Query(value = "select o from Order o where o.customer_id = :#{#id}")
    List<Order> findOrdersByCustomerId(Long id);
}
