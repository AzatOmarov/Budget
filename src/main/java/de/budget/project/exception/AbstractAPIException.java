package de.budget.project.exception;

import de.budget.project.error.ErrorResponse;
import de.budget.project.error.ErrorType;

public abstract class AbstractAPIException extends RuntimeException {

    public String errorMessage = "Message not provided";

    public AbstractAPIException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public AbstractAPIException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(getErrorMessage(), getErrorType());
    }

    public abstract ErrorType getErrorType();

}
