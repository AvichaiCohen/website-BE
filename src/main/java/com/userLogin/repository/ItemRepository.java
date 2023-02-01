package com.userLogin.repository;

import com.userLogin.model.Item;
import java.util.List;

public interface ItemRepository {
    void createItem(Item item);
    Item getItemById(Long itemId);
    void updateItemById(Long itemId,Item item);
    void deleteItemById(Long itemId);
    List<Item> getAllItems();
}
