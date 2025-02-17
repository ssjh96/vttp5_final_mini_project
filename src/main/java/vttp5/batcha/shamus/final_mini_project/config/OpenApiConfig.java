package vttp5.batcha.shamus.final_mini_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig 
{
    @Bean
    public OpenAPI openAPI()
    {
        return new OpenAPI().info(
            new Info()
            .title("Final Mini Project")
            .description("Built by Shamus Sweee, Batch A, VTTP 5")
            .version("1.0")
        );
    }
}
