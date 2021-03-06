package com.example.pruebatecnica.app.dao.dataModel.user;

import com.example.pruebatecnica.app.dao.dataModel.product.ProductDto;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer year;
    private Date startDate;
    List<ProductDto> productDtoList;
}
