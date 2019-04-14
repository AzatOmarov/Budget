package de.budget.project.exception.exceptions;

import de.budget.project.error.ErrorType;
import de.budget.project.exception.AbstractAPIException;

public class CategoryNotFoundException extends AbstractAPIException {

    @Override
    public ErrorType getErrorType() {
        return ErrorType.RESOURCE_NOT_FOUND_ERROR;
    }

    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public CategoryNotFoundException() {
    }
}
