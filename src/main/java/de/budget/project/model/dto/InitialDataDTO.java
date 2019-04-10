package de.budget.project.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.budget.project.model.dao.CategoryDAO;
import de.budget.project.model.types.CategoryType;
import de.budget.project.model.types.CurrencyType;
import lombok.Data;

import java.util.List;


@Data
public class InitialDataDTO {


    private List<CategoryType> categoryTypeList;
    private List<CurrencyType> currencyTypeList;
    private List<CategoryDAO> categoryList;

    public InitialDataDTO(List<CategoryType> categoryTypeList, List<CurrencyType> currencyTypeList,
                          List<CategoryDAO> categoryList) {
        this.categoryTypeList = categoryTypeList;
        this.currencyTypeList = currencyTypeList;
        this.categoryList = categoryList;
    }

}
