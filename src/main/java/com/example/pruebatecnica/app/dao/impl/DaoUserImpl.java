package com.example.pruebatecnica.app.dao.impl;

import com.example.pruebatecnica.app.dao.DaoUser;
import com.example.pruebatecnica.app.dao.dataModel.constant.ApiMessageHttp;
import com.example.pruebatecnica.app.dao.dataModel.constant.ErrorCode;
import com.example.pruebatecnica.app.dao.models.UserApp;
import com.example.pruebatecnica.app.dao.repositories.UserRepository;
import com.example.pruebatecnica.app.exception.DataSourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DaoUserImpl implements DaoUser {

    private final UserRepository userRepository;


    @Override
    public void saveUser(UserApp user) {
        try{
            userRepository.save(user);
        }
        catch (DataSourceException e){
            throw new DataSourceException(ErrorCode.CODIGO_GENERAL_ERROR_INTERNO_BACKEND, ApiMessageHttp.DB);
        }
    }

    @Override
    public UserApp searchUser(UserApp user) {

        try{
            return userRepository.getById(user.getId());
        }
        catch (DataSourceException e){
            throw new DataSourceException(ErrorCode.CODIGO_GENERAL_ERROR_INTERNO_BACKEND, ApiMessageHttp.DB);
        }
    }

    @Override
    public List<UserApp> searchUsers() {
        try{
            return userRepository.findAll();
        }
        catch (DataSourceException e){
            throw new DataSourceException(ErrorCode.CODIGO_GENERAL_ERROR_INTERNO_BACKEND, ApiMessageHttp.DB);
        }
    }
}
