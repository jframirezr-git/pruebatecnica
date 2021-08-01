package com.example.pruebatecnica.app.dao.dataModel.user;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {


    @ApiModelProperty(value = "nombre del usuario", required = true, position = 1)
    @NotBlank(message = "El nombre no puede ser vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    String name;

    @ApiModelProperty(value = "Años del usuario", required = true, position = 2)
    @NotNull(message = "Los años del usuario no pueden ser vacíos")
    @Min(value = 1, message = "Edad debe ser mayor a un digito")
    @Max(value = 100, message = "Edad debe ser menor a 3 digitos")
    Integer year;

    @ApiModelProperty(value = "Id del rol", required = true, position = 3)
    @NotNull(message = "El id del rol no puede ser vacio")
    Integer roleId;

}
