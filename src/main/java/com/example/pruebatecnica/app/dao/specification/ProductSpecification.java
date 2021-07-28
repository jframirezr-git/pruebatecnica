package com.example.pruebatecnica.app.dao.specification;


import com.example.pruebatecnica.app.dao.dataModel.product.SearchProduct;
import com.example.pruebatecnica.app.dao.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

@RequiredArgsConstructor
public class ProductSpecification implements Specification<Product> {

    private final SearchProduct searchProduct;


    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if(searchProduct.getStartDate() != null){
            predicate.getExpressions().add(criteriaBuilder.equal(root.get("startDate"), searchProduct.getStartDate()));
        }

        if(isNoneBlank(searchProduct.getName())){
            predicate.getExpressions().add(criteriaBuilder.equal(root.get("name"), searchProduct.getName()));
        }

        if(searchProduct.getUser().getId() != null){
            predicate.getExpressions().add(criteriaBuilder.equal(root.get("user_id"), searchProduct.getUser().getId()));
        }

        return predicate;
    }
}
