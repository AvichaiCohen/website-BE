package com.userLogin.model;

public class FavouriteList {
    private Long favouriteId;
    private String username;
    private Long itemId;
    private Long quantityOfItem;

    public FavouriteList(Long favouriteId, String username, Long itemId, Long quantityOfItem) {
        this.favouriteId = favouriteId;
        this.username = username;
        this.itemId = itemId;
        this.quantityOfItem = quantityOfItem;
    }

    public Long getFavouriteId() {
        return favouriteId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getQuantityOfItem() {
        return quantityOfItem;
    }

    public void setFavouriteId(Long favouriteId) {
        this.favouriteId = favouriteId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantityOfItem(Long quantityOfItem) {
        this.quantityOfItem = quantityOfItem;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
