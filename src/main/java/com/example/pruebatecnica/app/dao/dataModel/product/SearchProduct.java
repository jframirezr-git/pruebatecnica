package com.example.pruebatecnica.app.dao.dataModel.product;

import com.example.pruebatecnica.app.dao.dataModel.user.UserDto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchProduct {

    private Date startDate;

    private String name;

    private UserDto user;
}
