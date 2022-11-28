package com.decathlon.platform.infrastructure.workflow.order;

import com.decathlon.platform.applications.OrderService;
import com.decathlon.platform.infrastructure.remote.CouponClient;
import com.decathlon.platform.infrastructure.remote.EnergyPointClient;
import com.decathlon.platform.infrastructure.remote.StockClient;

/**
 * @author: Brian
 * @date: 2022/11/20 14:30
 */
public class CreateOrderActivitiesImpl implements CreateOrderActivities {

    private final OrderService orderService;
    private final CouponClient couponClient;
    private final EnergyPointClient energyPointClient;
    private final StockClient stockClient;

    public CreateOrderActivitiesImpl(OrderService orderService, CouponClient couponClient
            , EnergyPointClient energyPointClient, StockClient stockClient) {
        this.orderService = orderService;
        this.couponClient = couponClient;
        this.energyPointClient = energyPointClient;
        this.stockClient = stockClient;
    }

    @Override
    public String createOrder(String customerId, String itemId) {
        return orderService.createOrder(customerId, itemId);
    }

    @Override
    public void cancelOrder(String orderId) {
        orderService.cancelOrder(orderId);
    }

    @Override
    public void useCoupon(String customerId) {
        couponClient.customerUseCoupon(customerId);
    }

    @Override
    public void addCoupon(String customerId) {
        couponClient.addCouponToCustomer(customerId);
    }

    @Override
    public void removeEnergyPoint(String customerId, int energyPoint) {
        energyPointClient.removeEnergyPoint(customerId, energyPoint);
    }

    @Override
    public void addEnergyPoint(String customerId, int energyPoint) {
        energyPointClient.addEnergyPoint(customerId, energyPoint);
    }

    @Override
    public void decreaseStock(String itemId) {
        int a = 1/0;
        stockClient.decreaseStock(itemId);
    }

    @Override
    public void increaseStock(String itemId) {
        stockClient.increaseStock(itemId);
    }
}
