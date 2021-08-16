package com.vasyukovkirill.myproject.dao;

import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.entity.User;
import com.vasyukovkirill.myproject.exceptions.*;
import com.vasyukovkirill.myproject.dao.specifications.UserSpecifications;
import lombok.RequiredArgsConstructor;
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

    public List<User> getSearchList(UserDTO userDTO) {
        Optional<Specification<User>> optionalUserSpecification = allSpecification(userDTO);
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
        if (isValid(user.getName())
                && isValid(user.getSurName())
                && isValid(user.getPatronymic()) && user.getDateOfBirth() != null) {
            user.setLastChange(LocalDateTime.now());
            return usersRepository.save(user);
        } else {
              throw new SaveEntityException();
        }
    }

    private Optional<Specification<User>> allSpecification(UserDTO userDTO){
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
        if (isValid(userDTO.getSurname())
                || isValid(userDTO.getName())
                || isValid(userDTO.getPatronymic())
                || (userDTO.getDateOfBirth() != null)) {
            listUserSpecification.add(UserSpecifications.equalDeactivated(false));
        } else {
            throw new IsEmptySearchQueryException();
        }

        Specification<User> userSpecification = listUserSpecification.get(0);
        for (int i = 1; i < listUserSpecification.size(); i++) {
            userSpecification = userSpecification.and(listUserSpecification.get(i));
        }
        return Optional.ofNullable(userSpecification);

    }

    private boolean isValid(String userDTOField){
        return userDTOField != null && !userDTOField.isBlank();
    }

    public User findById(int id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new NotFoundUserException();
        }
        return optionalUser.get();
    }

}
