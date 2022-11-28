package com.decathlon.platform.infrastructure.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

/**
 * @author: Brian
 * @date: 2022/11/20 14:07
 *
 * The promises
 */
@WorkflowInterface
public interface CreateOrderWorkflow {

    @WorkflowMethod
    void createOrder(String customerId, String itemId,int energyPoint);

}
