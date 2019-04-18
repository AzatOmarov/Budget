package de.budget.project.services;

import de.budget.project.model.types.CategoryType;
import java.util.List;

public interface InitialDataService {

    List<CategoryType> getCategoryTypes();
    String getCurrencyTypes();

}
