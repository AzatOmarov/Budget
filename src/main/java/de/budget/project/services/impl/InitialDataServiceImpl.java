package de.budget.project.services.impl;

import de.budget.project.model.types.CategoryType;
import de.budget.project.model.types.CurrencyType;
import de.budget.project.services.InitialDataService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;


@Service
public class InitialDataServiceImpl implements InitialDataService {

    @Override
    public List<CategoryType> getCategoryTypes() {
        return Arrays.asList(CategoryType.values());
    }

    @Override
    public String getCurrencyTypes() {
        return  Arrays.toString(CurrencyType.values());
    }
}
