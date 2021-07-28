package com.example.pruebatecnica.app.dao.dataModel.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductRequest {

    @ApiModelProperty(value = "Fecha de ingreso del producto", required = false, position = 1)
    @Size(min = 1, max = 10, message = "La fecha de ingreso del producto debe tener entre 1 y 50 caracteres")
    Date startDate;

    @ApiModelProperty(value = "nombre del producto", required = false, position = 2)
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    String name;

    @ApiModelProperty(value = "Id del usuario", required = false, position = 3)
    @Size(min = 1, max = 50, message = "El id del usuario debe tener entre 1 y 50 caracteres")
    Integer userId;

}
