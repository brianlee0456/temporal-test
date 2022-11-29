package com.decathlon.platform.infrastructure.workflow.stock;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

/**
 * @author: Brian
 * @date: 2022/11/28 17:02
 */
@WorkflowInterface
public interface CheckStockWorkflow {

    /**
     * @param itemId the item id
     * @param count count
     * @return available store
     */
    @WorkflowMethod
    String checkStock(String itemId, int count);

}
