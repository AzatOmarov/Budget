package de.budget.project.model.types;

import com.fasterxml.jackson.annotation.*;

import java.util.Arrays;
import java.util.Optional;

public enum CurrencyType {
    USD(1, "USD", "United States Dollar"),
    EUR(2, "EUR", "European Euro"),
    RUR(3, "RUB", "Russian Ruble");

    private Integer id;
    private String name;
    private String description;

    @JsonCreator
    CurrencyType(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CurrencyType findCurrencyById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Optional<CurrencyType> currency = Arrays
                .stream(CurrencyType.values())
                .filter(k -> k.getId().equals(id))
                .findFirst();
        return currency.orElseThrow(() -> new IllegalArgumentException("Id cannot be null"));
    }

    public static CurrencyType findCurrencyByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        Optional<CurrencyType> currency = Arrays
                .stream(CurrencyType.values())
                .filter(k -> k.getName().equals(name))
                .findFirst();
        return currency.orElseThrow(() -> new IllegalArgumentException("Name cannot be null"));
    }

    @Override
    @JsonValue
    public String toString() {
        return  "{'id': " + id + ", 'name': '" + name + "', " + "'description': '" + description + "'}";
    }
}