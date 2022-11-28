package com.decathlon.platform.interfaces.facade;

import com.decathlon.platform.infrastructure.workflow.order.CreateOrderWorkflow;
import com.decathlon.platform.infrastructure.workflow.order.CreateOrderWorkflowFactory;
import org.springframework.stereotype.Service;

/**
 * @author: Brian
 * @date: 2022/11/20 14:53
 */
@Service
public class OrderServiceFacade {

    private final CreateOrderWorkflowFactory createOrderWorkflowFactory;

    public OrderServiceFacade(CreateOrderWorkflowFactory createOrderWorkflowFactory) {
        this.createOrderWorkflowFactory = createOrderWorkflowFactory;
    }


    public void createOrder(String customerId, String itemId) {
//        CompletableFuture<Void> result = WorkflowClient.execute(createOrderWorkflow::createOrder, customerId, itemId, 100);
//        try {
//            result.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        CreateOrderWorkflow createOrderWorkflow = createOrderWorkflowFactory.create();
        createOrderWorkflow.createOrder(customerId, itemId, 100);
    }
}
