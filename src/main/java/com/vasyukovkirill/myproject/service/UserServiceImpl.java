package com.vasyukovkirill.myproject.service;

import com.vasyukovkirill.myproject.dao.UserDAO;
import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.entity.User;
import com.vasyukovkirill.myproject.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<UserDTO> getAllUsers(Pageable pageable) {
        List<User> getAllUsers = userDAO.getAllUsers(pageable);
        return UserMapper.INSTANCE.toUserDTOs(getAllUsers);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUserEntity(userDTO);
        return UserMapper.INSTANCE.toUserDTO(userDAO.saveUser(user));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, int id) {
        User user = userDAO.findById(id);
        userDTO.setId(id);
        if (user.getDetail() != null && userDTO.getDetail() != null)
        userDTO.getDetail().setId(user.getDetail().getId());
        UserMapper.INSTANCE.merge(user, userDTO);
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
    public List<UserDTO> searchUsers(UserDTO userDTO, Pageable pageable) {
        List<User> users = userDAO.getSearchList(userDTO, pageable);
        return UserMapper.INSTANCE.toUserDTOs(users);

    }

}
