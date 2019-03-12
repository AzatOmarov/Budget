package de.budget.project.repository;

import de.budget.project.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);

    User getUserByEmail(String email);
}