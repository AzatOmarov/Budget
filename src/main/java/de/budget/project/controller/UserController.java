package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebRequest;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public UserWebRequest createUser(@RequestBody UserWebRequest userWebRequest) {
        return convertToWebRequest(userService.createUser(convertToEntity(userWebRequest)));
    }

    @GetMapping("/users/{id}")
    public UserWebDto getUserById(@PathVariable("id") Long id) {
        return convertToWebDto(userService.getUserById(id));
    }

    @GetMapping("/users?email={email}")
    public UserWebDto findUserByEmail(@PathVariable("email") String email) {
        return convertToWebDto(userService.getUserByEmail(email));
    }

    private User convertToEntity(UserWebRequest userWebRequest) {
        return modelMapper.map(userWebRequest, User.class);
    }

    private UserWebRequest convertToWebRequest(User user) {
        return modelMapper.map(user, UserWebRequest.class);
    }

    private UserWebDto convertToWebDto(User user) {
        return modelMapper.map(user, UserWebDto.class);
    }
}