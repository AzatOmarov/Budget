package de.budget.project.exception.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.budget.project.error.ErrorType;
import de.budget.project.exception.ValidationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class InputValidationException extends ValidationException {

    private static final String DOT_SEPARATOR = ".";
    private BindingResult result;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> errors;

    public InputValidationException(BindingResult result) {
        this.result= result;
    }
    public InputValidationException(List<String> errors){
        this.errors = errors;
    }

    public InputValidationException() {
    }

    protected List<String> getErrors(){
        List<String> list = new ArrayList<>();
        if(result == null){
            return errors;
        } else {
            for(FieldError fieldError : this.result.getFieldErrors()){
                String buider =
                        getErrorType().getErrorCodeType()
                        + DOT_SEPARATOR + fieldError.getField()
                        + DOT_SEPARATOR + fieldError.getCode();
                list.add(buider);
            }
        }
        return list;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.INPUT;
    }
}
