package com.example.pruebatecnica.app.service.impl;

import com.example.pruebatecnica.app.dao.DaoProduct;
import com.example.pruebatecnica.app.dao.DaoUser;
import com.example.pruebatecnica.app.dao.dataModel.product.*;
import com.example.pruebatecnica.app.dao.dataModel.user.SearchUser;
import com.example.pruebatecnica.app.dao.dataModel.user.UserDto;
import com.example.pruebatecnica.app.dao.models.Product;
import com.example.pruebatecnica.app.dao.models.UserApp;
import com.example.pruebatecnica.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final DaoProduct daoProduct;
    private final DaoUser daoUser;
    private final MapperFacade mapperFacade;


    @Override
    public ProductResponse saveProduct(ProductRequest request) {

        Date now = new Date();
        Date createdDate = new Date(request.getStartDate().getTime());

        SearchUser searchUser = SearchUser.builder().id(request.getUserId()).build();
        Optional<UserApp> user = daoUser.searchUser(searchUser);

        SearchProduct searchProduct = SearchProduct.builder().name(request.getName())
                .startDate(request.getStartDate())
                .user(mapperFacade.map(user, UserDto.class))
                .build();
        Optional<Product> product = daoProduct.searchProduct(searchProduct);

        if(product.isPresent()){
            return ProductResponse.builder().response(false)
                    .message("Ya existe un producto registrado con ese nombre")
                    .build();
        }

        if(createdDate.after(now)){
            return ProductResponse.builder().response(false)
                    .message("La fecha ingresada no puedo ser mayor a la fecha actual")
                    .build();
        }


        if(user.isEmpty()){
            return ProductResponse.builder().response(false)
                    .message("No existe el usuario que registra el producto")
                    .build();
        }

        daoProduct.saveProduct(Product.builder()
                .name(request.getName())
                .product(request.getProduct())
                .startDate(request.getStartDate())
                .quantity(request.getQuantity())
                .userApp(user.get())
                .build());


        return ProductResponse.builder().response(true)
                .message("Creado corretamente")
                .build();
    }

    @Override
    public SearchProductResponse searchProduct(SearchProductRequest request) {
        return null;
    }

}
