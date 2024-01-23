package com.planets.starwars.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        License license = new License()
                .name("MIT")
                .url("https://github.com/Joao-Darwin/planets-starwars-api/blob/main/LICENSE");

        Info info = new Info()
                .title("Planet StarWars API")
                .description("Uma API para a manutenção de planetas do starwars, conectando com a API oficial")
                .version("v1")
                .license(license);

        return new OpenAPI()
                .info(info);
    }
}
