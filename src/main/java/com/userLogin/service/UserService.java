package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;

public interface UserService {
    void createUser(CustomUser customUser) throws Exception;
    void updateUserDetailsByAuth(CustomUser customUser,String username);
    void deleteUserDetailsByAuth(String username);

    CustomUser findUserByUsername(String username);

}
