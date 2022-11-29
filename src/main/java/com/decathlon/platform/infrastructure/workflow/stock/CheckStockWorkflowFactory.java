package com.decathlon.platform.infrastructure.workflow.stock;

import com.decathlon.platform.infrastructure.remote.StockClient;
import com.decathlon.platform.infrastructure.workflow.common.AbstractWorkflowFactory;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import io.temporal.client.WorkflowOptions;

import java.time.Duration;

/**
 * @author: Brian
 * @date: 2022/11/28 17:29
 */
public class CheckStockWorkflowFactory extends AbstractWorkflowFactory<CheckStockWorkflow> {

    private static final String CHECK_STOCK_QUEUE = "CHECK_STOCK_QUEUE";
    private final CheckStockActivity checkStockActivity;

    public CheckStockWorkflowFactory(WorkflowUtil workflowUtil, StockClient stockClient) {
        super(workflowUtil);
        this.checkStockActivity = new CheckStockActivityImpl(stockClient);
        registerWorker();
    }

    public CheckStockWorkflow create(){
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(CHECK_STOCK_QUEUE)
                //whole progress
                .setWorkflowExecutionTimeout(Duration.ofHours(10))
                //one invocation
                .setWorkflowRunTimeout(Duration.ofHours(10))
                .build();
        return workflowUtil.workflowInstance(
                CheckStockWorkflow.class, options);
    }

    public void registerWorker() {
        workflowUtil.registerWorker(CHECK_STOCK_QUEUE, CheckStockWorkflowImpl.class
                , checkStockActivity);
    }
}
