package de.budget.project.model.web;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionWebRequest {
    @NotNull
    @NotBlank
    private Date customDate;

    @NotNull
    @Min(value = 0L)
    private BigDecimal amount;

    private Long walletId;

    @NotNull
    @Min(value = 1)
    private Long categoryId;

    @Size(max = 255)
    private String description;
}