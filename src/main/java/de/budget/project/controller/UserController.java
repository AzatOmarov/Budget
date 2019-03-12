package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserInfoWebResponse;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public void createUser(@RequestBody UserWebDto userWebDto){
        userService.createUser(userWebDto);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUserList();
    }

    @GetMapping("/findByEmail/{email}")
    public User findUserByEmail(@PathVariable ("email") String email){
           return userService.findUserByEmail(email);
    }


    @GetMapping("/by/{id}")
    public User getUserById(@PathVariable ("id") Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/userInfoBy/{email}")
    public UserInfoWebResponse getUserInfoByEmail(@PathVariable("email") String email){
        return userService.getUserInfoByEmail(email);
    }




}
