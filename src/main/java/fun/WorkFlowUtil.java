package fun;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.WorkerFactory;

/**
 * @author: Brian
 * @date: 2022/10/30 20:02
 */
public class WorkFlowUtil {

    public static final String TASK_QUEUE = "AccountNotify1";
    // Get worker to poll the common task queue.
    // gRPC stubs wrapper that talks to the local docker instance of temporal service.
    public static final WorkflowServiceStubs service;
    // client that can be used to start and signal workflows
    public static final WorkflowClient client;

    public static final WorkerFactory factory;

    static {
        service = WorkflowServiceStubs.newLocalServiceStubs();
        client = WorkflowClient.newInstance(service);
        factory = WorkerFactory.newInstance(client);
    }

}
