package de.budget.project.model.currency;

import java.util.Arrays;
import java.util.Optional;

public enum Currency {
    USD(1, "USD"),
    EUR(2, "EUR"),
    RUR(3, "RUR");

    private Integer id;
    private String name;

    Currency(Integer id, String name) {
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

    public static Currency findCurrencyById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Optional<Currency> currency = Arrays
                .stream(Currency.values())
                .filter(k -> k.getId().equals(id))
                .findFirst();
        return currency.orElseThrow(() -> new IllegalArgumentException("Id cannot be null"));
    }

    public static Currency findCurrencyByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        Optional<Currency> currency = Arrays
                .stream(Currency.values())
                .filter(k -> k.getName().equals(name))
                .findFirst();
        return currency.orElseThrow(() -> new IllegalArgumentException("Name cannot be null"));
    }
}