package com.userLogin.repository;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;

public interface UserRepository {
    void createUser(CustomUser customUser);
    void updateUserDetailsByAuth(CustomUser customUser,String username);
    void deleteUserById(String username);
    CustomUser findUserByUsername(String username);
}
