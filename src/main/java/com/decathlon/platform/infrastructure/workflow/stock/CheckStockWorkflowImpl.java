package com.decathlon.platform.infrastructure.workflow.stock;

import com.decathlon.platform.infrastructure.workflow.order.CreateOrderActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.List;

/**
 * @author: Brian
 * @date: 2022/11/28 17:05
 */
public class CheckStockWorkflowImpl implements CheckStockWorkflow {

    protected final CheckStockActivity activity =
            Workflow.newActivityStub(CheckStockActivity.class, ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(3))
                    .build());

    @Override
    public String checkStock(String itemId, int count) {
        List<Promise<String>> promises = List.of(
                Async.function(activity::checkStock, "1277", itemId, count)
                , Async.function(activity::checkStock, "996", itemId, count)
        );
        // Invoke all activities in parallel . Wait for first to complete
        return Promise.anyOf(promises).get();
    }
}
