package de.budget.project.repository;

import de.budget.project.model.entites.User;
import de.budget.project.model.web.UserWebResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new de.budget.project.model.web.UserWebResponse" +
            "(u.name, u.email)" +
            "FROM User u WHERE u.id= :id")
    UserWebResponse getUserById(@Param("id") Long id);

    User getUserByEmail(String email);
}