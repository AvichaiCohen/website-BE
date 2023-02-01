package com.userLogin.service;

import com.userLogin.model.Favourite;
import com.userLogin.model.UserOrder;

import java.util.List;

public interface FavouriteService {
    void createFavourite(String username)throws Exception;
    Favourite getFavouriteById(Long favouriteId) throws Exception;
    void updateFavouriteById(Long favouriteId, Favourite favourite) throws Exception;
    void deleteFavouriteById(Long favouriteId) throws Exception;
    List<Favourite> getAllFavouritesById(String username)throws Exception;
}
