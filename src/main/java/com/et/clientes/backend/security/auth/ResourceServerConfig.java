package com.et.clientes.backend.security.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/* reglas de OAuth */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // endpoints publicos con permisos para todos
                .antMatchers( HttpMethod.GET
                        , "/api/cliente"
                ).permitAll()
                .anyRequest()
                .authenticated()
                .and().cors().configurationSource( corsConfigurationSource() );
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        // registramos la url de la aplicacion que accedera al backend para que no tenga probela de cors
        corsConfig.setAllowedOrigins( Arrays.asList( "http://localhost:4200" ) );
        // registramos los metodos Http habilitados
        corsConfig.setAllowedMethods( Arrays.asList( "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH" ) );
        // para permitir credenciales debemos setear en true
        corsConfig.setAllowCredentials( true );
        // registramos las cabeceras http autorizadas
        corsConfig.setAllowedHeaders( Arrays.asList( "Content-Type", "Authorization" ) );

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration( "/**", corsConfig );
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>( new CorsFilter( corsConfigurationSource() ) );
        bean.setOrder( Ordered.HIGHEST_PRECEDENCE );
        return bean;
    }
}
