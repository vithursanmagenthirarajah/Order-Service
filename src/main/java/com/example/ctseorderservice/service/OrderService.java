package com.example.ctseorderservice.service;

import com.example.ctseorderservice.VO.Customer;
import com.example.ctseorderservice.VO.Product;
import com.example.ctseorderservice.VO.ResponseTemplate;
import com.example.ctseorderservice.entity.Order;
import com.example.ctseorderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public ResponseTemplate getOrderById(Long id) {
        ResponseTemplate vo = new ResponseTemplate();

        Order order = orderRepository.findOrderById(id);
        Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/" + order.getCustomer_id(), Customer.class);

        vo.setOrder(order);
        vo.setCustomer(customer);

        return vo;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByCustomerId(Long id) {
        return orderRepository.findOrdersByCustomerId(id);
    }
}
