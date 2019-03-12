package de.budget.project.model.category;

public enum CategoryType {
    DEBIT(1),
    CREDIT(2);

    private Integer id;

    CategoryType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}