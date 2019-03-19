package de.budget.project.services.impl;

import de.budget.project.model.category.Category;
import de.budget.project.model.user.User;
import de.budget.project.repository.UserRepository;
import de.budget.project.repository.WalletRepository;
import de.budget.project.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    public static final List<Category> categories = new LinkedList<>();

    @Autowired
    UserRepository userRepository;
    @Autowired
    WalletRepository walletRepository;

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}