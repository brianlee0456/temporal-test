package fun;

import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.util.List;

/**
 * @author: Brian
 * @date: 2022/10/30 19:55
 */
@WorkflowInterface
public interface NotifyAccountWorkflow {

    @WorkflowMethod
     void notifyAccounts(String[] accounts);

    @QueryMethod
    int queryCount();

}
