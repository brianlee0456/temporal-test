package com.decathlon.platform.infrastructure.workflow.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author: Brian
 * @date: 2022/12/1 11:12
 */
public class ChangePriceWorkflowImpl implements ChangePriceWorkflow {

    private final static Logger LOGGER = LoggerFactory.getLogger(ChangePriceWorkflow.class);
    @Override
    public void changePrice(String itemId, BigDecimal price) {
        LOGGER.info("Item {} price has been changed.",itemId);
    }
}
