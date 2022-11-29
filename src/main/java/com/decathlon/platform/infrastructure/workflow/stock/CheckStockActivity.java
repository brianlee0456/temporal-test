package com.decathlon.platform.infrastructure.workflow.stock;

import io.temporal.activity.ActivityInterface;

/**
 * @author: Brian
 * @date: 2022/11/28 17:07
 */
@ActivityInterface
public interface CheckStockActivity {

    String checkStock(String storeId, String itemId, int count);

}
