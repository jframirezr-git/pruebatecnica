package com.example.pruebatecnica.app.rest.user;

import com.example.pruebatecnica.app.dao.dataModel.common.Response;
import com.example.pruebatecnica.app.dao.dataModel.constant.ApiMessageHttp;
import com.example.pruebatecnica.app.dao.dataModel.user.UserRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserSearchRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.Serializable;

public interface UserController {

    @ApiOperation(value = "Registrar usuario", notes = "Registrar usuario", nickname = "RegistrarUsuario",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = ApiMessageHttp.API_HTTP_STATUS_201, response = Response.class),
            @ApiResponse(code = 502, message = ApiMessageHttp.API_HTTP_STATUS_502, response = Response.class),
            @ApiResponse(code = 206, message = ApiMessageHttp.API_HTTP_STATUS_206, response = Response.class)})
    @PostMapping(path = "/user/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response<Serializable>> saveUser(@Valid @RequestBody UserRequest request);

    @ApiOperation(value = "Buscar usuario", notes = "Buscar usuario", nickname = "BuscarUsuario",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = ApiMessageHttp.API_HTTP_STATUS_201, response = Response.class),
            @ApiResponse(code = 502, message = ApiMessageHttp.API_HTTP_STATUS_502, response = Response.class),
            @ApiResponse(code = 206, message = ApiMessageHttp.API_HTTP_STATUS_206, response = Response.class)})
    @PostMapping(path = "/user/get",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response<Serializable>> searchUser(@Valid @RequestBody UserSearchRequest request);

    @ApiOperation(value = "Buscar usuarios", notes = "Buscar usuarios", nickname = "BuscarUsuarios",
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = ApiMessageHttp.API_HTTP_STATUS_201, response = Response.class),
            @ApiResponse(code = 502, message = ApiMessageHttp.API_HTTP_STATUS_502, response = Response.class),
            @ApiResponse(code = 206, message = ApiMessageHttp.API_HTTP_STATUS_206, response = Response.class)})
    @GetMapping(path = "/user/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity searchAllUser();


}
