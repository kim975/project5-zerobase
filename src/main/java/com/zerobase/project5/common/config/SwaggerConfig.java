package com.zerobase.project5.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "제로 베이스 5차 실습",
                description = "제로 베이스 5차 실습 Swagger 입니다.",
                version = "1.0"))
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components());
    }
}
