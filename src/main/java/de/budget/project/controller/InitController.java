package de.budget.project.controller;

import de.budget.project.model.web.CategoryTypeWebDto;
import de.budget.project.model.web.CategoryWebDto;
import de.budget.project.model.web.CurrencyWebDto;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class InitController {

    private CategoryWebDto categoryWebDto;
    private CategoryTypeWebDto categoryTypeWebDto;
    private CurrencyWebDto currencyWebDto;

    @PostConstruct
    public void init() {
    }
}
