package com.example.pruebatecnica.app.service.impl;

import com.example.pruebatecnica.app.dao.DaoUser;
import com.example.pruebatecnica.app.dao.dataModel.user.*;
import com.example.pruebatecnica.app.dao.models.Profile;
import com.example.pruebatecnica.app.dao.models.UserApp;
import com.example.pruebatecnica.app.dao.specification.DaoProfile;
import com.example.pruebatecnica.app.exception.DataSourceException;
import com.example.pruebatecnica.app.service.UserService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final DaoUser daoUser;
    private final MapperFacade mapperFacade;
    private final DaoProfile daoProfile;

    @Override
    public UserResponse saveUser(UserRequest request) {

        Date now = new Date();

        Profile profile = daoProfile.searchProfile(request.getRoleId());

        SearchUser searchUser = SearchUser.builder().name(request.getName()).build();
        Optional<UserApp> user = daoUser.searchUser(searchUser);

        if(user.isPresent()){
            return UserResponse.builder().response(false).message("Ya existe un usuario registrado con ese nombre").build();
        }

        daoUser.saveUser(UserApp.builder().name(request.getName())
                .year(request.getYear())
                .startDate(now)
                .profile(profile)
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
    public UserSearchAllResponse searchAllUser(){
        ArrayList<UserDto> userDtos = new ArrayList<>();

        daoUser.searchUsers().stream().forEach(userApp -> {
            UserDto userDto = mapperFacade.map(userApp, UserDto.class);
            userDtos.add(userDto);
        });

        return UserSearchAllResponse.builder()
                .userDtos(userDtos)
                .build();
    }
}
