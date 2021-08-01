package com.example.pruebatecnica.app.dao.dataModel.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ProductDeleteRequet {

    @ApiModelProperty(value = "Id del producto", required = true, position = 1)
    @NotNull(message = "El id del producto no puede ser vacio")
    Integer productId;

}
