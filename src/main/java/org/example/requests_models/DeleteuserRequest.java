package org.example.requests_models;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DeleteuserRequest {
    private String email;
}
