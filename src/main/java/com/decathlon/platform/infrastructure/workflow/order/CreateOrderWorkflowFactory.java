package com.decathlon.platform.infrastructure.workflow.order;

import com.decathlon.platform.applications.OrderService;
import com.decathlon.platform.infrastructure.remote.CouponClient;
import com.decathlon.platform.infrastructure.remote.EnergyPointClient;
import com.decathlon.platform.infrastructure.remote.StockClient;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import io.temporal.client.WorkflowOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * @author: Brian
 * @date: 2022/11/28 16:08
 */
public class CreateOrderWorkflowFactory {

    private final WorkflowUtil workflowUtil;
    private static final String CREATE_ORDER_QUEUE = "CREATE_ORDER_QUEUE";
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderWorkflowFactory.class);
    private final CreateOrderActivities createOrderActivities;

    public CreateOrderWorkflowFactory(WorkflowUtil workflowUtil, OrderService orderService, CouponClient couponClient
            , EnergyPointClient energyPointClient, StockClient stockClient) {
        this.workflowUtil = workflowUtil;
        this.createOrderActivities = new CreateOrderActivitiesImpl(orderService, couponClient, energyPointClient, stockClient);
        startWorker();
    }

    public CreateOrderWorkflow create() {
        return createOrderWorkflow();
    }

    private CreateOrderWorkflow createOrderWorkflow() {
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(CREATE_ORDER_QUEUE)
                //whole progress
                .setWorkflowExecutionTimeout(Duration.ofHours(10))
                //one invocation
                .setWorkflowRunTimeout(Duration.ofHours(10))
                .build();
        return workflowUtil.workflowInstance(
                CreateOrderWorkflow.class, options);
    }

    private void startWorker() {
        //CreateOrderWorkflowImpl
        //CreateOrderWorkflowAsyncImpl
        //CreateOrderWorkflowSagaImpl
        workflowUtil.registerWorker(CREATE_ORDER_QUEUE, CreateOrderWorkflowSagaImpl.class
                , createOrderActivities);

        workflowUtil.workerStart();
        LOGGER.info("Worker started for task queue " + CREATE_ORDER_QUEUE);
    }
}
