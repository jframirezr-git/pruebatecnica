package com.example.pruebatecnica.app.dao.dataModel.product;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchAllProductsResponse {

    private static final long serialVersionUID = 1L;

    List<ProductDto> productDtoList;
}
