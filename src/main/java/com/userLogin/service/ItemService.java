package com.userLogin.service;

import com.userLogin.model.Item;


import java.util.List;

public interface ItemService {
    void createItem(Item item)throws Exception;
    Item getItemById(Long itemId) throws Exception;
    void deleteItemById(Long ItemId) throws Exception;
    List<Item> getAllItems()throws Exception;
}
