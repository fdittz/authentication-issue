package com.authentication.repository;

import com.authentication.infrastructure.dataprovider.entity.ResourceEntity;
import io.micronaut.security.authentication.Authentication;
import reactor.core.publisher.Mono;

public interface ResourceRepository {

    Mono<ResourceEntity> findByResourceId(String id);

}
