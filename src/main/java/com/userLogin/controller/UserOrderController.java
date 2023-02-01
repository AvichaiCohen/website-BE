package com.userLogin.controller;

import com.userLogin.model.UserOrder;
import com.userLogin.service.OrderListService;
import com.userLogin.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/website/order")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @PostMapping(value = "/create")
    @CrossOrigin
    public void createUserOrder(@RequestParam String username ) throws Exception {
        userOrderService.createOrder(username);
    }
    @GetMapping(value = "/get")
    @CrossOrigin
    public UserOrder getUserOrderBy(@RequestParam String username,Long orderId) throws Exception {
        return userOrderService.getOrderById(username,orderId);
    }
    @GetMapping(value = "/getAll")
    @CrossOrigin
    public List<UserOrder> getAllUserOrderBy(@RequestParam String username) throws Exception {
        return userOrderService.getAllOrdersById(username);
    }

    @PutMapping(value = "/update")
    @CrossOrigin
    public void updateUserOrderById(@RequestParam Long orderId,
                               @RequestBody UserOrder userOrder) throws Exception {
        userOrderService.updateOrderById(orderId, userOrder);
    }

    @DeleteMapping(value = "/delete")
    @CrossOrigin
    public void deleteOrderById(@RequestParam Long orderId,String username) throws Exception {
        userOrderService.deleteOrderById(orderId,username);
    }
}
