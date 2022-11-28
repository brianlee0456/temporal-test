package com.decathlon.platform.infrastructure.workflow;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * @author: Brian
 * @date: 2022/11/20 15:55
 */
public abstract class AbstractCreateOrderWorkflow implements CreateOrderWorkflow{

    protected static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderWorkflow.class);

    protected final CreateOrderActivities activities =
            Workflow.newActivityStub(CreateOrderActivities.class, ActivityOptions.newBuilder()
//                            .setRetryOptions(RetryOptions.newBuilder()
//                                    .setInitialInterval(Duration.ofSeconds(1))
//                                    .setMaximumInterval(Duration.ofSeconds(60))
//                                    .setMaximumAttempts(1)
//                                    .setDoNotRetry(NullPointerException.class.getName())
//                                    .build())
                    .setStartToCloseTimeout(Duration.ofSeconds(3))
                    .build());
}
