package com.userLogin.repository;

import com.userLogin.model.FavouriteList;

import java.util.List;

public interface FavouriteListRepository {
    void createFavouriteList(FavouriteList favouriteList);

    void deleteItemInFavouriteList(FavouriteList favouriteList);
    void deleteFavouriteList(String username);
    List<FavouriteList> getAllFavouriteListByFavouriteId(String username);
}
