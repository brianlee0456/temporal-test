package com.decathlon.platform.infrastructure.workflow;

import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;

/**
 * @author: Brian
 * @date: 2022/11/20 14:15
 */
public class CreateOrderWorkflowAsyncImpl extends AbstractCreateOrderWorkflow {

    @Override
    public void createOrder(String customerId, String itemId, int energyPoint) {
        Promise<Void> procedure = Async.procedure(activities::createOrder, customerId, itemId);
        Promise<Void> procedure1 = Async.procedure(activities::useCoupon, customerId);
        Promise<Void> procedure2 = Async.procedure(activities::addEnergyPoint, customerId, 100);
        Promise<Void> procedure3 = Async.procedure(activities::decreaseStock, itemId);

        procedure.get();
        procedure1.get();
        procedure2.get();
        procedure3.get();

    }
}
