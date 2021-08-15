package com.vasyukovkirill.myproject.controller;

import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @PostMapping("/getUsers")
    public List<UserDTO> searchUsers(@RequestBody UserDTO userDTO){
        return userService.searchUsers(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
       return userService.getAllUsers();
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable int id){
        return userService.updateUser(userDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

}
