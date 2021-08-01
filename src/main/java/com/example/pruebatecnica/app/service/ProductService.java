package com.example.pruebatecnica.app.service;

import com.example.pruebatecnica.app.dao.dataModel.product.*;

public interface ProductService {


    ProductResponse saveProduct(ProductRequest request);

    SearchProductResponse searchProduct(SearchProductRequest request);

    SearchAllProductsResponse searchAllProduct();

    ProductResponse deleteProduct(ProductDeleteRequest request);
}
