package de.budget.project.exception;

import de.budget.project.error.ErrorType;
import de.budget.project.error.errors.InputValidationError;
import de.budget.project.exception.AbstractAPIException;

import java.util.List;

public abstract class ValidationException extends AbstractAPIException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

    public ValidationException() {
    }

    public abstract ErrorType getErrorType();

    public InputValidationError getErrorResponse(){
        return new InputValidationError(getErrorMessage(), getErrorType(), getErrors());
    }

    protected abstract List<String> getErrors();

}
