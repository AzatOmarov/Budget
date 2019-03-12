package de.budget.project.service.serviceImplementations;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.UserRepository;
import de.budget.project.repository.WalletRepository;
import de.budget.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private static final Double DEFAULT_BALANCE = 0.00;
    private static final String DEFAULT_CURRENCY = "";

    @Autowired
    UserRepository userRepository;
    @Autowired
    WalletRepository walletRepository;

    @Override
    public void createUser(UserWebDto userWebDto) {
        User user = saveUser(userWebDto);
        createDefaultWallet(user);
    }

    public User saveUser(UserWebDto userWebDto) {
        User user = new User();
        user.setName("");
        user.setEmail(userWebDto.getEmail());
        user.setPassword(userWebDto.getPassword());
        userRepository.save(user);
        return user;
    }

    public void createDefaultWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUserId(user);
        wallet.setBalance(DEFAULT_BALANCE);
        wallet.setCurrency(DEFAULT_CURRENCY);
        walletRepository.save(wallet);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }
}