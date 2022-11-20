package com.decathlon.platform.domain;

/**
 * @author: Brian
 * @date: 2022/11/20 14:09
 */
public class Order {

    private final String orderId;
    private final String userId;
    private final String itemId;

    public Order(String orderId, String userId, String itemId) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }
}
