package com.decathlon.platform.interfaces.facade;

import com.decathlon.platform.infrastructure.workflow.CreateOrderWorkflow;
import org.springframework.stereotype.Service;

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
        createOrderWorkflow.createOrder(customerId, itemId,100);
    }
}
