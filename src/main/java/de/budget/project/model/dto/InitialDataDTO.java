package de.budget.project.model.dto;

import de.budget.project.model.dao.CategoryDAO;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class InitialDataDTO {

    private Map<Integer, String> categoryTypes;
    private Map<Integer, Map<String,String>> currencyTypes;
    private List<CategoryDAO> categoryList;

    public InitialDataDTO(Map<Integer,String> categories, Map<Integer,
            Map<String,String>> currencyTypeList,
                          List<CategoryDAO> categoryList) {
        this.categoryTypes = categories;
        this.currencyTypes= currencyTypeList;
        this.categoryList = categoryList;
    }
}
