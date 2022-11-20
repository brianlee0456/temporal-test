package fun;

import io.temporal.worker.Worker;

/**
 * @author: Brian
 * @date: 2022/10/30 20:12
 */
public class NotifyAccountWorkerStarter {

    public static void main(String[] args) {
        Worker worker = WorkFlowUtil.factory.newWorker(WorkFlowUtil.TASK_QUEUE);
        // workflow interface impl
        worker.registerWorkflowImplementationTypes(NotifyAccountWorkflowImpl.class);
        worker.registerActivitiesImplementations(new AccountActivityImpl());
        // Start all workers created by this factory.
        WorkFlowUtil.factory.start();
        System.out.println("Worker started for task queue: " + WorkFlowUtil.TASK_QUEUE);
    }
}
