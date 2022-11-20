package com.decathlon.platform.infrastructure.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Brian
 * @date: 2022/11/20 14:01
 */
@Component
public class EnergyPointClient {

    private final Logger LOGGER = LoggerFactory.getLogger(EnergyPointClient.class);

    public void addEnergyPoint(String customerId, int energyPoint) {
        LOGGER.info("Add {} energy point to customer {}", energyPoint, customerId);
    }

    public void removeEnergyPoint(String customerId, int energyPoint) {
        LOGGER.info("Remove {} energy point from customer {}", energyPoint, customerId);
    }
}
