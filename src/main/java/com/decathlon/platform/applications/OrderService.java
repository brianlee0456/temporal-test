package com.decathlon.platform.applications;

import com.decathlon.platform.domain.Order;
import com.decathlon.platform.domain.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: Brian
 * @date: 2022/11/20 14:12
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String createOrder(String userId,String itemId){
        Order order = new Order(UUID.randomUUID().toString(), userId, itemId);
        return orderRepository.saveOrder(order);
    }

    public void cancelOrder(String orderId){
        orderRepository.cancelOrder(orderId);
    }
}
