package com.example.pruebatecnica.app.dao.specification;

import com.example.pruebatecnica.app.dao.dataModel.user.SearchUser;
import com.example.pruebatecnica.app.dao.models.UserApp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;


@RequiredArgsConstructor
public class UserSpecification implements Specification<UserApp> {

    private final SearchUser searchUser;

    @Override
    public Predicate toPredicate(Root<UserApp> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if(isNoneBlank(searchUser.getName())){
            predicate.getExpressions().add(criteriaBuilder.equal(root.get("name"), searchUser.getName()));
        }

        if(searchUser.getId() != null){
            predicate.getExpressions().add(criteriaBuilder.equal(root.get("id"), searchUser.getId()));
        }

        return predicate;
    }
}
