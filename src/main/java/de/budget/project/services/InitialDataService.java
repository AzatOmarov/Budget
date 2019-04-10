package de.budget.project.services;

import de.budget.project.model.types.CategoryType;
import de.budget.project.model.types.CurrencyType;

import java.util.List;

public interface InitialDataService {

    List<CategoryType> getCategoryTypes();
    List<CurrencyType> getCurrencyTypes();

}
