package de.budget.project.services;

import java.util.Map;

public interface InitialDataService {

    Map<Integer, String> getCategoryTypes();
    Map<Integer, Map<String,String>> getCurrencyTypes();

}
