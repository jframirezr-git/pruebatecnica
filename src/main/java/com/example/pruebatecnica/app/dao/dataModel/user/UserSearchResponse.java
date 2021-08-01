package com.example.pruebatecnica.app.dao.dataModel.user;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    UserDto users;
}
