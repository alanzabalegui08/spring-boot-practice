package com.tdd.erros;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class TodoValidationErrorBuilder {
    public static TodoValidationError fromBindingErros(Errors errors) {
        TodoValidationError error = new TodoValidationError("Validation filed. "+  errors.getErrorCount() + " error(s) ");
        for(ObjectError objectError : errors.getAllErrors()){
            error.addValidationError(objectError.getDefaultMessage());
        }

        return error;
    }
}
