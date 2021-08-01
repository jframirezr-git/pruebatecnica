package com.example.pruebatecnica.app.dao.dataModel.product;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ProductDto> products;
}
