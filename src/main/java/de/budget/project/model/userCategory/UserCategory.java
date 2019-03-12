package de.budget.project.model.userCategory;

import de.budget.project.model.category.Category;
import de.budget.project.model.user.User;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USER_CATEGORY")
public class UserCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_CATEGORY_ID")
    private Long id;

    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @OneToOne //check to ManyToOne
    private User userId;

    @JoinColumn(name = "CATEGORY_ID", nullable = false, unique = true)
    @OneToOne
    private Category categoryId;
}