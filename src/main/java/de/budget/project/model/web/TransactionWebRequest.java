package de.budget.project.model.web;

import de.budget.project.annotations.IsLongNotNull;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.MaxValidatorForNumber;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionWebRequest {
    @NotNull
    private Date customDate;

    @NotNull
    @Min(value = 0L, message = "negative amounts are not allowed")
    private BigDecimal amount;

    @Min(value = 1)
    @IsLongNotNull
    private Long walletId;

    @NotNull
    @Min(value = 1)
    private Long categoryId;

    @Size(max = 255)
    private String description;

    }