package de.budget.project.exception.exceptions;

import de.budget.project.error.ErrorType;
import de.budget.project.exception.AbstractAPIException;

public class SystemException extends AbstractAPIException {

    private String errorMessage = "Message not provided";

    @Override
    public ErrorType getErrorType() {
        return ErrorType.SYSTEM;
    }

    public SystemException(String errorMessage) {
        super(errorMessage);
    }

    public SystemException() {
    }

}
