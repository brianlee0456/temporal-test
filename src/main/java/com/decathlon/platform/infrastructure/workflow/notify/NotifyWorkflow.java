package com.decathlon.platform.infrastructure.workflow.notify;

import com.decathlon.platform.infrastructure.workflow.stock.CheckStockActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.time.Duration;
import java.util.List;

/**
 * @author: Brian
 * @date: 2022/11/29 15:06
 */
@WorkflowInterface
public interface NotifyWorkflow {

    @WorkflowMethod
    void notifyAccounts(List<Account> accounts);

    @QueryMethod
    int count();

}
