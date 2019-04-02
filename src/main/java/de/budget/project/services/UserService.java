package de.budget.project.services;

import de.budget.project.model.entites.User;
import de.budget.project.model.web.UserWebResponse;

public interface UserService {

    Long createUser(User user);

    UserWebResponse getUserById(Long id);

    User getUserByEmail(String email);
}