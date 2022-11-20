package com.decathlon.platform.infrastructure.workflow;

import io.temporal.activity.ActivityInterface;

/**
 * @author: Brian
 * @date: 2022/11/20 14:22
 */
@ActivityInterface
public interface CreateOrderActivities {

    void createOrder(String customerId,String itemId);

    void useCoupon(String customerId);

    void addCoupon(String customerId);

    void addEnergyPoint(String customerId, int energyPoint);

    void removeEnergyPoint(String customerId, int energyPoint);

    void decreaseStock(String itemId);

    void increaseStock(String itemId);

}
