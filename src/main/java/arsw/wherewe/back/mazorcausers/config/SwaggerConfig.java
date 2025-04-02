package arsw.wherewe.back.mazorcausers.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mazorca Users API")
                        .version("1.0.0")
                        .description("API for managing users in the Mazorca Users service")
                        .contact(new Contact()
                                .name("Team Picada")
                                .email("picadaarsw2025@outlook.com")));
    }
}
