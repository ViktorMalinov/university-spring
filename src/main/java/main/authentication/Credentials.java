package main.authentication;

import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class Credentials {
    public Authentication getAuthentication() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if( securityContext == null ) return null;
        else return securityContext.getAuthentication();
    }
}
