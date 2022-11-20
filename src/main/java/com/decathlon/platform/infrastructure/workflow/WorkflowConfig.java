package com.decathlon.platform.infrastructure.workflow;

import com.decathlon.platform.applications.OrderService;
import com.decathlon.platform.infrastructure.remote.CouponClient;
import com.decathlon.platform.infrastructure.remote.EnergyPointClient;
import com.decathlon.platform.infrastructure.remote.StockClient;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Brian
 * @date: 2022/11/20 14:46
 */
@Configuration
public class WorkflowConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkflowConfig.class);
    private static final String CREATE_ORDER_QUEUE = "CREATE_ORDER_QUEUE";

    private final WorkflowUtil workflowUtil;

    public WorkflowConfig(WorkflowUtil workflowUtil) {
        this.workflowUtil = workflowUtil;
    }

    @Bean
    public CreateOrderWorkflow createOrderWorkflow(OrderService orderService, CouponClient couponClient
            , EnergyPointClient energyPointClient, StockClient stockClient) {
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(CREATE_ORDER_QUEUE)
                .build();
        CreateOrderWorkflow postToCheckoutWorkflow = workflowUtil.workflowInstance(
                CreateOrderWorkflow.class, options);

        workflowUtil.registerWorker(CREATE_ORDER_QUEUE, CreateOrderWorkflowImpl.class
                , new CreateOrderActivitiesImpl(orderService, couponClient, energyPointClient, stockClient));

        workflowUtil.workerStart();
        LOGGER.info("Worker started for task queue " + CREATE_ORDER_QUEUE);
        return postToCheckoutWorkflow;
    }
}
