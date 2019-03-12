package de.budget.project.service.services;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;

public interface UserService {

    void createUser(UserWebDto userWebDto);

    User findUserById(Long userId);

    User findUserByEmail(String email);
}