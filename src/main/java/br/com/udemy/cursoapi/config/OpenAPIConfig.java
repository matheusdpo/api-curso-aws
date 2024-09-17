package br.com.udemy.cursoapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Bucetuda")
                        .version("v1")
                        .description("api que buceta tudo nessa porra")
                        .termsOfService("http://www.google.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://www.google.com")
                        )
                );
    }

}