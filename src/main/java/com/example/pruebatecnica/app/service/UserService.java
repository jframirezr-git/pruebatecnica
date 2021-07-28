package com.example.pruebatecnica.app.service;


import com.example.pruebatecnica.app.dao.dataModel.user.UserRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserResponse;
import com.example.pruebatecnica.app.dao.dataModel.user.UserSearchRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserSearchResponse;
import com.example.pruebatecnica.app.dao.models.UserApp;

import java.util.List;

public interface UserService {

    UserResponse saveUser(UserRequest request);

    UserSearchResponse searchUser(UserSearchRequest request);

    List<UserApp> searchAllUser();
}
