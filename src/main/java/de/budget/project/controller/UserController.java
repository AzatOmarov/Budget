package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.service.services.UserService;
import de.budget.project.service.services.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    WalletService walletService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserWebDto createUser(@RequestBody UserWebDto userWebDto) throws ParseException {
        User user = convertToEntity(userWebDto);
        User userCreated = userService.createUser(user);
        return convertToDto(userCreated);
    }

    public User convertToEntity(UserWebDto userWebDto) throws ParseException {
        User user = modelMapper.map(userWebDto, User.class);
        user.setName(userWebDto.getName());
        user.setPassword(userWebDto.getPassword());
        user.setEmail(userWebDto.getEmail());
        return user;
    }

    public UserWebDto convertToDto(User user) {
        UserWebDto userWebDto = modelMapper.map(user, UserWebDto.class);
        userWebDto.setName(user.getName());
        userWebDto.setEmail(user.getEmail());
        userWebDto.setPassword(user.getPassword());
        return userWebDto;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/email/{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }
}
