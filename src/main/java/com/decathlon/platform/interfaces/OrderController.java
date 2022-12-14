package com.decathlon.platform.interfaces;

import com.decathlon.platform.interfaces.facade.OrderServiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Brian
 * @date: 2022/11/20 13:53
 */
@RestController
public class OrderController {

    private final OrderServiceFacade orderServiceFacade;

    public OrderController(OrderServiceFacade orderServiceFacade) {
        this.orderServiceFacade = orderServiceFacade;
    }

    @GetMapping("/order/{itemId}")
    public String createOrder(@PathVariable String itemId) {
        orderServiceFacade.createOrder("brian", itemId);
        return "ok";
    }

    @GetMapping("/checkstock/{itemId}")
    public String checkStock(@PathVariable String itemId, int count) {
        return orderServiceFacade.checkStock(itemId,count);
    }

    @GetMapping("/notify")
    public String notifyAccount(){
        orderServiceFacade.notifyAccounts();
        return "ok";
    }
}
