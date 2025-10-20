package com.ecobazzar.ecobazzar.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.ecobazzar.ecobazzar.model.Order;
import com.ecobazzar.ecobazzar.service.OrderService;

@RestController
@RequestMapping("/api/orders")

public class OrderController {


private final OrderService orderService;

public OrderController(OrderService orderService) {

this.orderService = orderService;

}


// Checkout (create new order)

@PostMapping("/checkout/{userId}")

public Order checkout(@PathVariable Long userId) {

return orderService.checkout(userId);

}
//View past orders

@GetMapping("/{userId}")

public List<Order> getUserOrders(@PathVariable Long userId) {

return orderService.getOrdersByUser(userId);

}

}