package de.budget.project.exception.exceptions;

import de.budget.project.error.ErrorType;
import de.budget.project.exception.AbstractAPIException;

public class TransactionNotFoundException extends AbstractAPIException {

    public TransactionNotFoundException(String e) {
        super(e);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.RESOURCE_NOT_FOUND_ERROR;
    }

    public TransactionNotFoundException() {
    }



}
