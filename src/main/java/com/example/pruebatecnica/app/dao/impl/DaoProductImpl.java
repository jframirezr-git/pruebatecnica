package com.example.pruebatecnica.app.dao.impl;

import com.example.pruebatecnica.app.dao.DaoProduct;
import com.example.pruebatecnica.app.dao.dataModel.constant.ApiMessageHttp;
import com.example.pruebatecnica.app.dao.dataModel.constant.ErrorCode;
import com.example.pruebatecnica.app.dao.dataModel.product.SearchProduct;
import com.example.pruebatecnica.app.dao.models.Product;
import com.example.pruebatecnica.app.dao.repositories.ProductRepository;
import com.example.pruebatecnica.app.dao.specification.ProductSpecification;
import com.example.pruebatecnica.app.exception.DataSourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class DaoProductImpl implements DaoProduct {

    private final ProductRepository productRepository;


    @Override
    public void saveProduct(Product product) {
        try {
            productRepository.save(product);
        }
        catch (DataSourceException e){
            throw new DataSourceException(ErrorCode.CODIGO_GENERAL_ERROR_INTERNO_BACKEND, ApiMessageHttp.DB);
        }
    }

    @Override
    public Optional<Product> searchProduct(SearchProduct searchProduct) {

        List<Product> productList;

        try{
            ProductSpecification productSpecification = new ProductSpecification(searchProduct);
            productList = productRepository.findAll(productSpecification);
        }
        catch (DataSourceException e){
            throw new DataSourceException(ErrorCode.CODIGO_GENERAL_ERROR_INTERNO_BACKEND, ApiMessageHttp.DB);
        }

        return isEmpty(productList) ? Optional.empty() : productList.stream().findFirst();
    }

    @Override
    public List<Product> searchProducts() {
        try {
            return productRepository.findAll();
        }
        catch (DataSourceException e){
            throw new DataSourceException(ErrorCode.CODIGO_GENERAL_ERROR_INTERNO_BACKEND, ApiMessageHttp.DB);
        }
    }
}
