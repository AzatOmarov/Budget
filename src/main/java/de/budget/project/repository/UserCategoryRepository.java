package de.budget.project.repository;

import de.budget.project.model.userCategory.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {
}
