package com.vasyukovkirill.myproject.controller;

import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @PostMapping("/getUsers")
    public List<UserDTO> searchUsers(@RequestBody UserDTO userDTO,
                                     @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable){
        return userService.searchUsers(userDTO, pageable);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable){
       return userService.getAllUsers(pageable);
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody @Valid UserDTO userDTO){
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
