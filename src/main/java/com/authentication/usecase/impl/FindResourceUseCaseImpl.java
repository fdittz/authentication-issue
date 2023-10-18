package com.authentication.usecase.impl;

import com.authentication.infrastructure.dataprovider.adapter.ResourceReactorRepositoryAdapter;
import com.authentication.infrastructure.dataprovider.entity.ResourceEntity;
import com.authentication.infrastructure.dataprovider.repository.ResourceReactorCrudRepository;
import com.authentication.usecase.FindResourceUseCase;
import io.micronaut.security.utils.SecurityService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class FindResourceUseCaseImpl implements FindResourceUseCase {

    private final ResourceReactorCrudRepository resourceRepository;
    private final SecurityService securityService;
    private final ResourceReactorRepositoryAdapter resourceReactorRepositoryAdapter;
    private static final Logger LOGGER = LoggerFactory.getLogger(FindResourceUseCase.class);

    @Override
    public Mono<ResourceEntity> executeAfterRepositoryMethod(ResourceEntity resource) {
        LOGGER.info("securityService.getAuthentication().isPresent(): {}", securityService.getAuthentication().isPresent());
        return resourceRepository.count()
                .flatMap(res -> resourceReactorRepositoryAdapter.findByResourceId(resource.getResourceId())).then(Mono.just(resource));
    }

    public Mono<ResourceEntity> execute(ResourceEntity resource) {
        LOGGER.info("securityService.getAuthentication().isPresent(): {}", securityService.getAuthentication().isPresent());
        return resourceReactorRepositoryAdapter.findByResourceId(resource.getResourceId());
    }

}
