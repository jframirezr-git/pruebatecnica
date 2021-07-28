package com.example.pruebatecnica.app.dao.dataModel.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    @ApiModelProperty(value = "Id del producto", required = true, position = 1)
    @NotBlank(message = "El id no puede ser vacío")
    @Size(min = 1, max = 50, message = "El id debe tener entre 1 y 50 caracteres")
    Integer id;

    @ApiModelProperty(value = "nombre del producto", required = true, position = 2)
    @NotBlank(message = "El nombre no puede ser vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    String name;

    @ApiModelProperty(value = "Cantidad del producto", required = true, position = 3)
    @NotBlank(message = "La cantidad no puede ser vacía")
    @Size(min = 1, max = 10, message = "La cantidad debe tener entre 1 y 10 caracteres")
    Integer quantity;

    @ApiModelProperty(value = "Fecha de inscripcíon del producto", required = true, position = 4)
    @NotBlank(message = "La fecha no puede ser vacía")
    @Size(min = 1, max = 10, message = "La fecha debe tener entre 1 y 10 caracteres")
    Date startDate;

    @ApiModelProperty(value = "Id del usuario", required = true, position = 5)
    @NotBlank(message = "El id del usuario no puede ser vacío")
    @Size(min = 1, max = 50, message = "El id del usuario debe tener entre 1 y 10 caracteres")
    Integer userId;

}
