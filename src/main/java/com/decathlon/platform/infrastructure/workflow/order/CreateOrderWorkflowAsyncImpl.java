package com.decathlon.platform.infrastructure.workflow.order;

import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;

/**
 * @author: Brian
 * @date: 2022/11/20 14:15
 */
public class CreateOrderWorkflowAsyncImpl extends AbstractCreateOrderWorkflow {


    @Override
    public void createOrder(String customerId, String itemId, int energyPoint) {
        Promise<String> orderIdPromise = Async.function(activities::createOrder, customerId, itemId);
        Async.procedure(activities::useCoupon, customerId);
        Async.procedure(activities::addEnergyPoint, customerId, 100);
        Async.procedure(activities::decreaseStock, itemId);
        LOGGER.info("Implements create order {} workflow with async.", orderIdPromise.get());
    }
}
