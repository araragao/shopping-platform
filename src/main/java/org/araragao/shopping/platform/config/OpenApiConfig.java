package org.araragao.shopping.platform.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Shopping platform")
                .description(
                    "Shopping platform aims to provide a REST API that allows users to get "
                  + "price quotations based on order's amount, related product and discount policy.")
                .version("1.0.0")
                .contact(
                    new Contact()
                        .name("André Aragão")
                        .url("https://andreribeiroaragao.com")
                        .email("business@andreribeiroaragao.com"))
                .license(new License().name("MIT License").url("https://mit-license.org")));
  }
}
