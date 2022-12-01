package com.decathlon.platform.infrastructure.workflow.price;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.math.BigDecimal;

/**
 * @author: Brian
 * @date: 2022/12/1 11:10
 */
@WorkflowInterface
public interface ChangePriceWorkflow {

    @WorkflowMethod
    void changePrice(String itemId, BigDecimal price);
}
