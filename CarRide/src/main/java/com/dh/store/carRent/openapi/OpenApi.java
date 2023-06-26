package com.dh.store.carRent.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenApi {
    @Value("${serverpublic}")
    private String serverpublic;
    @Bean
    public OpenAPI customOpenAPI() {
        Server devServer = new Server();

        devServer.url("http://"+serverpublic+"/api/v1/carrent");
        devServer.setDescription("Development server");

        Contact contact = new Contact();
        contact.setName("Grupo7-CTD");

        License mitLicense = new License().name("MIT License").url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("CarRent API")
                .description("API para la pagina de Reservas CARRENT")
                .version("1.0.0")
                .contact(contact)
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .components(new Components().addSecuritySchemes("bearer-key", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .addServersItem(devServer);
    }
}

