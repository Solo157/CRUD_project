package com.vasyukovkirill.myproject.dao;

import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.entity.User;
import com.vasyukovkirill.myproject.exceptions.*;
import com.vasyukovkirill.myproject.dao.specifications.UserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final UsersRepository usersRepository;

    public List<User> getSearchList(UserDTO userDTO, Pageable pageable) {
        return convertPageToList(usersRepository.findAll(allSpecification(userDTO), pageable));
    }

    private List<User> convertPageToList(Page<User> page) {
        List<User> userList = new ArrayList<>();
        page.map(userList::add);
        return userList;
    }

    public List<User> getAllUsers(Pageable pageable){
        return convertPageToList(usersRepository.findAll(UserSpecifications.equalDeactivated(false), pageable));
    }

    public User saveUser(User user) {
        return usersRepository.save(user);
    }

    private Specification<User> allSpecification(UserDTO userDTO){
        List<Specification<User>> listUserSpecification = new ArrayList<>();
        if (isValid(userDTO.getSurname())){
            listUserSpecification.add(UserSpecifications.equalSurName(userDTO.getSurname()));
        }
        if (isValid(userDTO.getName())){
            listUserSpecification.add(UserSpecifications.equalName(userDTO.getName()));
        }
        if (isValid(userDTO.getPatronymic())){
            listUserSpecification.add(UserSpecifications.equalPatronymic(userDTO.getPatronymic()));
        }
        if (userDTO.getDateOfBirth() != null) {
            listUserSpecification.add(UserSpecifications.equalDateOfBirth(userDTO.getDateOfBirth()));
        }

        /* It's finding only active users */
        if (!listUserSpecification.isEmpty()) {
            listUserSpecification.add(UserSpecifications.equalDeactivated(false));
        } else {
            throw new IsEmptySearchQueryException();
        }

        final Specification<User> userSpecification = listUserSpecification.get(0);
        listUserSpecification.remove(0);
        listUserSpecification.forEach(userSpecification::and);

        return userSpecification;

    }

    private boolean isValid(String userDTOField){
        return userDTOField != null && !userDTOField.isBlank();
    }

    public User findById(int id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundUserException();
        }
        return optionalUser.get();
    }

}
