package pl.aui.DateAndTime.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import pl.aui.DateAndTime.rest.DateResourceImpl;
import pl.aui.DateAndTime.security.CorsFilter;

@Configuration
public class ServicesConfig extends ResourceConfig {

    public ServicesConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(DateResourceImpl.class);
        register(CorsFilter.class);
    }
}
