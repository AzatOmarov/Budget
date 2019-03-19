package de.budget.project.model.category;

import de.budget.project.model.categoryType.CategoryType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY_TYPE_ID")
    private int categoryTypeId;

}