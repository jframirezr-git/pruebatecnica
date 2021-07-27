package com.example.pruebatecnica.app.dao;

import com.example.pruebatecnica.app.dao.models.UserApp;

import java.util.List;


public interface DaoUser {

    /**
     * Save user
     *
     * @param user
     */
    void saveUser(UserApp user);

    /**
     * Search user
     * @param user
     * @return
     */
    UserApp searchUser(UserApp user);

    /**
     * Search all users
     * @return
     */
    List<UserApp> searchUsers();
}
