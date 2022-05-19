package com.example.ctseorderservice.controller;

import com.example.ctseorderservice.VO.ResponseTemplate;
import com.example.ctseorderservice.entity.Order;
import com.example.ctseorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/by-customer/{id}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long id){
        return orderService.getOrdersByCustomerId(id);
    }
}
