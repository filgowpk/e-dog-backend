package org.pk.edog.config;

import org.pk.edog.model.converter.CharacteristicConverter;
import org.pk.edog.model.converter.ColorConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ColorConverter colorConverter;
    private final CharacteristicConverter characteristicConverter;

    public WebConfig(ColorConverter colorConverter, CharacteristicConverter characteristicConverter) {
        this.colorConverter = colorConverter;
        this.characteristicConverter = characteristicConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(colorConverter);
        registry.addConverter(characteristicConverter);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://e-dog-frontend.onrender.com")
                .allowedMethods("*");
    }
}