package com.userLogin.controller;

import com.userLogin.model.Favourite;
import com.userLogin.model.Item;
import com.userLogin.model.OrderList;
import com.userLogin.model.UserOrder;
import com.userLogin.service.FavouriteListService;
import com.userLogin.service.FavouriteService;
import com.userLogin.service.ItemService;
import com.userLogin.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/website/favourite")
public class FavouriteController {
    @Autowired
    private FavouriteService favouriteService;

    @Autowired
    private FavouriteListService favouriteListService;

        @PostMapping(value = "/create")
        @CrossOrigin
        public void createUserfavourite(@RequestParam String username ) throws Exception {
            favouriteService.createFavourite(username);
        }
        @GetMapping(value = "/get")
        @CrossOrigin
        public Favourite getUserFavourite(@RequestParam Long favouriteId) throws Exception {
            return favouriteService.getFavouriteById(favouriteId);
        }
        @GetMapping(value = "/getAll")
        @CrossOrigin
        public List<Favourite> getAllUserFavourite(@RequestParam String username) throws Exception {
            return favouriteService.getAllFavouritesById(username);
        }

        @PutMapping(value = "/update")
        @CrossOrigin
        public void updateUserFavourite(@RequestParam Long favouriteId,
                @RequestBody Favourite favourite) throws Exception {
            favouriteService.updateFavouriteById(favouriteId,favourite );
        }

        @DeleteMapping(value = "/delete")
        @CrossOrigin
        public void deleteOrderById(@RequestParam Long favouriteId) throws Exception {
            favouriteService.deleteFavouriteById(favouriteId);
        }
}
