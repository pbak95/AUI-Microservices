package pl.aui.DateAndTime.security;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) {
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Credentials", "true");
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST");
    }
}
