package de.budget.project.model.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionWebResponse {

    private Float amount;
    private String description;
    private String categoryName;
    private Float balance;
}
