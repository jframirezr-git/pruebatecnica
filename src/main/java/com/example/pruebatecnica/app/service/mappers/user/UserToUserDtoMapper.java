package com.example.pruebatecnica.app.service.mappers.user;

import com.example.pruebatecnica.app.dao.dataModel.product.ProductDto;
import com.example.pruebatecnica.app.dao.dataModel.user.UserDto;
import com.example.pruebatecnica.app.dao.models.UserApp;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class UserToUserDtoMapper extends CustomMapper<UserApp, UserDto> {
    @Override
    public void mapAtoB(UserApp userApp, UserDto userDto, MappingContext context) {
        userDto.setId(userApp.getId());
        userDto.setName(userApp.getName());
        userDto.setStartDate(userApp.getStartDate());
        userDto.setYear(userApp.getYear());
        userDto.setProductDtoList(mapperFacade.mapAsList(userApp.getProducts(), ProductDto.class));
    }
}
