package com.authentication.infrastructure.dataprovider.repository;

import com.authentication.infrastructure.dataprovider.entity.ResourceEntity;

import io.micronaut.data.annotation.Repository;

import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import reactor.core.publisher.Mono;

@Repository
public interface ResourceReactorCrudRepository extends ReactorCrudRepository<ResourceEntity, Long> {
    Mono<ResourceEntity> findByResourceId(String resourceId);



}

