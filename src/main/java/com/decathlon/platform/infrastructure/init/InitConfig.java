package com.decathlon.platform.infrastructure.init;

import com.decathlon.platform.infrastructure.workflow.price.ChangePriceWorkflowStarter;
import com.decathlon.platform.starter.temporal.WorkflowUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author: Brian
 * @date: 2022/11/29 10:04
 */
@Component
public class InitConfig implements ApplicationRunner {

    private final WorkflowUtil workflowUtil;

    public InitConfig(WorkflowUtil workflowUtil) {
        this.workflowUtil = workflowUtil;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        scheduledTaskStart();
        workflowUtil.workerStart();
    }

    private void scheduledTaskStart() {
        new ChangePriceWorkflowStarter(workflowUtil).start();
    }
}
