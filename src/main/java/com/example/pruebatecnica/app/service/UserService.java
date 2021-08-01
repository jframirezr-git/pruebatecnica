package com.example.pruebatecnica.app.service;


import com.example.pruebatecnica.app.dao.dataModel.user.*;


public interface UserService {

    UserResponse saveUser(UserRequest request);

    UserSearchResponse searchUser(UserSearchRequest request);

    UserSearchAllResponse searchAllUser();
}
