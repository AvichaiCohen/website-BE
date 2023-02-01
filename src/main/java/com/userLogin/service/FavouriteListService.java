package com.userLogin.service;

import com.userLogin.model.FavouriteList;
import com.userLogin.model.Item;

import java.util.List;

public interface FavouriteListService {
    void createFavouriteList(FavouriteList favouriteList)throws Exception;
    void deleteItemInFavouriteList(FavouriteList favouriteList);
    void deleteFavouriteList(String username) throws Exception;
    List<Item> getAllFavouriteListByFavouriteId(String username)throws Exception;
    }
