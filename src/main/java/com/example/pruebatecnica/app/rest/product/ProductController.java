package com.example.pruebatecnica.app.rest.product;

import com.example.pruebatecnica.app.dao.dataModel.common.Response;
import com.example.pruebatecnica.app.dao.dataModel.constant.ApiMessageHttp;
import com.example.pruebatecnica.app.dao.dataModel.product.ProductRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserRequest;
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

public interface ProductController {

    @ApiOperation(value = "Registrar una mercancia", notes = "Registrar mercancia", nickname = "RegistrarMercancia",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = ApiMessageHttp.API_HTTP_STATUS_201, response = Response.class),
            @ApiResponse(code = 502, message = ApiMessageHttp.API_HTTP_STATUS_502, response = Response.class),
            @ApiResponse(code = 206, message = ApiMessageHttp.API_HTTP_STATUS_206, response = Response.class)})
    @PostMapping(path = "/product/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response<Serializable>> saveProduct(@Valid @RequestBody ProductRequest request);

    @ApiOperation(value = "Buscar productos", notes = "Buscar productos", nickname = "BuscarProductos",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = ApiMessageHttp.API_HTTP_STATUS_201, response = Response.class),
            @ApiResponse(code = 502, message = ApiMessageHttp.API_HTTP_STATUS_502, response = Response.class),
            @ApiResponse(code = 206, message = ApiMessageHttp.API_HTTP_STATUS_206, response = Response.class)})
    @GetMapping(path = "/product/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity searchAllProduct();

}
