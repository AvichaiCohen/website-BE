package com.userLogin.service;

import com.userLogin.model.Favourite;
import com.userLogin.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;


    @Override
    public void createFavourite(String username) throws Exception {
        favouriteRepository.createFavourite(username);
    }

    @Override
    public Favourite getFavouriteById(Long favouriteId) throws Exception {
        return favouriteRepository.getFavouriteById(favouriteId);
    }

    @Override
    public void updateFavouriteById(Long favouriteId, Favourite favourite) throws Exception {

    }

    @Override
    public void deleteFavouriteById(Long favouriteId) throws Exception {
        favouriteRepository.deleteFavouriteById(favouriteId);
    }

    @Override
    public List<Favourite> getAllFavouritesById(String username) throws Exception {
        return favouriteRepository.getAllFavouritesByUserId(username);
    }
}
