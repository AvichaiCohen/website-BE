package com.userLogin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLogin.model.UserOrder;
import com.userLogin.repository.OrderListRepository;
import com.userLogin.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private OrderListRepository orderListRepository;
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public void createOrder(String username) {
            userOrderRepository.createOrder(username);
    }

    @Override
    public UserOrder getOrderById(String username,Long orderId)  {
        return userOrderRepository.getOrderById(username,orderId);
    }

    @Override
    public void updateOrderById(Long orderId, UserOrder userOrder) throws Exception {
            if (userOrderRepository.getOrderById(userOrder.getUsername(), orderId) != null)
            {
                userOrderRepository.updateOrderById(orderId,userOrder);
            } else {
                throw new Exception("No such order to update");
            }
    }
    @Override
    public void deleteOrderById(Long orderId,String username) throws Exception {
        if (userOrderRepository.getOrderById(username,orderId) == null) {
            throw new Exception("No such order exist");
        }
        else {
            userOrderRepository.deleteOrderById(orderId);
        }
    }
    @Override
    public List<UserOrder> getAllOrdersById(String username) throws Exception {
        if (userOrderRepository.getAllOrdersById(username) != null)
        {
            return userOrderRepository.getAllOrdersById(username);
        } else {
            throw new Exception("No such order");
        }
    }
}
