package com.pdt.controllers;

import com.pdt.models.OrdersVm;
import com.pdt.services.contracts.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{username}")
    public ResponseEntity<List<OrdersVm>> getOrders(@PathVariable("username") String username){
        return ResponseEntity.ok(orderService.getOrders(username));
    }
}
