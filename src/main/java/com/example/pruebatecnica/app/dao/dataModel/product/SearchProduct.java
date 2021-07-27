package com.example.pruebatecnica.app.dao.dataModel.product;

import com.example.pruebatecnica.app.dao.models.UserApp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchProduct {

    private int id;

    private String name;

    private UserApp user;
}
