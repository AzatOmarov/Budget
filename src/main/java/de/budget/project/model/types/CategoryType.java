package de.budget.project.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

public enum CategoryType implements Serializable {
    DEBIT(1, "DEBIT"),
    CREDIT(2, "CREDIT");

    private Integer id;

    private String name;

    @JsonCreator
    CategoryType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CategoryType findCategoryTypeId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Optional<CategoryType> categoryType = Optional.empty();
        for (CategoryType k : CategoryType.values()) {
            if (k.getId().equals(id)) {
                categoryType = Optional.of(k);
                break;
            }
        }
        return categoryType.orElseThrow(() -> new IllegalArgumentException("Id cannot be null"));
    }

    public static CategoryType findCategoryTypeName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        Optional<CategoryType> categoryType = Arrays
                .stream(CategoryType.values())
                .filter(k -> k.getName().equals(name))
                .findFirst();
        return categoryType.orElseThrow(() -> new IllegalArgumentException("Name cannot be null"));
    }

    @Override
    @JsonValue
    public String toString() {
        return  "{ 'id': " + id + ", 'name': '" + name + "'}";
    }
}