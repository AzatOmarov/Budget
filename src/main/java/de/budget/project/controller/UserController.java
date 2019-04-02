package de.budget.project.controller;

import de.budget.project.model.entites.User;
import de.budget.project.model.web.UserWebRequest;
import de.budget.project.model.web.UserWebResponse;
import de.budget.project.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @PostMapping("/users")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long createUser(@RequestBody UserWebRequest userWebRequest) {
        return userService.createUser(convertToEntity(userWebRequest));
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserWebResponse getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/email/{email}")
    public UserWebResponse findUserByEmail(@PathVariable("email") String email) {
        return convertToWebResponse(userService.getUserByEmail(email));
    }

    private User convertToEntity(UserWebRequest userWebRequest) {
        return modelMapper.map(userWebRequest, User.class);
    }

    private UserWebResponse convertToWebResponse(User user) {
        return modelMapper.map(user, UserWebResponse.class);
    }
}