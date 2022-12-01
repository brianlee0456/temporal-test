package com.decathlon.platform.infrastructure.workflow.price;

import com.decathlon.platform.infrastructure.workflow.order.CreateOrderWorkflow;
import com.decathlon.platform.infrastructure.workflow.order.CreateOrderWorkflowSagaImpl;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

import java.math.BigDecimal;
import java.time.Duration;

/**
 * @author: Brian
 * @date: 2022/12/1 11:16
 */
public class ChangePriceWorkflowStarter {

    private final WorkflowUtil workflowUtil;

    private final static String CHANGE_PRICE_QUEUE = "CHANGE_PRICE_QUEUE";
    private final static String ID = "CHANGE_PRICE";

    public ChangePriceWorkflowStarter(WorkflowUtil workflowUtil) {
        this.workflowUtil = workflowUtil;
    }

    public void start() {
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(CHANGE_PRICE_QUEUE)
                .setWorkflowId(ID)
                .setCronSchedule("* * * * *")
                .build();
        ChangePriceWorkflow changePriceWorkflow = workflowUtil.workflowInstance(
                ChangePriceWorkflow.class, options);

        WorkflowClient.start(changePriceWorkflow::changePrice,"767767",BigDecimal.valueOf(60.5));
        workflowUtil.registerWorker(CHANGE_PRICE_QUEUE, ChangePriceWorkflowImpl.class);
    }
}
