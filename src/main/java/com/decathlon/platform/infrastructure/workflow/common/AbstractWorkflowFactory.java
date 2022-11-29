package com.decathlon.platform.infrastructure.workflow.common;

import com.decathlon.platform.starter.temporal.WorkflowUtil;

/**
 * @author: Brian
 * @date: 2022/11/29 16:04
 */
public abstract class AbstractWorkflowFactory<T> {

    protected final WorkflowUtil workflowUtil;

    protected AbstractWorkflowFactory(WorkflowUtil workflowUtil) {
        this.workflowUtil = workflowUtil;
    }

    public abstract T create();

    public abstract void registerWorker();
}
