package de.budget.project.controller;

import de.budget.project.model.types.CategoryType;
import de.budget.project.model.types.CurrencyType;
import de.budget.project.model.web.CategoryTypeWebDto;
import de.budget.project.model.web.CategoryWebDto;
import de.budget.project.model.web.CurrencyWebDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InitController {

    private CategoryWebDto categoryWebDto;
    private CurrencyWebDto currencyWebDto;
    private CategoryTypeWebDto categoryTypeWebDto;

    @PostConstruct
    private void init(){

    }

}
