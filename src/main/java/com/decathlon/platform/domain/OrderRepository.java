package com.decathlon.platform.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Brian
 * @date: 2022/11/20 14:09
 */
@Component
public class OrderRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRepository.class);

    public String saveOrder(Order order) {
        LOGGER.info("Order {} saved.", order.getOrderId());
        return order.getOrderId();
    }

    public void cancelOrder(String orderId) {
        LOGGER.info("Order {} canceled.", orderId);
    }
}
