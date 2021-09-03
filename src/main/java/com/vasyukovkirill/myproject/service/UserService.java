package com.vasyukovkirill.myproject.service;

import com.vasyukovkirill.myproject.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers(Pageable pageable);

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO, int id);

    List<UserDTO> searchUsers(UserDTO userDTO, Pageable pageable);

    String deleteUser(int userId);
}
