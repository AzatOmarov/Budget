package de.budget.project.exception.exceptions;

import de.budget.project.error.ErrorType;
import de.budget.project.exception.AbstractAPIException;

public class CategoryTypeNotFoundException extends AbstractAPIException {


    public CategoryTypeNotFoundException(String e) {
        super(e);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.RESOURCE_NOT_FOUND_ERROR;
    }
}


