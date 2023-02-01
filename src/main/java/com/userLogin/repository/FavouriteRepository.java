package com.userLogin.repository;

import com.userLogin.model.Favourite;
import com.userLogin.model.UserOrder;

import java.util.List;

public interface FavouriteRepository {
    void createFavourite(String username);
    Favourite getFavouriteById(Long favouriteId);
    void deleteFavouriteById(Long favouriteId);
    List<Favourite> getAllFavouritesByUserId(String username);
}
