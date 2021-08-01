package com.example.pruebatecnica.app.dao.dataModel.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchAllResponse {

    private static final long serialVersionUID = 1L;

    List<UserDto> userDtos;
}
