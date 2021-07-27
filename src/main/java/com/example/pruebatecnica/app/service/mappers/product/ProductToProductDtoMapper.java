package com.example.pruebatecnica.app.service.mappers.product;

import com.example.pruebatecnica.app.dao.dataModel.product.ProductDto;
import com.example.pruebatecnica.app.dao.models.Product;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class ProductToProductDtoMapper extends CustomMapper<Product, ProductDto> {
    @Override
    public void mapAtoB(Product product, ProductDto productDto, MappingContext context) {
        productDto.setId(product.getId());
        productDto.setProduct(product.getProduct());
        productDto.setName(product.getName());
        productDto.setQuantity(product.getQuantity());
        productDto.setStartDate(product.getStartDate());
    }
}
