package com.userLogin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLogin.model.*;
import com.userLogin.repository.OrderListRepository;
import com.userLogin.repository.UserOrderRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private OrderListRepository orderListRepository;
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @Override
    public void createOrder(UserOrder userOrder) throws Exception {
//        if (userService.findUserByUsername(userOrder.getUsername()) == null) {
//            throw new Exception ("not exist");
//        }else {
        List<OrderList> orderLists = new ArrayList<>(orderListRepository.getAllOrdersByUsername(userOrder.getUsername()));
        List<Item> orderItemlist = new ArrayList<>();
        Long totalPrice = null;
        for (int i = 0; i < orderLists.size(); i++) {
            orderItemlist.add(itemService.getItemById(orderLists.get(i).getItemId()));
            totalPrice += orderItemlist.get(i).getPrice();
        }
        String shippingAddress = (userService.findUserByUsername(userOrder.getUsername()).getCountry()) + " " + (userService.findUserByUsername(userOrder.getUsername()).getCity());
        UserOrder newUserOrder = new UserOrder(null, userOrder.getUsername(), userOrder.getOrderDate(), totalPrice, shippingAddress, OrderStatus.valueOf("CLOSE"));
        userOrderRepository.createOrder(newUserOrder);
        System.out.println(totalPrice);
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
