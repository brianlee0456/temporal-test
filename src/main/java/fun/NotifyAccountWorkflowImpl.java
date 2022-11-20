package fun;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.List;

/**
 * @author: Brian
 * @date: 2022/10/30 19:56
 */
public class NotifyAccountWorkflowImpl implements NotifyAccountWorkflow {

    private int count;

    private final AccountActivity accountActivities =
            Workflow.newActivityStub(AccountActivity.class, ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(3))
                    .build());

    @Override
    public void notifyAccounts(String[] accounts) {
        for (String account : accounts) {
            count++;
            accountActivities.notify(account);
            Workflow.sleep(Duration.ofSeconds(2));
        }
    }

    @Override
    public int queryCount() {
        return count;
    }
}
