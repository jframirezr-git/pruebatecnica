package com.example.pruebatecnica.app.dao.dataModel.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    @ApiModelProperty(value = "nombre del producto", required = true, position = 1)
    @NotBlank(message = "El nombre no puede ser vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    String name;

    @ApiModelProperty(value = "Cantidad del producto", required = true, position = 2)
    @NotNull(message = "La cantidad no puede ser vacía")
    @Min(value = 1, message = "Edad debe ser mayor a un digito")
    @Max(value = 100, message = "Edad debe ser menor a 3 digitos")
    Integer quantity;

    @ApiModelProperty(value = "Fecha de inscripcíon del producto", required = true, position = 3)
    @NotNull(message = "La fecha no puede ser vacía")
    Date startDate;

    @ApiModelProperty(value = "Id del usuario", required = true, position = 4)
    @NotNull(message = "El id del usuario no puede ser vacio")
    Integer userId;

    @ApiModelProperty(value = "tipo del producto", required = true, position = 5)
    @NotBlank(message = "El tipo no puede ser vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    String product;

}
