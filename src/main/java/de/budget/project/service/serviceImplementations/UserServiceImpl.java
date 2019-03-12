package de.budget.project.service.serviceImplementations;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryType;
import de.budget.project.model.user.User;
import de.budget.project.model.user.UserWebDto;
import de.budget.project.model.userCategory.UserCategory;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.UserCategoryRepository;
import de.budget.project.repository.UserRepository;
import de.budget.project.repository.WalletRepository;
import de.budget.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    public static final List<Category> categories = new LinkedList<>();
    private static final Double DEFAULT_BALANCE = 0.00;
    private static final String DEFAULT_CURRENCY = "";

    @Autowired
    UserRepository userRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    UserCategoryRepository userCategoryRepository;

    @Override
    public void createUser(UserWebDto userWebDto) {
        User user = saveUser(userWebDto);
        createDefaultWallet(user);
        createUserCategory(user);
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

    private List<Category> fillDefaultCategory(){
        Category c1 = new Category();
        c1.setName("Food");
        c1.setCategoryTypeId(CategoryType.CREDIT);

        Category c2 = new Category();
        c2.setName("Salary");
        c2.setCategoryTypeId(CategoryType.DEBIT);

        categories.add(c1);
        categories.add(c2);
        return categories;
    }

    public void createUserCategory(User user){
        List<Category> categories = fillDefaultCategory();
        UserCategory userCategory = new UserCategory();
        userCategory.setUserId(user);
        userCategory.setCategoryId(categories.get(0));
        userCategory.setCategoryId(categories.get(1));
        userCategoryRepository.save(userCategory);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}