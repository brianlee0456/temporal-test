package com.decathlon.platform.infrastructure.workflow;

/**
 * @author: Brian
 * @date: 2022/11/20 14:15
 */
public class CreateOrderWorkflowImpl extends AbstractCreateOrderWorkflow {

    @Override
    public void createOrder(String customerId, String itemId,int energyPoint) {
        activities.createOrder(customerId,itemId);
        activities.useCoupon(customerId);
        activities.addEnergyPoint(customerId,100);
        activities.decreaseStock(itemId);
    }
}
