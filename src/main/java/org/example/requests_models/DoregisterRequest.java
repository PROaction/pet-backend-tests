package org.example.requests_models;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DoregisterRequest {
    private String email;
    private String name;
    private String password;
}
