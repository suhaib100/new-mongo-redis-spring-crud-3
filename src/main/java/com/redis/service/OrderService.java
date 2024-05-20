package com.redis.service;

import com.redis.entity.Order;
import com.redis.repository.OrderRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }


//@Cacheable(value = "order")
    public List<Order> getAllList() {
        return orderRepository.findAll();
    }


    public Order getOrderById(String id) {
        System.out.println("called from db");
         return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("order not found by id")
        );
    }
    // Deleted by is
    @Caching(evict = {@CacheEvict(value = "order",allEntries = true), @CacheEvict(value =
    "order",key = "#id")})
    public String getDeletedById(String id) {
        orderRepository.deleteById(id);
        return "order deleted SUCCESSFULLY";
    }
}
