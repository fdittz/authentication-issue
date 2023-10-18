package com.authentication;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
            title = "${micronaut.application.name}"
    )
)
public class RestApplication {

    public static void main(String[] args) {
        Micronaut.run(RestApplication.class, args);
    }
}