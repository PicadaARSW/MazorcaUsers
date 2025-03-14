package arsw.wherewe.back.mazorcausers.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig class for CORS configuration
 */
public class CorsConfig implements WebMvcConfigurer {
    /**
     * Add CORS mappings
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //Permitir todos los origenes
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
