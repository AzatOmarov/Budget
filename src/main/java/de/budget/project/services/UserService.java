package de.budget.project.services;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;

import java.text.ParseException;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

    void deleteUserById(Long id);

}