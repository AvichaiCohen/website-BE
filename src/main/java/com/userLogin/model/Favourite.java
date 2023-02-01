package com.userLogin.model;

public class Favourite {
    private Long favoriteId;
    private Long userId;

    public Favourite(Long favoriteId, Long userId) {
        this.favoriteId = favoriteId;
        this.userId = userId;
    }

    public Long getFavoriteId() {
        return favoriteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
