package de.budget.project.services;

import de.budget.project.model.user.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);
}