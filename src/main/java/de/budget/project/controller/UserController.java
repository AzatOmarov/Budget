package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebResponse;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.services.UserService;
import de.budget.project.services.WalletService;
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

    @GetMapping("/users/{id}")
    public UserWebResponse getUserById(@PathVariable("id") Long id) {
        return convertToUserInfo(userService.getUserById(id));
    }

    @GetMapping("/users/email/{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }


    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    public User convertToEntity(UserWebDto userWebDto) throws ParseException {
        User user = modelMapper.map(userWebDto, User.class);
        return user;
    }

    private UserWebDto convertToDto(User user) {
        UserWebDto userWebDto = modelMapper.map(user, UserWebDto.class);
        return userWebDto;
    }

    private UserWebResponse convertToUserInfo(User user) {
        UserWebResponse userWebResponse = modelMapper.map(user, UserWebResponse.class);
        return userWebResponse;
    }
}
