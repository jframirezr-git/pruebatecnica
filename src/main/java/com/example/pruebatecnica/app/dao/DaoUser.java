package com.example.pruebatecnica.app.dao;

import com.example.pruebatecnica.app.dao.dataModel.user.SearchUser;
import com.example.pruebatecnica.app.dao.models.UserApp;

import java.util.List;
import java.util.Optional;


public interface DaoUser {

    /**
     * Save user
     *
     * @param user
     */
    void saveUser(UserApp user);

    /**
     * Search user
     * @param userSearch
     * @return
     */
    Optional<UserApp> searchUser(SearchUser userSearch);

    /**
     * Search all users
     * @return
     */
    List<UserApp> searchUsers();
}
