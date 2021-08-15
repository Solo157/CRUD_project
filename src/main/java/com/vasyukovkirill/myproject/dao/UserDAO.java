package com.vasyukovkirill.myproject.dao;

import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.entity.User;
import com.vasyukovkirill.myproject.exceptions.DataNotFoundException;
import com.vasyukovkirill.myproject.exceptions.IncorrectSpecificationException;
import com.vasyukovkirill.myproject.exceptions.SaveEntityException;
import com.vasyukovkirill.myproject.mappers.UserMapper;
import com.vasyukovkirill.myproject.specifications.UserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final UsersRepository usersRepository;

    public List<User> getSearchList(UserDTO userDTO) {
        Optional<Specification<User>> optionalUserSpecification = UserSpecifications.allSpecification(userDTO);
        return optionalUserSpecification.map(usersRepository::findAll).orElse(Collections.emptyList());
    }

    public List<User> getAllUsers(){
        List<User> getAllUsers = usersRepository.findAll(UserSpecifications.equalDeactivated(false));
        if (getAllUsers.size() == 0) {
            throw new DataNotFoundException();
        }
        return getAllUsers;
    }

    public User saveUser(User user) {
        if (UserSpecifications.isValid(user.getName())
                && UserSpecifications.isValid(user.getSurName())
                && UserSpecifications.isValid(user.getPatronymic()) && user.getDateOfBirth() != null) {
            return usersRepository.save(user);
        } else {
              throw new SaveEntityException();
        }
    }

}
