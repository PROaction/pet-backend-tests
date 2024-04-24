package org.example.response_models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class DeleteuserResponse {
    private String type;
    private String message;

    public void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<DeleteuserResponse>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<DeleteuserResponse> violation : violations) {
                throw new RuntimeException(violation.getMessage());
            }
        }
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "DeleteuserResponse{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}