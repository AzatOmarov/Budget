package de.budget.project.model.dto;

import de.budget.project.model.dao.CategoryDAO;
import de.budget.project.model.types.CategoryType;
import lombok.Data;
import java.util.List;


@Data
public class InitialDataDTO {
    private String categoryTypeList;
    private String currencyTypeList;
    private List<CategoryDAO> categoryList;

    public InitialDataDTO(List<CategoryType> categoryTypes, String currencies,
                          List<CategoryDAO> categoryList) {
        this.categoryTypeList = categoryTypes.toString();
        this.currencyTypeList = currencies;
        this.categoryList = categoryList;
    }


}
