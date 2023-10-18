package com.authentication.infrastructure.dataprovider.entity;


import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Serdeable
@Entity
public class ResourceEntity {

    @Id
    private Long uid;

    private String resourceId;

    private String description;
}
