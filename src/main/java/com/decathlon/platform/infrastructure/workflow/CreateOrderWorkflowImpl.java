package com.decathlon.platform.infrastructure.workflow;

import fun.AccountActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

/**
 * @author: Brian
 * @date: 2022/11/20 14:15
 */
public class CreateOrderWorkflowImpl implements CreateOrderWorkflow {

    private final CreateOrderActivities activities =
            Workflow.newActivityStub(CreateOrderActivities.class, ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(3))
                    .build());

    @Override
    public void createOrder(String customerId, String itemId,int energyPoint) {
        activities.createOrder(customerId,itemId);
        activities.useCoupon(customerId);
        activities.addEnergyPoint(customerId,100);
        activities.decreaseStock(itemId);
    }
}
