package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.model.user.UserWebResponse;
import de.budget.project.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public UserWebDto createUser(@RequestBody UserWebDto userWebDto) {
        User user = convertToEntity(userWebDto);
        User userCreated = userService.createUser(user);
        return convertToDto(userCreated);
    }

    @GetMapping("/users/{id}")
    public UserWebResponse getUserById(@PathVariable("id") Long id) {
        return convertToWebResponse(userService.getUserById(id));
    }

    @GetMapping("/users/email/{email}")
    public UserWebResponse findUserByEmail(@PathVariable("email") String email) {
        return convertToWebResponse(userService.getUserByEmail(email));
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    private User convertToEntity(UserWebDto userWebDto) {
        return modelMapper.map(userWebDto, User.class);
    }

    private UserWebDto convertToDto(User user) {
        return modelMapper.map(user, UserWebDto.class);
    }

    private UserWebResponse convertToWebResponse(User user) {
        return modelMapper.map(user, UserWebResponse.class);
    }
}