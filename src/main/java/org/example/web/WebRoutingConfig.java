package org.example.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebRoutingConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/film/{id:\\d+}")
                .setViewName("forward:/film.html");
        registry.addViewController("/acteur/{id:\\d+}")
                .setViewName("forward:/acteur.html");
        registry.addViewController("/realisateur/{id:\\d+}")
                .setViewName("forward:/realisateur.html");
        registry.addViewController("/login")
                .setViewName("forward:/login.html");
        registry.addViewController("/register")
                .setViewName("forward:/register.html");
        registry.addViewController("/recherche")
                .setViewName("forward:/formulaireRechercheFilm.html");
        registry.addViewController("/location/{id:\\d+}")
                .setViewName("forward:/location.html");
        registry.addViewController("/analytics")
                .setViewName("forward:/analytics.html");
    }
}
