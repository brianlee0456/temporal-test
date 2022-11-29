package com.decathlon.platform.infrastructure.workflow.notify;

import com.decathlon.platform.infrastructure.workflow.common.AbstractWorkflowFactory;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import io.temporal.client.WorkflowOptions;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author: Brian
 * @date: 2022/11/29 16:02
 */
@Component
public class NotifyWorkflowFactory extends AbstractWorkflowFactory<NotifyWorkflow> {

    private static final String NOTIFY_ACCOUNT_QUEUE = "NOTIFY_ACCOUNT_QUEUE";
    private final NotifyActivity notifyActivity = new NotifyActivityImpl();

    protected NotifyWorkflowFactory(WorkflowUtil workflowUtil) {
        super(workflowUtil);
        registerWorker();
    }

    @Override
    public NotifyWorkflow create() {
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(NOTIFY_ACCOUNT_QUEUE)
                //whole progress
                .setWorkflowExecutionTimeout(Duration.ofHours(10))
                //one invocation
                .setWorkflowRunTimeout(Duration.ofHours(10))
                .build();
        return workflowUtil.workflowInstance(
                NotifyWorkflow.class, options);
    }

    @Override
    public void registerWorker() {
        workflowUtil.registerWorker(NOTIFY_ACCOUNT_QUEUE, NotifyWorkflowImpl.class
                , notifyActivity);
    }
}
