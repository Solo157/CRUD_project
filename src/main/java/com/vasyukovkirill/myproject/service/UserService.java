package com.vasyukovkirill.myproject.service;

import com.vasyukovkirill.myproject.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO, int id);

    List<UserDTO> searchUsers(UserDTO userDTO);

    String deleteUser(int userId);
}
