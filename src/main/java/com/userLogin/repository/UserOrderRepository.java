package com.userLogin.repository;


import com.userLogin.model.UserOrder;

import java.util.List;

public interface UserOrderRepository {
    void createOrder(String username);
    UserOrder getOrderById(String username,Long orderId);
    void updateOrderById(Long orderId,UserOrder userOrder);
    void deleteOrderById(Long orderId);
    List<UserOrder> getAllOrdersById(String username);

}
