package com.example.pruebatecnica.app.service;

import com.example.pruebatecnica.app.dao.dataModel.product.ProductDto;
import com.example.pruebatecnica.app.dao.dataModel.product.ProductRequest;
import com.example.pruebatecnica.app.dao.dataModel.product.ProductResponse;
import com.example.pruebatecnica.app.dao.dataModel.product.SearchProductRequest;

public interface ProductService {


    ProductResponse saveProduct(ProductRequest request);

    ProductDto searchProduct(SearchProductRequest request);
}
