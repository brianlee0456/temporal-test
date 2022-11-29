package com.decathlon.platform.interfaces.facade;

import com.decathlon.platform.infrastructure.workflow.notify.Account;
import com.decathlon.platform.infrastructure.workflow.notify.NotifyWorkflow;
import com.decathlon.platform.infrastructure.workflow.notify.NotifyWorkflowFactory;
import com.decathlon.platform.infrastructure.workflow.order.CreateOrderWorkflow;
import com.decathlon.platform.infrastructure.workflow.order.CreateOrderWorkflowFactory;
import com.decathlon.platform.infrastructure.workflow.stock.CheckStockWorkflow;
import com.decathlon.platform.infrastructure.workflow.stock.CheckStockWorkflowFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Brian
 * @date: 2022/11/20 14:53
 */
@Service
public class OrderServiceFacade {

    private final CreateOrderWorkflowFactory createOrderWorkflowFactory;
    private final CheckStockWorkflowFactory checkStockWorkflowFactory;
    private final NotifyWorkflowFactory notifyWorkflowFactory;

    public OrderServiceFacade(CreateOrderWorkflowFactory createOrderWorkflowFactory
            , CheckStockWorkflowFactory checkStockWorkflowFactory, NotifyWorkflowFactory notifyWorkflowFactory) {
        this.createOrderWorkflowFactory = createOrderWorkflowFactory;
        this.checkStockWorkflowFactory = checkStockWorkflowFactory;
        this.notifyWorkflowFactory = notifyWorkflowFactory;
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

    public String checkStock(String itemId,int count){
        CheckStockWorkflow checkStockWorkflow = checkStockWorkflowFactory.create();
        return checkStockWorkflow.checkStock(itemId,count);
    }

    public int notifyAccounts(){
        NotifyWorkflow notifyWorkflow = notifyWorkflowFactory.create();
        notifyWorkflow.notifyAccounts(List.of(
                Account.of("Brian")
                ,Account.of("Steve")
                ,Account.of("Jack")
                ,Account.of("Lily")
                ,Account.of("James")
                ,Account.of("Sunny")
        ));
        return notifyWorkflow.count();
    }
}
