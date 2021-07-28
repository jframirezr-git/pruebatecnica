package com.example.pruebatecnica.app.dao.dataModel.user;

import lombok.*;

import java.io.Serializable;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean response;

    private String message;
}
