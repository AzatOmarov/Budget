package de.budget.project.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ErrorResponse {

    private String errorMessage;
    private String errorTypeCode;

    @JsonIgnore
    private ErrorType errorType;

    public ErrorResponse(String errorMessage, ErrorType errorType) {
        this.errorMessage = errorMessage;
        this.errorType = errorType;
        this.errorTypeCode = this.errorType.getErrorCodeType();
    }
}
