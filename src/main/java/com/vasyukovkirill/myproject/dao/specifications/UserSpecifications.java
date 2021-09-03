package com.vasyukovkirill.myproject.dao.specifications;

import com.vasyukovkirill.myproject.entity.User;
import com.vasyukovkirill.myproject.entity.User_;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class UserSpecifications {


    public static Specification<User> equalSurName(String surname) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.surName), surname);
        };
    }

    public static Specification<User> equalName(String name) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.name), name);
        };
    }

    public static Specification<User> equalPatronymic(String patronymic) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.patronymic), patronymic);
        };
    }

    public static Specification<User> equalDateOfBirth(LocalDate dateofbirth) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.dateOfBirth), dateofbirth);
        };
    }

    public static Specification<User> equalDeactivated(Boolean deactivated) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.deactivated), deactivated);
        };
    }

}
