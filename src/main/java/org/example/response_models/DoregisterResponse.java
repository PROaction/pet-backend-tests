package org.example.response_models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class DoregisterResponse {
    @Size(min = 1, max = 100, message = "Имя должно быть длиной от 1 до 100")
    private String name;
    private String avatar;
    private String password;
    private String birthday;
    private String email;
    private String gender;
    private String date_start;
    private String hobby;

    public void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<DoregisterResponse>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<DoregisterResponse> violation : violations) {
                throw new RuntimeException(violation.getMessage());
            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DoregisterResponse{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", date_start='" + date_start + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
