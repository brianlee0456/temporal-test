package fun;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

/**
 * @author: Brian
 * @date: 2022/10/30 19:57
 */
public class NotifyAccountWorkflowStarter {

    public static void main(String[] args) {

        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(WorkFlowUtil.TASK_QUEUE)
                .build();

        NotifyAccountWorkflow notifyAccountWorkflow = WorkFlowUtil.client
                .newWorkflowStub(NotifyAccountWorkflow.class, options);

        WorkflowClient.start(notifyAccountWorkflow::notifyAccounts,new String[] { "Account1", "Account2", "Account3", "Account4", "Account5",
                "Account6", "Account7", "Account8", "Account9", "Account10"});

        System.out.println("Notify account requested.");
    }
}
