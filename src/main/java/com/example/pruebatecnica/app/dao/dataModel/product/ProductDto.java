package com.example.pruebatecnica.app.dao.dataModel.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String product;
    private int quantity;
    private Date startDate;
}
