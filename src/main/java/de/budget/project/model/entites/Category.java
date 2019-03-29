package de.budget.project.model.entites;

import de.budget.project.model.types.CategoryType;
import de.budget.project.model.types.CategoryTypeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50, unique = true)
    private String name;

    @Column(name = "CATEGORY_TYPE")
    @Convert(converter = CategoryTypeConverter.class)
    private CategoryType categoryType;
}