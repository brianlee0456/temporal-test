package com.decathlon.platform.infrastructure.workflow.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Brian
 * @date: 2022/11/29 15:25
 */
public class NotifyActivityImpl implements NotifyActivity {

    private final static Logger LOGGER = LoggerFactory.getLogger(NotifyActivity.class);

    @Override
    public void notifyAccount(Account account) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Account {} notified.",account.getAccountId());
    }
}
