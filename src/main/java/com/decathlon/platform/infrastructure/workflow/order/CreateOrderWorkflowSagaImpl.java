package com.decathlon.platform.infrastructure.workflow.order;

import io.temporal.failure.ActivityFailure;
import io.temporal.workflow.Saga;

/**
 * @author: Brian
 * @date: 2022/11/20 14:15
 */
public class CreateOrderWorkflowSagaImpl extends AbstractCreateOrderWorkflow {

    @Override
    public void createOrder(String customerId, String itemId, int energyPoint) {
        Saga.Options sagaOptions = new Saga.Options.Builder()
                .setParallelCompensation(true).build();
        Saga saga = new Saga(sagaOptions);
        try {
            String orderId = activities.createOrder(customerId, itemId);
            LOGGER.info("Implements create order {} workflow with saga.", orderId);
            saga.addCompensation(activities::cancelOrder, orderId);

            activities.useCoupon(customerId);
            saga.addCompensation(activities::addCoupon, customerId);

            activities.addEnergyPoint(customerId, 100);
            saga.addCompensation(activities::removeEnergyPoint, customerId, 100);

            activities.decreaseStock(itemId);
            saga.addCompensation(activities::increaseStock, itemId);
        } catch (ActivityFailure e) {
            saga.compensate();
            throw e;
        }
    }
}
