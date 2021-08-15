package com.vasyukovkirill.myproject.service;

import com.vasyukovkirill.myproject.dao.UserDAO;
import com.vasyukovkirill.myproject.dao.UsersRepository;
import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.entity.User;
import com.vasyukovkirill.myproject.exceptions.DataNotFoundException;
import com.vasyukovkirill.myproject.exceptions.NotFoundUserException;
import com.vasyukovkirill.myproject.exceptions.SaveEntityException;
import com.vasyukovkirill.myproject.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> getAllUsers = userDAO.getAllUsers();
        return UserMapper.INSTANCE.toUserDTOs(getAllUsers);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUserEntity(userDTO);
        user.setLastChange(LocalDateTime.now());
        return UserMapper.INSTANCE.toUserDTO(userDAO.saveUser(user));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, int id) {
        User user = userDAO.findById(id);
        userDTO.setId(id);
        UserMapper.INSTANCE.merge(user, userDTO);
        user.setLastChange(LocalDateTime.now());
        return UserMapper.INSTANCE.toUserDTO(userDAO.saveUser(user));
    }

    @Override
    public String deleteUser(int id) {
        User user = userDAO.findById(id);
        user.setDeactivated(true);
        user.setLastChange(LocalDateTime.now());
        userDAO.saveUser(user);
        return "User with ID = " + user.getId() + " was deactivated.";
    }

    @Override
    public List<UserDTO> searchUsers(UserDTO userDTO) {
        List<User> users = userDAO.getSearchList(userDTO);
        if (users.isEmpty()) {
            return Collections.emptyList();
        } else {
            return UserMapper.INSTANCE.toUserDTOs(users);
        }
    }

}
