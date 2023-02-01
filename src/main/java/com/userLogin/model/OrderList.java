package com.userLogin.model;

public class OrderList {
    private Long orderListId;
    private String username;
    private Long itemId;
    private Long quantityOfItem;

    public OrderList(Long orderListId, String username, Long itemId, Long quantityOfItem) {
        this.orderListId = orderListId;
        this.username = username;
        this.itemId = itemId;
        this.quantityOfItem = quantityOfItem;
    }

    public Long getOrderListId() {
        return orderListId;
    }

    public String getUsername() {
        return username;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getQuantityOfItem() {
        return quantityOfItem;
    }

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantityOfItem(Long quantityOfItem) {
        this.quantityOfItem = quantityOfItem;
    }
}
