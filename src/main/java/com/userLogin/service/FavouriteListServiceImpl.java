package com.userLogin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLogin.model.FavouriteList;
import com.userLogin.model.Item;
import com.userLogin.repository.FavouriteListRepository;
import com.userLogin.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteListServiceImpl implements FavouriteListService {


    @Autowired
    private FavouriteListRepository favouriteListRepository;
    @Autowired
    private ItemRepository itemRepository;


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createFavouriteList(FavouriteList favouriteList) throws Exception {
        favouriteListRepository.createFavouriteList(favouriteList);
    }

    @Override
    public void deleteItemInFavouriteList(FavouriteList favouriteList) {
        favouriteListRepository.deleteItemInFavouriteList(favouriteList);
    }

    @Override
    public void deleteFavouriteList(String username) throws Exception {
        favouriteListRepository.deleteFavouriteList(username);
    }

    @Override
    public List<Item> getAllFavouriteListByFavouriteId(String username) throws Exception {
        List<Item> orderItem = new ArrayList<>();
        List<FavouriteList> favouriteLists = new ArrayList<>(favouriteListRepository.getAllFavouriteListByFavouriteId(username));
        for (int i = 0; i < favouriteLists.size(); i++) {
            orderItem.add(itemRepository.getItemById(favouriteLists.get(i).getItemId()));
        }
        return orderItem;
    }
}
