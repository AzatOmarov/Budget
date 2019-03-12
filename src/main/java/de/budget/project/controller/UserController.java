package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody UserWebDto userWebDto) {
        userService.createUser(userWebDto);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/byEmail/{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }
}
