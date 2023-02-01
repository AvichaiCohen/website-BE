package com.userLogin.model;

public class Item {
    private Long itemID;
    private String title;
    private String photo;
    private Long price;
    private Long inStock;

    public Item(Long itemID, String title, String photo, Long price, Long inStock) {
        this.itemID = itemID;
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.inStock = inStock;
    }

    public Long getItemID() {
        return itemID;
    }

    public String getTitle() {
        return title;
    }

    public String getPhoto() {
        return photo;
    }

    public Long getPrice() {
        return price;
    }

    public Long getInStock() {
        return inStock;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setInStock(Long inStock) {
        this.inStock = inStock;
    }
}
