package de.budget.project.services.impl;

import de.budget.project.model.entites.User;
import de.budget.project.model.web.UserWebResponse;
import de.budget.project.repository.UserRepository;
import de.budget.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Long createUser(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public UserWebResponse getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}