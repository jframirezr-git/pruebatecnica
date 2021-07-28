package com.example.pruebatecnica.app.dao.dataModel.user;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserSearchRequest {

    @ApiModelProperty(value = "nombre del usuario", required = true, position = 1)
    @NotBlank(message = "El nombre no puede ser vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    String name;

}
