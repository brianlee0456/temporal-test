package com.decathlon.platform.infrastructure.workflow;

import com.decathlon.platform.applications.OrderService;
import com.decathlon.platform.infrastructure.remote.CouponClient;
import com.decathlon.platform.infrastructure.remote.EnergyPointClient;
import com.decathlon.platform.infrastructure.remote.StockClient;
import com.decathlon.platform.infrastructure.workflow.order.CreateOrderWorkflowFactory;
import com.decathlon.platform.infrastructure.workflow.stock.CheckStockWorkflowFactory;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Brian
 * @date: 2022/11/20 14:46
 */
@Configuration
public class WorkflowConfig{

    private final WorkflowUtil workflowUtil;

    public WorkflowConfig(WorkflowUtil workflowUtil) {
        this.workflowUtil = workflowUtil;
    }

    @Bean
    public CreateOrderWorkflowFactory createOrderWorkflowFactory(OrderService orderService
            , CouponClient couponClient, EnergyPointClient energyPointClient, StockClient stockClient) {
        return new CreateOrderWorkflowFactory(workflowUtil, orderService
                , couponClient, energyPointClient, stockClient);
    }

    @Bean
    public CheckStockWorkflowFactory checkStockWorkflowFactory(StockClient stockClient) {
        return new CheckStockWorkflowFactory(workflowUtil,stockClient);
    }
}
