package com.example.pruebatecnica.app.service.impl;

import com.example.pruebatecnica.app.dao.DaoUser;
import com.example.pruebatecnica.app.dao.dataModel.user.SearchUser;
import com.example.pruebatecnica.app.dao.dataModel.user.UserDto;
import com.example.pruebatecnica.app.dao.dataModel.user.UserRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserResponse;
import com.example.pruebatecnica.app.dao.dataModel.user.UserSearchRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserSearchResponse;
import com.example.pruebatecnica.app.dao.models.UserApp;
import com.example.pruebatecnica.app.exception.DataSourceException;
import com.example.pruebatecnica.app.service.UserService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final DaoUser daoUser;
    private final MapperFacade mapperFacade;

    @Override
    public UserResponse saveUser(UserRequest request) {

        SearchUser searchUser = SearchUser.builder().name(request.getName()).build();
        Optional<UserApp> user = daoUser.searchUser(searchUser);

        if(user.isPresent()){
            return UserResponse.builder().response(false).message("Ya existe un usuario registrado con ese nombre").build();
        }

        daoUser.saveUser(UserApp.builder().name(request.getName())
                .year(request.getYear())
                .startDate(request.getStartDate())
                .build());

        return UserResponse.builder().response(true).message("Petición realizada correctamente").build();
    }

    @Override
    public UserSearchResponse searchUser(UserSearchRequest request){

        SearchUser searchUser = SearchUser.builder().name(request.getName()).build();
        Optional<UserApp> user = daoUser.searchUser(searchUser);
        UserApp userfind = user.orElseThrow(() -> new DataSourceException(1000, "Usuario no existe"));
        UserDto userDto = mapperFacade.map(userfind, UserDto.class);
        return UserSearchResponse.builder().users(userDto).build();
    }

    @Override
    public List<UserApp> searchAllUser(){
       return daoUser.searchUsers();
    }
}
