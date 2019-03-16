package de.budget.project.service.services;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;

import java.text.ParseException;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

//    UserWebDto convertToDto(User user);
//    User convertToEntity(UserWebDto userWebDto) throws ParseException;
}