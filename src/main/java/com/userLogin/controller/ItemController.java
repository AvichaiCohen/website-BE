package com.userLogin.controller;

import com.userLogin.model.FavouriteList;
import com.userLogin.model.Item;
import com.userLogin.model.OrderList;
import com.userLogin.service.FavouriteListService;
import com.userLogin.service.ItemService;
import com.userLogin.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/website/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private FavouriteListService favouriteListService;

    @GetMapping(value = "/getAll")
    @CrossOrigin
    public List<Item> getItemlist() throws Exception {
        return itemService.getAllItems();
    }
    @GetMapping(value = "/get")
    @CrossOrigin
    public Item getItem(@RequestParam Long itemId) throws Exception {
        return itemService.getItemById(itemId);
    }
    @PostMapping(value = "/order/add")
    @CrossOrigin
    public void addItemToOrder(@RequestBody OrderList orderList) throws Exception{
        orderListService.createOrderList(orderList);
    }
    @DeleteMapping(value = "/order/delete")
    @CrossOrigin
    public void deleteItemFromOrder(@RequestParam String username,Long itemId) throws Exception{
        orderListService.deleteItemInList(username,itemId);
    }
    @DeleteMapping(value = "/order/list/delete")
    @CrossOrigin
    public void deleteList(@RequestParam String username) throws Exception{
        orderListService.deleteList(username);
    }

    @PostMapping(value ="/favourite/add")
    @CrossOrigin
    public void addItemToFavourite(@RequestBody FavouriteList favouriteList) throws Exception{
        favouriteListService.createFavouriteList(favouriteList);
    }
    @DeleteMapping(value = "/favourite/delete")
    @CrossOrigin
    public void deleteItemFromOrder(@RequestBody FavouriteList favouriteList) throws Exception{
        favouriteListService.deleteItemInFavouriteList(favouriteList);
    }
    @DeleteMapping(value = "/favourite/list/delete")
    @CrossOrigin
    public void deleteFavList(@RequestParam String username) throws Exception{
        favouriteListService.deleteFavouriteList(username);
    }

    @GetMapping(value = "/order/get/list")
    @CrossOrigin
    public List<Item> getItemsByUser(@RequestParam String username)throws Exception{
        return orderListService.getAllOrdersByUsername(username);
    }
    @GetMapping(value = "/favourite/get/list")
    @CrossOrigin
    public List<Item> getFaItemsByUser(@RequestParam String username)throws Exception{
        return favouriteListService.getAllFavouriteListByFavouriteId(username);
    }
}
