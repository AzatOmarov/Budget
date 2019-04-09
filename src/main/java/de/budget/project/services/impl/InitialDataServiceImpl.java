package de.budget.project.services.impl;

import de.budget.project.model.types.CategoryType;
import de.budget.project.model.types.CurrencyType;
import de.budget.project.services.InitialDataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InitialDataServiceImpl implements InitialDataService {

    private final Map<Integer, String> categoryMap = new HashMap<>();
    private final Map<Integer, Map<String, String>> currencyMap = new HashMap<Integer, Map<String, String>>();

    @Override
    public Map<Integer, String> getCategoryTypes(){
        List<CategoryType> categoryTypes = Arrays.asList(CategoryType.values());
        for (CategoryType categoryType: categoryTypes) {
            categoryMap.put(categoryType.getId(), categoryType.getName());
        }
        return categoryMap;
    }

    @Override
    public Map<Integer, Map<String, String>> getCurrencyTypes() {
        List<CurrencyType> currencyTypes = Arrays.asList(CurrencyType.values());
        for (CurrencyType currTypes: currencyTypes) {
            Map<String, String> stringMap = new HashMap<String, String>();
            stringMap.put(currTypes.getName(), currTypes.getDescription());
            currencyMap.put(currTypes.getId(), stringMap);
        }
        return currencyMap;
    }
}
