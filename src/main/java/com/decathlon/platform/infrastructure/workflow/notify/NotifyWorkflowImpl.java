package com.decathlon.platform.infrastructure.workflow.notify;

import com.decathlon.platform.infrastructure.workflow.stock.CheckStockActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

/**
 * @author: Brian
 * @date: 2022/11/29 15:07
 */
public class NotifyWorkflowImpl implements NotifyWorkflow {

    private int count;
    private final static Logger LOGGER = LoggerFactory.getLogger(NotifyWorkflow.class);

    protected final NotifyActivity activity =
            Workflow.newActivityStub(NotifyActivity.class, ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(3))
                    .build());

    @Override
    public void notifyAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            activity.notifyAccount(account);
            count++;
        }
        LOGGER.info("{} accounts has been notified.", count);
    }

    @Override
    public int count() {
        return count;
    }
}
