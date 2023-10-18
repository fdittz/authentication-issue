package com.authentication.usecase;

import com.authentication.infrastructure.dataprovider.entity.ResourceEntity;
import reactor.core.publisher.Mono;

public interface FindResourceUseCase {

    Mono<ResourceEntity> executeAfterRepositoryMethod(ResourceEntity resource);

    Mono<ResourceEntity> execute(ResourceEntity resource);
}
