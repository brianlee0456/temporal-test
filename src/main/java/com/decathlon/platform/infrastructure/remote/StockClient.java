package com.decathlon.platform.infrastructure.remote;

import io.temporal.internal.sync.WorkflowThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Brian
 * @date: 2022/11/20 14:01
 */
@Component
public class StockClient {

    private final Logger LOGGER = LoggerFactory.getLogger(StockClient.class);

    public void decreaseStock(String itemId) {
        LOGGER.info("Decrease stock to item {}", itemId);
        throw new NullPointerException();
    }

    public void increaseStock(String itemId) {
        LOGGER.info("Increase stock to item {}", itemId);
    }
}
