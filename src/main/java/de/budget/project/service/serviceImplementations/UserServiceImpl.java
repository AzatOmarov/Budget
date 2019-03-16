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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    public static final List<Category> categories = new LinkedList<>();

    @Autowired
    UserRepository userRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    UserCategoryRepository userCategoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        User createdUser = new User(user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getCreatedDate(),
                user.getCreatedDate());
        userRepository.save(createdUser);
        return createdUser;
    }


    private List<Category> fillDefaultCategory() {
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

    public void createUserCategory(User user) {
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