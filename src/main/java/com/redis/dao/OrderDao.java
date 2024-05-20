package com.redis.dao;

import com.redis.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    private static  final String HASH_KEY = "Order";

    @Autowired
    private RedisTemplate template;

    public Order save(Order order) {
        template.opsForHash().put(HASH_KEY,order.getId(),order);
        return order;
    }
    public List<Object> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }
    public Order findProductById(int id) {
        return (Order)template.opsForHash().get(HASH_KEY,id);
    }
    public String deletedById(int id) {
        template.opsForHash().delete(HASH_KEY,id);
        return "Oder deleted SuccessFully ";
    }

}
