package com.authentication.infrastructure.dataprovider.adapter;

import com.authentication.repository.ResourceRepository;
import com.authentication.infrastructure.dataprovider.entity.ResourceEntity;
import com.authentication.infrastructure.dataprovider.repository.ResourceReactorCrudRepository;
import com.authentication.usecase.FindResourceUseCase;
import io.micronaut.security.utils.SecurityService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Singleton
public class ResourceReactorRepositoryAdapter implements ResourceRepository {

    private final ResourceReactorCrudRepository resourceReactorCrudRepository;
    private final SecurityService securityService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceReactorRepositoryAdapter.class);


    @Override
    public Mono<ResourceEntity> findByResourceId(String id) {
        LOGGER.info("securityService.getAuthentication().isPresent(): {}", securityService.getAuthentication().isPresent());
        return resourceReactorCrudRepository
                .findByResourceId(id);
    }


}
