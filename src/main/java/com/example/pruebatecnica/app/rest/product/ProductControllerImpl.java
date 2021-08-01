package com.example.pruebatecnica.app.rest.product;

import com.example.pruebatecnica.app.dao.dataModel.common.ErrorResponse;
import com.example.pruebatecnica.app.dao.dataModel.common.Response;
import com.example.pruebatecnica.app.dao.dataModel.product.ProductRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserRequest;
import com.example.pruebatecnica.app.service.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;

@Api(value = "Producto", tags = "Producto")
@RequiredArgsConstructor
@RestController
public class ProductControllerImpl implements ProductController{

    private final ProductService productService;

    @Override
    public ResponseEntity<Response<Serializable>> saveProduct(@Valid ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new Response<>(productService.saveProduct(request), new ErrorResponse()));
    }
}
