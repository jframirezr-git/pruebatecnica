package com.example.pruebatecnica.app.dao;

import com.example.pruebatecnica.app.dao.dataModel.product.SearchProduct;
import com.example.pruebatecnica.app.dao.models.Product;

import java.util.List;
import java.util.Optional;

public interface DaoProduct {

    /**
     * Save product
     *
     * @param product
     */
    void saveProduct(Product product);

    /**
     * Search product
     * @param searchProduct
     * @return
     */
    Optional<Product> searchProduct(SearchProduct searchProduct);

    /**
     * Search all products
     * @return
     */
    List<Product> searchProducts();
}
