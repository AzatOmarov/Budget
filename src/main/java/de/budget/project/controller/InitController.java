package de.budget.project.controller;

import de.budget.project.model.types.CategoryType;
import de.budget.project.model.types.CurrencyType;
import de.budget.project.model.web.CategoryWebDto;
import de.budget.project.model.web.CurrencyWebDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InitController {

    private final List<CategoryType> categoryList = Arrays.asList(CategoryType.values());
    private final List<CurrencyType> currencyTypes = Arrays.asList(CurrencyType.class.getEnumConstants());

    @GetMapping("/initdata/categories")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryWebDto> getCategoryTypeList() {
        List<CategoryWebDto> categoryWebDtos = new LinkedList<>();
        for (CategoryType category: categoryList) {
            CategoryWebDto categoryWebDto = new CategoryWebDto(category.getName(),category.getId());
            categoryWebDtos.add(categoryWebDto);
        }
        return categoryWebDtos;
    }

    @GetMapping("/initdata/currencies")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CurrencyWebDto> getCurrencyTypeList() {
        List<CurrencyWebDto> currencyWebDtos = new LinkedList<>();
        for (CurrencyType currency: currencyTypes) {
            CurrencyWebDto currencyWebDto = new CurrencyWebDto(currency.getId().longValue(), currency.getName(), currency.getDescription());
            currencyWebDtos.add(currencyWebDto);
        }
        return currencyWebDtos;
    }
}
