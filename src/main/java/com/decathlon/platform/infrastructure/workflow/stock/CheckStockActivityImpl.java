package com.decathlon.platform.infrastructure.workflow.stock;

import com.decathlon.platform.infrastructure.remote.StockClient;

/**
 * @author: Brian
 * @date: 2022/11/28 17:23
 */
public class CheckStockActivityImpl implements CheckStockActivity {

    private final StockClient stockClient;

    public CheckStockActivityImpl(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    @Override
    public String checkStock(String storeId, String itemId, int count) {
        return stockClient.checkStock(storeId, itemId, count);
    }
}
