package com.decathlon.platform.infrastructure.workflow.notify;

import io.temporal.activity.ActivityInterface;

/**
 * @author: Brian
 * @date: 2022/11/29 15:19
 */
@ActivityInterface
public interface NotifyActivity {

    void notifyAccount(Account account);

}
