package com.decathlon.platform.interfaces;

import com.decathlon.platform.interfaces.facade.OrderServiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/order")
    public String createOrder() {
        orderServiceFacade.createOrder("brian", "520667");
        return "ok";
    }

}
