package com.vasyukovkirill.myproject.specifications;

import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.entity.User;
import com.vasyukovkirill.myproject.entity.User_;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserSpecifications {

    public static Specification<User> equalSurName(String surname) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.SUR_NAME), surname);
        };
    }

    public static Specification<User> equalName(String name) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.NAME), name);
        };
    }

    public static Specification<User> equalPatronymic(String patronymic) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.PATRONYMIC), patronymic);
        };
    }

    public static Specification<User> equalDateOfBirth(LocalDate dateofbirth) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.DATE_OF_BIRTH), dateofbirth);
        };
    }

    public static Specification<User> equalDeactivated(Boolean deactivated) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.DEACTIVATED), deactivated);
        };
    }

}
