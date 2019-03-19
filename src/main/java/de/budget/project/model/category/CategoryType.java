package de.budget.project.model.category;

import java.util.Optional;

public enum CategoryType {
    DEBIT(1, "DEBIT"),
    CREDIT(2, "CREDIT");

    private Integer id;
    private String name;

    CategoryType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryType getCategoryTypeByName (String name) {
        Optional<CategoryType> found = Optional.empty();
        for (CategoryType c : CategoryType.values()) {
            if (c.getName().equals(name)) {
                found = Optional.of(c);
                break;
            }
        }
        CategoryType categoryType = found.get();
        return categoryType;
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

    @Override
    public String toString() {
        return "CategoryType{" +
                "name='" + name + '\'' +
                '}';
    }
}