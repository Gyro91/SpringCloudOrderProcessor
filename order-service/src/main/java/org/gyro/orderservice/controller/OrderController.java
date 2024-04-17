package org.gyro.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.gyro.orderservice.dto.OrderRequest;
import org.gyro.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
       orderService.placeOrder(orderRequest);
       return "Order Placed Succesfully";
    }
}
