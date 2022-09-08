package com.example.simple_rest_api.model;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

public record LiveStream(
        @Id
        UUID ID,
        @NotEmpty @NotNull
        String title,
        String description,
        String url,
        Timestamp startDate,
        Timestamp endDate
) {
}
