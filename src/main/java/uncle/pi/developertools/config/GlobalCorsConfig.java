package uncle.pi.developertools.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Usage:
 * @Author: by Daniel
 * @Date: 2024/4/24 01:20
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 允许从某个端口发起的全部跨源请求
                registry.addMapping("/api/**").allowedOrigins("http://localhost:3000").allowedMethods("*");
            }
        };
    }
}