package com.decathlon.platform.infrastructure.workflow.order;

import com.decathlon.platform.applications.OrderService;
import com.decathlon.platform.infrastructure.remote.CouponClient;
import com.decathlon.platform.infrastructure.remote.EnergyPointClient;
import com.decathlon.platform.infrastructure.remote.StockClient;
import com.decathlon.platform.infrastructure.workflow.common.AbstractWorkflowFactory;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import io.temporal.client.WorkflowOptions;

import java.time.Duration;

/**
 * @author: Brian
 * @date: 2022/11/28 16:08
 */
public class CreateOrderWorkflowFactory extends AbstractWorkflowFactory<CreateOrderWorkflow> {

    private static final String CREATE_ORDER_QUEUE = "CREATE_ORDER_QUEUE";
    private final CreateOrderActivities createOrderActivities;

    public CreateOrderWorkflowFactory(WorkflowUtil workflowUtil, OrderService orderService, CouponClient couponClient
            , EnergyPointClient energyPointClient, StockClient stockClient) {
        super(workflowUtil);
        this.createOrderActivities = new CreateOrderActivitiesImpl(orderService, couponClient, energyPointClient, stockClient);
        registerWorker();
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

    public void registerWorker() {
        workflowUtil.registerWorker(CREATE_ORDER_QUEUE, CreateOrderWorkflowSagaImpl.class
                , createOrderActivities);
    }
}
