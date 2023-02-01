package com.userLogin.service;

import com.userLogin.model.Item;
import com.userLogin.model.OrderList;
import java.util.List;

public interface OrderListService {
    void createOrderList(OrderList orderList)throws Exception;
    void deleteItemInList(String username,Long itemId) throws Exception;
    void deleteList(String username) throws Exception;
    List<Item> getAllOrdersByUsername(String username)throws Exception;
}
