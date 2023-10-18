package com.authentication.infrastructure.endpoint;

import com.authentication.repository.ResourceRepository;
import com.authentication.infrastructure.dataprovider.entity.ResourceEntity;
import com.authentication.usecase.FindResourceUseCase;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.utils.SecurityService;
import io.micronaut.validation.Validated;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Validated
@Controller("/api/resource")
public class ResourceEndpoint {


    private final FindResourceUseCase findResourceUseCase;
    private final ResourceRepository resourceRepository;
    private final SecurityService securityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceEndpoint.class);
    @Get("/repository")
    public Mono<HttpResponse<ResourceEntity>> findResourceAfterRepositoryMethod() {
        ResourceEntity resource = new ResourceEntity();
        LOGGER.info("securityService.getAuthentication().isPresent(): {}", securityService.getAuthentication().isPresent());
        resource.setResourceId("test");
        return findResourceUseCase.executeAfterRepositoryMethod(resource)
                .map(savedResource -> HttpResponse.status(HttpStatus.CREATED)
                                .body(savedResource)
                );
    }

    @Get()
    public Mono<HttpResponse<ResourceEntity>> findResource() {
        ResourceEntity resource = new ResourceEntity();
        LOGGER.info("securityService.getAuthentication().isPresent(): {}", securityService.getAuthentication().isPresent());
        resource.setResourceId("test");
        return findResourceUseCase.execute(resource)
                .map(savedResource -> HttpResponse.status(HttpStatus.CREATED)
                        .body(savedResource)
                );
    }

}
