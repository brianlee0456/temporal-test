package com.decathlon.platform.interfaces.facade;

import com.decathlon.platform.infrastructure.workflow.CreateOrderWorkflow;
import io.temporal.client.WorkflowClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: Brian
 * @date: 2022/11/20 14:53
 */
@Service
public class OrderServiceFacade {

    private final CreateOrderWorkflow createOrderWorkflow;

    public OrderServiceFacade(CreateOrderWorkflow createOrderWorkflow) {
        this.createOrderWorkflow = createOrderWorkflow;
    }

    public void createOrder(String customerId, String itemId) {
//        CompletableFuture<Void> result = WorkflowClient.execute(createOrderWorkflow::createOrder, customerId, itemId, 100);
//        try {
//            result.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        createOrderWorkflow.createOrder(customerId, itemId, 100);
    }
}
