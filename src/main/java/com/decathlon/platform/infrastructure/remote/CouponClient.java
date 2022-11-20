package com.decathlon.platform.infrastructure.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: Brian
 * @date: 2022/11/20 14:02
 */
@Component
public class CouponClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(CouponClient.class);

    public void customerUseCoupon(String customerId) {
        LOGGER.info("Customer {} use one coupon", customerId);
    }

    public void addCouponToCustomer(String customerId) {
        LOGGER.info("Add to coupon to customer {}", customerId);
    }
}
